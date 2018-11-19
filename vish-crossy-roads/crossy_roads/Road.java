import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class river here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Road extends Leaf
{
    /**
     * Act - do whatever the river wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int Y=0;
    public void display() {
        
       // addObject(this, 67, 25);
       
       World myWorld = getWorld();
       if (myWorld != null)
            myWorld.addObject(this,67,25);
        
    }
    public void act() 
    {
        World world = getWorld();
        
        
        // Add your action code here.
        int worldX = world.getWidth();
        
        int worldY = world.getHeight();
        if(Level1Strategy.getFinalLevelState()==false)
            setLocation((getX())%worldX, (getY()+1)%worldY);
    }  
    public void update(){
    }
    
}
