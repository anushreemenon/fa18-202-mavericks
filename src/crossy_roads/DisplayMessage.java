import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DisplayMessage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DisplayMessage extends Actor
{
    private GreenfootImage image;
    private Color backgroundColor;
    private Color textColor;
    private Font textFont;
    
    public DisplayMessage (String str)
    {
        image = new GreenfootImage (60, 60);
        textColor = new Color (255,216,0);
        textFont = new greenfoot.Font ("Arial", true, false, 28);
        image.setFont (textFont);
        this.setImage (image);
        image.setColor (textColor);
        updateMessage (str);
    }

    public void updateMessage (String str)
    {
        image.clear();
        image.drawString(str, 10, 32);
    }
    /**
     * Act - do whatever the DisplayMessage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
