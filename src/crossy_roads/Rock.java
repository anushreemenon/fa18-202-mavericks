import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Leaf implements Cloneable {
    
  public Rock() {
      this.getImage().scale(50,50);
  }
  
  @Override 
  public Rock clone() throws CloneNotSupportedException {
    return (Rock) super.clone();
  }


  
    /**
     * Act - do whatever the rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int Y=0;
   
}
