import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Leaf
{
    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 2; //movement speed  
    private int vSpeed = 0; //vertical speed  
    private int acceleration = 2; //gravity effect while falling  
    private int jumpStrength = -8; 
    public void act() 
    {
        boolean onLog = false, onWater = false;
        World myWorld = getWorld();
        List<LifeCounter> lcs = myWorld.getObjects(LifeCounter.class);   
        LifeCounter lc = lcs.get(0);

        if (isTouching(Car.class) || isTouching(CarBlue.class)) {
            lc.lostLife();
        }
        
        List<River> r = getIntersectingObjects(River.class);
        if (r.size() > 0) {
             onWater = true;
             List<Log> logs = getNeighbours(150, true, Log.class);
             System.out.println("Logs count is " + logs.size());
             
             if (logs.size()>0) {
                 System.out.println("Log found");
                 onLog = true;
             }
        }
        else {
            // System.out.println("Not on water");
            onWater = false;
        }
        
        if (onLog && onWater) {
            //safe.. do nothing
        } else if (onWater) {
                lc.lostLife();
        }
        
        checkKeys();
    }  

    private boolean checkObstacle(int dx, int dy) {
        if(getObjectsAtOffset(dx, dy, Tree.class).size() == 0) {
            if(getObjectsAtOffset(dx, dy, Rock.class).size() == 0)
                return false;
        }
        return true;
    }

    public void checkKeys()
    {
        boolean obstacle = true;
        if( Greenfoot.isKeyDown("left"))
        {
            obstacle = checkObstacle(-10, 0);
            if(!obstacle)
                move(-5);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            obstacle = checkObstacle(10, 0);
            if(!obstacle)
                move(5);
        }
        else if(Greenfoot.isKeyDown("up")) 
        { 
            jump("up");
        }
        else if(Greenfoot.isKeyDown("down")) 
        {
            jump("down");
        }
        else {
            // Drag player down if he stands at one place and doesn't move
            World world = getWorld();
            int worldX = world.getWidth();      
            int worldY = world.getHeight();
            if(Level1Strategy.getFinalLevelState()==false)
                setLocation(getX(), getY()+1);
            
            if(isAtEdge()) {
                    // Stop the level
                    // TODO: Stop only when the Player reaches the lowermost edge of the world. Otherwise, do nothing.
                    ((MyWorld)world).lostLife();
            }
        }

    }

    public void jump(String keyEvent)  
    {  

        vSpeed = jumpStrength;  
        if(keyEvent.equals("up"))
            fall();   
        else
            fallDown();
    }


    public void fall()  
    {  
        boolean obstacle = checkObstacle(0, vSpeed*2);
        if(!obstacle) {
            setLocation(getX(), getY()+vSpeed);  
            vSpeed = vSpeed + acceleration;  
        }
    }
    
    public void fallDown()  
    {  
        boolean obstacle = checkObstacle(0, -vSpeed*2);
        if(!obstacle) {
            setLocation(getX(), getY()-vSpeed);  
            vSpeed = vSpeed - acceleration;  
        }
    }   
}


