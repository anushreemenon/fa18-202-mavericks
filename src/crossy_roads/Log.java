import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class log here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Log extends Leaf implements Cloneable
{
    private LevelStrategy currentStrategy;
    private boolean isFinishLevelReached = false;
    public Log() {
        this.getImage().scale(120,30);
    }
        
      @Override 
      public Log clone() throws CloneNotSupportedException {
          return (Log) super.clone();
      }
      
    public void attachStrategy(LevelStrategy s) {
       currentStrategy = s;
    }
    
    private static int Y=0;
    /**
     * Act - do whatever the log wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       //setLocation (getX() - 5, getY());
        World world = getWorld();
        // Add your action code here.
        int worldX = world.getWidth();
        
        int worldY = world.getHeight();
        int pos = 0;
        if (getX() == 0)
            pos = 1200;
        else
            pos = 0;
            
        if(getFinishLevel()==false)
            setLocation((pos + getX()- currentStrategy.getLogSpeed()), (getY()+1)%worldY);
    }    
    
    public void display() {
    }

    public void update(boolean state){
        this.isFinishLevelReached =  state;
    }
    public boolean getFinishLevel(){
        return isFinishLevelReached;
    }
}
