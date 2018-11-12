import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Font;
//import java.awt.Color;
//import java.awt.Font;

/**
 * Write a description of class LevelCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelCounter extends Actor
{
    private GreenfootImage levelBoard = new GreenfootImage (132, 40);
    private Color backgroundColor = new Color (108, 108, 108);
    private Color textColor = new Color (255,216,0);
    private Font textFont = new greenfoot.Font ("Arial", true, false, 28);

    public LevelCounter ()
    {
        levelBoard.setColor (backgroundColor);
        levelBoard.setFont (textFont);
        levelBoard.fill();
        this.setImage (levelBoard);
        setLevel (0);
    }

    public void setLevel (int level)
    {
        levelBoard.setColor (backgroundColor);
        levelBoard.fill();
        levelBoard.setColor (textColor);
        String s = "LEVEL " + level;
        levelBoard.drawString(s, 1, 32);
    }

}
