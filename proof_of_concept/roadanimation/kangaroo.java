import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class kangaroo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class kangaroo extends Actor
{
    /**
     * Act - do whatever the kangaroo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        World world = getWorld();
        // Add your action code here.
        int worldX = world.getWidth();
        int worldY = world.getHeight();
        setLocation((getX()+1)%worldX, (getY()+1)%worldY);
    }    
}
