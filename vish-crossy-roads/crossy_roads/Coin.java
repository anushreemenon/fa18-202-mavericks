import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Leaf
{
    
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
        if (!world.isActionPaused())
        {
            
            if(isTouching(Player.class)) {
                Greenfoot.playSound("coin.wav");
                world.incrementCoinCount();
                world.removeObject(this);
                
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
