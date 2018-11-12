import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Controller Class. Owns and coordinates
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Desert extends World
{
    // Declare class variables
    private int counter = 0;
    private int spawnRate;
    private int spawnY;
    private int vehicleSpeed;

    private int lives = 3;

    private int level;
    private int autoCount;

    private boolean levelLoaded = false;
    private boolean spawning;

    private boolean actionPaused = false;
    private boolean showScore = false;
    private boolean deathSequenceActive = false;

    // Not implemented yet:
    private int chanceOfDouble;
    private int chanceOfTriple;

    // Sounds and Graphics loading
    private GreenfootImage frogImage = new GreenfootImage ("frog.png");    
    private GreenfootImage splat = new GreenfootImage ("splat.png");

    // For some reason sounds work better if initialized in the constructor
    private GreenfootSound smush;
    private GreenfootSound levelUpSound;
    private GreenfootSound gameOverSound;

    // Declare objects
    private LifeCounter lifeCounter = new LifeCounter ();
    private LevelCounter levelCounter = new LevelCounter ();
    private Frogger myFrog = new Frogger();
    private Level currentLevel;

    /**
    Constructor for objects of class Desert.

    Once upon a time there was a comp sci class
    that was wondering why their teacher was typing
    random comments during a lesson.
     */
    public Desert()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        // Ensure that Frogs and Blood occur over top of everything else
        setPaintOrder(Frogger.class, BloodPool.class, ScoreBoard.class, Enemy.class);

        // Add the life counter to the World
        addObject (lifeCounter, 67, 25);
        addObject (levelCounter, 530, 24);

        // Initialize sound within the constructor to avoid wierd sound lag
        smush = new GreenfootSound("smush.wav");
        levelUpSound = new GreenfootSound("mariocoin.mp3");
        gameOverSound = new GreenfootSound("GameOver.wav");

        // Work-around to sound loading delay
        smush.play();
        smush.stop();
        levelUpSound.play();
        levelUpSound.stop();
        gameOverSound.play();
        gameOverSound.stop();

        // Set level to 1
        level = 1;
        autoCount = 0;
    }

    /**
     * The Act method is responsible for:
     *      loading new levels and death screens
     *      Triggering scoreboard and end the game
     *      Spawning cars
     */
    public void act ()
    {
        // Load level if necessary
        if (levelLoaded == false)
        {
            // Load level if player has lives left
            if (lives > 0)
            {
                levelLoader();
                levelLoaded = true;
            }
            else
            {
                ScoreBoard s = new ScoreBoard (level, "Game Over", "On Level ");
                addObject (s, 300,200);
                gameOverSound.play();
                // End program
                Greenfoot.stop();
            }
        }   
        // If appropriate, spawn cars
        if (actionPaused == false && spawning == true)
        {
            spawnCars();
        }

        // Control sequence to ensure that after death, program waits until
        // all cars are off-screen before spawning the next Frogger
        if (deathSequenceActive)
        {
            if (autoCount == 0)
            {
                deathSequenceActive = false;
                levelLoaded = false;
            }
        }
    }

    // Method to set necessary values to change level
    private void levelLoader ()
    {
        // Add a fresh Frogger object
        addObject(myFrog, 300, 370);

        // Update the info stored in currentLevel
        currentLevel = new Level (level);

        levelCounter.setLevel(level);

        // Set image to frog (in case "splat" was being displayed)
        myFrog.setImage(frogImage);

        // change appropriate booleans for game flow
        actionPaused = false;
        spawning = true;

        // load instance variables from Level
        spawnRate = currentLevel.getSpawnRate();
        vehicleSpeed = currentLevel.getVehicleSpeed();
        chanceOfDouble = currentLevel.getChanceOfDouble();
        chanceOfTriple = currentLevel.getChanceOfTriple();
        myFrog.setSpeed(currentLevel.getFroggerSpeed());

        // Ensure that level is not loaded again until necessary
        levelLoaded = true;
    }

    /**
     * Controlled spawning of new cars
     */
    private void spawnCars()
    {
        // Generate a random value to decide in which lane to spawn
        // a car
        int randVal = Greenfoot.getRandomNumber(3)+1;

        // Spawn a single car every 50 acts
        if (counter % spawnRate == 0)
        {
            if (randVal == 1)
                spawnY = 127;
            else if (randVal == 2)
                spawnY = 223;
            else
                spawnY = 320;
            addObject(new EastboundAuto(vehicleSpeed), 20, spawnY);
            autoCount++;
        }
        else if (counter % spawnRate == spawnRate / 2)
        {
            if (randVal == 1)
                spawnY = 78;
            else if (randVal == 2)
                spawnY = 173;
            else
                spawnY = 270;
            addObject(new WestboundAuto(vehicleSpeed), 578, spawnY);
            // keep track of how many cars on on the screen, so that
            // you can be sure they all leave the screen before the 
            // Frogger respawns after dying
            autoCount++;
        }
        counter++;
    }

    /**
     * This method gets called when the player dies or finishes a level
     * 
     * True = player completed level
     * False = player died
     */
    public void endLevel(boolean win)
    {
        ScoreBoard s = null;
        actionPaused = true;
        spawning = false;
        if (win == true)
        {
            level++;
            levelUpSound.play();
            removeObject (myFrog);
            levelLoaded = false;
            Greenfoot.delay(50);

        }
        else
        {
            // Change the Frogger's image to the bloody frog
            myFrog.setImage(splat);
            // Play a smush sound
            smush.play();

            BloodPool b = new BloodPool();
            addObject (b, myFrog.getX(), myFrog.getY());

            lives -= 1;
            lifeCounter.subtractLife();
            actionPaused = false;

            deathSequenceActive = true;

            removeObject (myFrog);
        }
    }

    /**
     * Returns whether the current gamestate is paused (true) or not (false)
     */
    public boolean isActionPaused ()
    {
        return actionPaused;
    }

    /**
     * Allows objects to inform this controller when they are about to 
     * remove themselves from the world.
     */
    public void reduceAutoCount (int byHowMany)
    {
        autoCount -= byHowMany;
    }

}
