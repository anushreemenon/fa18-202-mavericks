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
    private boolean isFinishLevelReached = false;

    boolean onLog;
    MyWorld myworld;
    public void act() 
    {
        Actor log;
        onLog = false;
        if (!myworld.isActionPaused())
        {
           
            // List<LifeCounter> lcs = myWorld.getObjects(LifeCounter.class);   
            // LifeCounter lc = lcs.get(0);
            checkKeys();
            
            if (isTouching(Car.class) || isTouching(CarBlue.class)) {
                myworld.lostLife();
                // Greenfoot.delay(50);
            } else if (isTouching(River.class)) {
                List<River> river = myworld.getObjects(River.class);
                int riverY = river.get(0).getY();
                
                // System.out.println("River Y: "+ riverY + " PlayerY = " + getY());
            
                
                if (getY() > riverY-50){        //not yet crossed the river
                    List<Log> logs = getNeighbours(75, true, Log.class);
                    if (logs.size() <=0) {
                        myworld.lostLife();
                         Greenfoot.delay(50);
                    }
                    else {
                                if(!(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right"))) {
                                    for (int i=0; i<logs.size();i++) {
                                        log = (Actor)logs.get(i);
                                        if (intersects(log)) {
                                            setLocation(log.getX(),log.getY());
                                            break;
                                        }

                                    }
                                }
                 
                    }
            
                }
            }

        
        }
        
        
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
            //World world = getWorld();
            if(getFinishLevel()==false)
                    setLocation(getX(), getY()+1);
            
            if(isAtEdge()) {
                    // Stop the level
                    // TODO: Stop only when the Player reaches the lowermost edge of the world. Otherwise, do nothing.
                    myworld.lostLife();
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
    public void attachObserver(MyWorld myWorld){
        myworld = myWorld;
    }
    public void update(boolean state){
        this.isFinishLevelReached =  state;
    }
    public boolean getFinishLevel(){
        return isFinishLevelReached;
    }
}


