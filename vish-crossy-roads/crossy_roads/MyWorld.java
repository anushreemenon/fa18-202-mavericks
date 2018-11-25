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
    private GreenfootSound gameOverSound;
   
    static final int DEFAULT_MAX_LEVELS = 3;
    static final int level = 1;
    private LevelBoard levelBoard;
    private CoinBoard coinBoard;
    private LifeCounter lifeCounter;
    
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        levelBoard = new LevelBoard ();
        coinBoard = new CoinBoard (this);
        levelBoard.setLevel(level);

        currentLevel = new Level1Strategy();
        currentLevel.setFinalLevelState(false);
        
        setPaintOrder(Player.class, ScoreBoard.class, LifeCounter.class, LevelBoard.class, CoinCounter.class, Coin.class, DisplayMessage.class, Level1Strategy.class);
        addObject(currentLevel,67,25);
        addObject (levelBoard, 70, 750);
        coinBoard.loadCoinBoard();
        currentLevel.loadTerrains();
        lifeCounter = new LifeCounter ();
        // Add the life counter to the World
        addObject (lifeCounter,  130, 100);
        gameOverSound = new GreenfootSound("GameOver.wav");
        
    }

    /**
     * The Act method is responsible for:
     *      loading new levels and death screens
     *      Triggering scoreboard and end the game
     *      Spawning cars
     */
    public void endGame ()
    {
        ScoreBoard s = new ScoreBoard (coinBoard.getCoinCount() , "Game Over", "Score: ");
        addObject (s, getWidth()/2,getHeight()/2);
        gameOverSound.play();
        // End program
        Greenfoot.stop();  
    }

    public void incrementCoinCount() {
        coinBoard.incrementCount();

    }

    public void powerUp() {
        lifeCounter.powerUp();
    }

    public void lostLife() {
        lifeCounter.lostLife();
    }

}
