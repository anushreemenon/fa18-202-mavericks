import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    private Sound music;
    // GreenfootSound backgroundMusic;
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        music = Sound.getInstance();
        GreenfootImage image = getBackground();
        image.scale(1200, 800);
        setBackground(image);
        Greenfoot.setWorld(this);
        prepare();
    }

    public void act() {
        if(Greenfoot.isKeyDown("enter"))
            Greenfoot.setWorld(new MyWorld());
    }
    
    public void startGame() {
        Greenfoot.setWorld(new MyWorld());
    }
    
    public void exitGame() {
        System.exit(0);
    }
    
    public void stopBackgroundMusic()
    {
       music.pauseBackGround();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        music.playBackGroundMusic();    
        PlayButton playButton = new PlayButton(this);
        addObject(playButton,445,601);
        playButton.setLocation(329,551);
        QuitButton quitButton = new QuitButton(this);
        addObject(quitButton,883,562);
        quitButton.setLocation(862,551);
        CrossyLabel crossyLabel = new CrossyLabel();
        addObject(crossyLabel,597,127);
        WorldLabel worldLabel = new WorldLabel();
        addObject(worldLabel,606,319);
    }
}
