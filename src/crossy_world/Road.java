import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class river here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Road extends Leaf
{

    public Road() {
        this.getImage().scale(2500,100);
    }
    /**
     * Act - do whatever the river wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int Y=0;
    public void display() {
       World myWorld = getWorld();
       if (myWorld != null)
            myWorld.addObject(this,67,25);
    }
    
    public void update(){
    }
    
}
