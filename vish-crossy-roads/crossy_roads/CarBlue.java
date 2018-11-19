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
    public void act() 
    {
            int pos = 0;
            if (getX() == 0) {
                pos = 1200;
            }
             else {
                pos = 0;
            }
             
            setLocation(pos + getX() - 1, getY()); // Add your action code here.
    }    
}
