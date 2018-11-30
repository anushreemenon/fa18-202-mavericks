import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
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
    static final int MAX_LIVES = 5;
    static final int DEFAULT_LIVES = 3;

    private static LifeCounter life_counter_instance = null; 
    protected Mediator mediator;
    
    public static LifeCounter getInstance() 
    { 
        if (life_counter_instance == null) 
            life_counter_instance = new LifeCounter(); 
  
        return life_counter_instance; 
    } 
    public LifeCounter ()
    {
        livesLeft = DEFAULT_LIVES;
        drawLifeCounter();
        
    }

    public void lostLife()
    {
        //Reduce life count in the life counter board
        livesLeft--;
        drawLifeCounter();
        if (livesLeft <= 0){
            if (mediator == null){
                List<Mediator> objects = getWorld().getObjects(Mediator.class);
                mediator = objects.get(0);
            }
            mediator.endGame();
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
        if (livesLeft < MAX_LIVES){
            livesLeft++;
            drawLifeCounter();
            Greenfoot.playSound("powerup.wav");
        }
    }

    
    
}
