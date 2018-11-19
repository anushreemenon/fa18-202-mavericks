import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class river here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class River extends Leaf
{
    /**
     * Act - do whatever the river wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int Y=0;
    public void act() 
    {
        // Add your action code here.
         World myWorld = getWorld();
        int worldX = myWorld.getWidth();
        int worldY = myWorld.getHeight();
        if(Level1Strategy.getFinalLevelState()==false)
            setLocation((getX()%worldX), (getY()+1)%worldY);
    }
    public void display() {
         
    }
    public void update(){
    }
    
}