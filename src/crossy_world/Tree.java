import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tree extends Leaf implements Cloneable
{

    public Tree() {
        this.getImage().scale(30,60);
    }
    /**
     * Act - do whatever the rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     
    public void update(){
    }
    
      @Override 
      public Tree clone() throws CloneNotSupportedException {
          return (Tree) super.clone();
      }
}

