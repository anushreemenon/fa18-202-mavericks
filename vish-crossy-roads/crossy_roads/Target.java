import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Target here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Target extends Leaf
{
    /**
     * Act - do whatever the Target wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean isFinishLevelReached = false;
    private LevelStrategy strategy;
    public void act() 
    {
        List<Actor> actors = new ArrayList<Actor>();
        // Add your action code here.
        MyWorld world = (MyWorld)getWorld();
        Actor player = world.getObjects(Player.class).get(0);
        
        int worldX = world.getWidth();
        
        int worldY = world.getHeight();
        
        if(getFinishLevel()==false){
            setLocation((getX()), (getY()+1));
        }
        if(intersects(player)){
           strategy.setFinishLevel(true);
            //world.endGame();

        }
        
    }   

    public void update(boolean state){
        this.isFinishLevelReached =  state;
    }
    public boolean getFinishLevel(){
        return isFinishLevelReached;
    }
    public void attachStrategy(LevelStrategy levelStrategy){
        strategy = levelStrategy;
    }
}
