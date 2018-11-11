import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(850, 800, 1); 
        
        road road1 = new road();
        road road2 = new road();
        car car11 = new car();
        car car21 = new car();
        car car12 = new car();
        car car22 = new car();
        kangaroo kangaroo1 = new kangaroo();
        River river1 = new River();
        Crocodile croc1 = new Crocodile();
        Player player1 = new Player();
        
        Tree tree1 = new Tree();
        addObject(road1, 425, 100);
        addObject(car11, 500, 100);
        addObject(road2, 425, 300);
        addObject(car21, 550, 300);
        
        addObject(car12, 650, 100);
        addObject(car22, 700, 300);
        
        addObject(tree1, 550, 200);
        addObject(kangaroo1, 600, 200);
        addObject(river1, 500, 600);
        addObject(croc1, 500, 600);
        addObject(player1, 400, 80);
    }
    
}
