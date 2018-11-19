import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends greenfoot.World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    private Level1Strategy currentLevel;
    private int currentScore;
    private int noOfCoinsCollected;
    private int currentNoOfLives;
    
    static final int DEFAULT_MAX_LIVES = 3;
    static final int DEFAULT_MAX_LEVELS = 3;
 
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        
        currentLevel = new Level1Strategy();
        currentLevel.setFinalLevelState(false);
        
        addObject(currentLevel,67,25);
        
        //addObject(currentLevel,67,25);
        
        currentLevel.LoadTerrains();
        
        // Ensure that player is on top of everything else. This order needs to 
        // be revisited once all the terrains are set up
        setPaintOrder(Player.class);
        
        
        //composite terrains = new composite() ;
        


        // Add the road image to the World
        //addObject (rd, 67, 25);
       
    }

}
