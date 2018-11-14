import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    public void act() 
    {
        checkKeys();
    }  
    
    private void checkKeys()
    {
            if (Greenfoot.isKeyDown("up"))
            {
                setLocation (getX(), getY() - 10);
            }
            if (Greenfoot.isKeyDown("down"))
            {
                setLocation (getX(), getY() + 10);
            }
            if (Greenfoot.isKeyDown("left"))
            {
                setLocation (getX() - 10, getY());
            }
            if (Greenfoot.isKeyDown("right"))
            {
                setLocation (getX()  + 10, getY());
            }
    }
}

