import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class land_terrain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LandTerrain extends Composite
{
    /**
     * Act - do whatever the land_terrain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        display();

    }  
    
    public void display() 
    {
        Component c;
        Actor obj, land;
        World myWorld = getWorld();

        c = getChild(0);    

        land = (Actor) c;
        myWorld.addObject(land,0,getY());   // adding land 


        int x = 50;
        
        for (int i=1; i<12; i++) {

            c = getChild(i);
            obj = (Actor)c;
            if (i< 7)
                myWorld.addObject(obj,x,getY());  //adding trees and rocks
            else
                myWorld.addObject(obj,x,getY()-25);  //adding trees and rocks

            x+=100;

        }
 
    } 
}
