import greenfoot.*; 
/**
 * Write a description of class Sound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sound  
{
    // instance variables - replace the example below with your own
    private GreenfootSound gameOverSound;
    private GreenfootSound explosionSound;
    private GreenfootSound powerUpSound;
    private GreenfootSound backgroundMusic;
    private static Sound single_instance = null; 
    public static Sound getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new Sound(); 
  
        return single_instance; 
    } 
    /**
     * Constructor for objects of class Sound
     */
    private Sound()
    {
        gameOverSound = new GreenfootSound("GameOver.wav");
        explosionSound = new GreenfootSound("explosion.wav");
        powerUpSound = new GreenfootSound("powerup.wav");
        backgroundMusic = new GreenfootSound("background.mp3");
    }


    public void playGameOver() {
        gameOverSound.play();
    }

    public void playBackGroundMusic() {
        try {
            backgroundMusic.playLoop();
        } catch(Exception e){}
    }

    public void playPowerUp() {
        powerUpSound.play();
    }

    public void playExplosion() {
        explosionSound.play();
    }

    public void pauseBackGround() {
        backgroundMusic.pause();
    }
}
