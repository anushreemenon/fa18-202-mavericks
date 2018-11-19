import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Leaf
{
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
        if(isTouching(Player.class)) {
            world.incrementCoinCount();
            world.removeObject(this);
            Greenfoot.playSound("coin.wav");
        } else {
            int worldX = world.getWidth();
            
            int worldY = world.getHeight();
            if(Level1Strategy.getFinalLevelState()==false)   
                setLocation((getX())%worldX, (getY()+1)%worldY);
        }
    }   
    

  
}
