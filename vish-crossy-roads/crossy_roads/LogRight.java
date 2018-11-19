import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class log here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LogRight extends Leaf
{
    /**
     * Act - do whatever the log wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int Y=0;

    public void act() 
    {
       int pos = 0;
       if (getX() == 0) {
         pos = 1200;
       }
       else {
          pos = 0;
       }
             
    setLocation(pos + getX() - 1, getY());
    
    }  

}

