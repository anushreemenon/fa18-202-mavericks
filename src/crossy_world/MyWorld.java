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
    
    private LevelStrategy currentLevel;
    private int currentScore;
    private int noOfCoinsCollected;
    private int currentNoOfLives;
    private Sound music;

   
    private static int level;
    private Actor levelBoard;
    private Actor levelBoardDecorator;
    private CoinBoard coinBoard;
    private LifeCounter lifeCounter;
    private Boolean actionPaused;
    private Boolean levelLoaded;
    private GreenfootImage boom;
 
  
 
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

        super(1200, 800, 1);
        level = 1;
        levelBoard = new LevelBoard ();
        ((LevelBoard)levelBoard).setLevel(level);
        levelBoardDecorator = new LevelBoardDecorator((ILevelBoardDecorator) levelBoard);
        coinBoard = new CoinBoard (this);
        lifeCounter = new LifeCounter ();
        setPaintOrder(Player.class, ScoreBoard.class, LifeCounter.class, LevelBoardDecorator.class, CoinCounter.class, Coin.class, DisplayMessage.class, Level1Strategy.class);
        currentLevel = new Level1Strategy();
        boom = new GreenfootImage ("boom.png");
        music = Sound.getInstance();
        loadLevel();
        
    }
    
    public void act ()
    {
        if (!levelLoaded) {
            loadLevel();
            levelLoaded = true;
        }
    }
    void loadLevel() { 
        List objects = getObjects(null);
        removeObjects(objects);
        currentLevel.setFinishLevel(false);
        addObject((Actor) currentLevel,67,25);
        addObject ((Actor)levelBoardDecorator, 70, 750);
        ((LevelBoardDecorator)levelBoardDecorator).showLevelBoard();
        coinBoard.loadCoinBoard();
        currentLevel.loadTerrains();
        lifeCounter.drawLifeCounter();
        addObject (lifeCounter,  130, 100);
        music.playBackGroundMusic();
        levelLoaded = true;
        actionPaused = false;
    }
    /**
     * The Act method is responsible for:
     *      loading new levels and death screens
     *      Triggering scoreboard and end the game
     *      
     */
    public void endGame ()
    {
        music.pauseBackGround();
        ScoreBoard s = new ScoreBoard (coinBoard.getCoinCount() , "Game Over", "Score: ");
        addObject (s, getWidth()/2,getHeight()/2);
        music.playGameOver();
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
        music.pauseBackGround();
        boom.scale(80,80);
        List<Player> objects = getObjects(Player.class);
        objects.get(0).setImage(boom);
        lifeCounter.lostLife();
        music.playExplosion();
        actionPaused = true;
        levelLoaded = false;
        currentLevel.resetTimer();
        Greenfoot.delay(50);
    }

    /**
     * Returns whether the current gamestate is paused (true) or not (false)
     */
    public boolean isActionPaused ()
    {
        return actionPaused;
    }
    
    public void setNextLevel()
    {
        actionPaused = true;
        if (currentLevel.getClass().getName() == "Level1Strategy") {
            currentLevel = new Level2Strategy();
            level+=1;
            ScoreBoard s = new ScoreBoard (coinBoard.getCoinCount() , "Level 1 crossed!", "Score: ");
            addObject (s, getWidth()/2,getHeight()/2);
            Greenfoot.playSound("GameOver.wav");
            Greenfoot.delay(250);
            ((LevelBoard)levelBoard).setLevel(level);
        }
        else if (currentLevel.getClass().getName() == "Level2Strategy") {
            level+=1;
            ScoreBoard s = new ScoreBoard (coinBoard.getCoinCount() , "Level 2 crossed!", "Score: ");
            addObject (s, getWidth()/2,getHeight()/2);
            Greenfoot.playSound("GameOver.wav");
            Greenfoot.delay(250);
            ((LevelBoard)levelBoard).setLevel(level);
            currentLevel = new Level3Strategy();
        }
        else
            endGame();
        
        levelLoaded = false;
        actionPaused = false;
        
    }


}
