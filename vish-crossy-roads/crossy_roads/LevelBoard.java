import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Font;
import greenfoot.Color;

/**
 * Write a description of class LevelCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelBoard extends Actor implements ILevelBoardDecorator
{
    private GreenfootImage image = new GreenfootImage (132, 40);
    private Color backgroundColor = new Color (50,50,50);
    private Color textColor = new Color (255,216,0);
    private Font textFont = new greenfoot.Font ("Arial", true, false, 28);
	private int level = 0;

    public LevelBoard ()
    {
        image.setFont (textFont);
        this.setImage (image);
        setLevel (0);
    }
	
	public GreenfootImage getImage() {
		return image;
	}
	
	public Color getBackgroundColor() {
		return this.backgroundColor;
	}
	
	public Color getTextColor() {
		return this.textColor;
	}
	
	public Font getFont() {
		return this.textFont;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public void showLevelBoard() {
		// System.out.println("Level: " + this.level);
	}
	
    public void setLevel(int level)
    {
        this.level = level;
    }
}
