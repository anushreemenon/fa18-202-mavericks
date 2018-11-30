import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Leaf
{
    protected Mediator mediator = null;
    private boolean isFinishLevelReached = false;
    public Coin() {
        this.getImage().scale(50, 50);
    }
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MyWorld world =  getWorldOfType(MyWorld.class);
        if (!world.getActionPaused() )
        {
            
            if(isTouching(Player.class)) {
                world.removeObject(this);   
                Greenfoot.playSound("coin.wav");
                if (mediator == null){
                    List<Mediator> objects = world.getObjects(Mediator.class);
                    mediator = objects.get(0);
                }
                mediator.incrementCoinCount();
            } else {
                int worldX = world.getWidth();
                
                int worldY = world.getHeight();
                if(getFinishLevel()==false)   
                    setLocation((getX())%worldX, (getY()+1)%worldY);
            }
        }
    }   
    public void update(boolean state){
        this.isFinishLevelReached =  state;
    }
    public boolean getFinishLevel(){
        return isFinishLevelReached;
    }

  
}
