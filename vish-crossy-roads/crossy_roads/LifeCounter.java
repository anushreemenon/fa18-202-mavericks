import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LifeCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LifeCounter extends Actor
{
    
    private int livesLeft;
    
    private GreenfootImage player = new GreenfootImage ("boy2.png");
    private GreenfootImage image = new GreenfootImage (200,200);
    static final int DEFAULT_MAX_LIVES = 3;
    public LifeCounter ()
    {
        livesLeft = DEFAULT_MAX_LIVES;
        drawLifeCounter();
    }

    public void lostLife()
    {
        //Reduce life count in the life counter board
        livesLeft--;
        drawLifeCounter();
        if (livesLeft <= 0){
            MyWorld myWorld =  getWorldOfType(MyWorld.class);
            myWorld.endGame();
        }
    }

    public void drawLifeCounter() {
        image.clear();
        for (int i = 0; i < livesLeft; i++) {
            image.drawImage (player, 1 + (i) * 42, 1);
        }
        this.setImage (image);
    }

    public void powerUp() {
        if (livesLeft < DEFAULT_MAX_LIVES){
            livesLeft++;
            drawLifeCounter();
            Greenfoot.playSound("powerup.wav");
        }
    }

    
    
}
