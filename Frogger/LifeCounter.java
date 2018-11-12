import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LifeCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LifeCounter extends Actor
{
    //declare the number of lives
    private int livesLeft;
    //set images for frog at different points
    private GreenfootImage frog = new GreenfootImage ("frog.png");
    private GreenfootImage splat = new GreenfootImage ("splat.png");
    private GreenfootImage lives = new GreenfootImage (126,40);
    
    public LifeCounter ()
    {
        //set number of lives
        lives.drawImage (frog, 1, 1);
        lives.drawImage (frog, 43, 1);
        lives.drawImage (frog, 85, 1);
        this.setImage (lives);
        
        livesLeft = 3;
    }

    public void subtractLife()
    {
        //take away lives and splat if needed
        livesLeft--;
        lives.drawImage (splat, 1 + (livesLeft) * 42, 1);
    }
    
}
