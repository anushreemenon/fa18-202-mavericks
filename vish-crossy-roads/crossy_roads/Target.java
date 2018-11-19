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
    public void act() 
    {
        List<Actor> actors = new ArrayList<Actor>();
        // Add your action code here.
        World world = getWorld();
        Actor player = world.getObjects(Player.class).get(0);
        
        int worldX = world.getWidth();
        
        int worldY = world.getHeight();
        
        if(Level1Strategy.getFinalLevelState()==false){
            
            setLocation((getX()), (getY()+1));}
        if(intersects(player)){
            Level1Strategy.setFinalLevelState(true);
        }
        
    }   
    public void update(){
    } 
}
