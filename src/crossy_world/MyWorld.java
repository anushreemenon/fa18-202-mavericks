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
    
    private Sound music;

   
    private static int level;
    private Actor levelBoard;
    private Actor levelBoardDecorator;
    private CoinBoard coinBoard;
    private LifeCounter lifeCounter;
    private Boolean actionPaused;
    private Boolean levelLoaded;
    private Mediator mediator;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

        super(1200, 800, 1);
        level = 1;
        levelBoard = new LevelBoard ();
        ((LevelBoard)levelBoard).setLevel(level);
        levelBoardDecorator = new LevelBoardDecorator((ILevelBoardDecorator) levelBoard);
        coinBoard = CoinBoard.getInstance();
        lifeCounter = LifeCounter.getInstance ();
        lifeCounter.resetLifeCounter();
        coinBoard.resetCoinBoard();
        setPaintOrder(Player.class, ScoreBoard.class, LifeCounter.class, LevelBoardDecorator.class, CoinCounter.class, Coin.class, DisplayMessage.class, Level1Strategy.class);
        currentLevel = new Level1Strategy();
        music = Sound.getInstance();
        mediator = new Mediator();
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

        addObject((Actor)mediator,0,0);
        addObject((Actor)coinBoard,0,0);
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
     * Returns whether the current gamestate is paused (true) or not (false)
     */
    public boolean getActionPaused ()
    {
        return actionPaused;
    }

    public void setActionPaused() {
        actionPaused = true;
    }

    public void resetActionPaused() {
        actionPaused = false;
    }

    public boolean getLevelLoaded ()
    {
        return levelLoaded;
    }

    public void setLevelLoaded() {
        levelLoaded = true;
    }

    public void resetLevelLoaded() {
        levelLoaded = false;
    }

    public void setNextLevel()
    {
        actionPaused = true;
        if (currentLevel.getClass().getName() == "Level1Strategy") {
            level+=1;
            mediator.displayLevelScore(currentLevel.levelInfo());
            currentLevel = new Level2Strategy();
            ((LevelBoard)levelBoard).setLevel(level);
        }
        else if (currentLevel.getClass().getName() == "Level2Strategy") {
            level+=1;
            mediator.displayLevelScore(currentLevel.levelInfo());
            ((LevelBoard)levelBoard).setLevel(level);
            currentLevel = new Level3Strategy();
        }
        else
            mediator.endGame();
        
        levelLoaded = false;
        actionPaused = false;
        
    }

    public void resetTimer() {
        currentLevel.resetTimer();
    }
}
