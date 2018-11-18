import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Font;
import greenfoot.Color;

/**
 * Write a description of class LevelCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelBoard extends Actor
{
    private GreenfootImage image = new GreenfootImage (132, 40);
    private Color backgroundColor = new Color (50,50,50);
    private Color textColor = new Color (255,216,0);
    private Font textFont = new greenfoot.Font ("Arial", true, false, 28);

    public LevelBoard ()
    {
        image.setFont (textFont);
        this.setImage (image);
        setLevel (0);
    }

    public void setLevel (int level)
    {
        image.setColor (backgroundColor);
        image.fill();
        image.setColor (textColor);
        String s = "LEVEL " + level;
        image.drawString(s, 1, 32);
    }

}
