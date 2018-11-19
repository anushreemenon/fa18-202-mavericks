import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class car_blue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CarBlue extends Leaf
{
    /**
     * Act - do whatever the car_blue wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int Y=0;
    public void act() 
    {
        World world = getWorld();
        // Add your action code here.
        int worldX = world.getWidth();
        
        int worldY = world.getHeight();
        int pos = 0;
        if (getX() == 0)
            pos = 1200;
        else
            pos = 0;
            
        if(Level1Strategy.getFinalLevelState()==false)
            setLocation((pos + getX()- 2), (getY()+1)%worldY);
    }
    public void update(){
    }    
}
