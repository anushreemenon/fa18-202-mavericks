import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

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
    private GreenfootSound explosionSound;
    private GreenfootSound powerUpSound;
   
    static final int DEFAULT_MAX_LEVELS = 3;
    static final int level = 1;
    private LevelBoard levelBoard;
    private CoinBoard coinBoard;
    private LifeCounter lifeCounter;
    private Boolean actionPaused;
    private Boolean levelLoaded;
    GreenfootSound backgroundMusic;
 
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        levelBoard = new LevelBoard ();
        coinBoard = new CoinBoard (this);
        lifeCounter = new LifeCounter ();
        levelBoard.setLevel(level);
        setPaintOrder(Player.class, ScoreBoard.class, LifeCounter.class, LevelBoard.class, CoinCounter.class, Coin.class, DisplayMessage.class, Level1Strategy.class);
        gameOverSound = new GreenfootSound("GameOver.wav");
        explosionSound = new GreenfootSound("explosion.wav");
        powerUpSound = new GreenfootSound("powerup.wav");
        backgroundMusic = new GreenfootSound("background.mp3");
        loadLevel();
        
    }
    public void act ()
    {
        if (!levelLoaded)
            loadLevel();
    }
    void loadLevel() { 
        List objects = getObjects(null);
        removeObjects(objects);
        currentLevel = new Level1Strategy();
        currentLevel.setFinalLevelState(false);
        addObject(currentLevel,67,25);
        addObject (levelBoard, 70, 750);
        coinBoard.loadCoinBoard();
        currentLevel.loadTerrains();
        lifeCounter.drawLifeCounter();
        addObject (lifeCounter,  130, 100);
        backgroundMusic.playLoop();
        levelLoaded = true;
        actionPaused = false;
    }
    /**
     * The Act method is responsible for:
     *      loading new levels and death screens
     *      Triggering scoreboard and end the game
     *      Spawning cars
     */
    public void endGame ()
    {
        backgroundMusic.pause();
        ScoreBoard s = new ScoreBoard (coinBoard.getCoinCount() , "Game Over", "Score: ");
        addObject (s, getWidth()/2,getHeight()/2);
        gameOverSound.play();
        // End program
        Greenfoot.stop();  
    }

    public void incrementCoinCount() {
        actionPaused = true;
        coinBoard.incrementCount();
        actionPaused = false;

    }

    public void powerUp() {
        lifeCounter.powerUp();
    }

    public void lostLife() {
        backgroundMusic.pause();
        lifeCounter.lostLife();
        explosionSound.play();
        actionPaused = true;
        levelLoaded = false;
        // startLevel();
    }

    /**
     * Returns whether the current gamestate is paused (true) or not (false)
     */
    public boolean isActionPaused ()
    {
        return actionPaused;
    }


}
