import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class LevelCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mediator extends Actor implements IMediator
{
    
    private GreenfootImage boom;
    private Sound music;
	
	public Mediator(){
        boom = new GreenfootImage ("boom.png");
        music = Sound.getInstance();
	}
	
	/**
     * The Act method is responsible for:
     *      loading new levels and death screens
     *      Triggering scoreboard and end the game
     *      
     */
    public void endGame ()
    {
        MyWorld myworld = (MyWorld) getWorld();  
        music.pauseBackGround();
        ScoreBoard s = new ScoreBoard (CoinBoard.getInstance().getCoinCount() , "Game Over", "Score: ");
        myworld.addObject (s, myworld.getWidth()/2,myworld.getHeight()/2);
        music.playGameOver();
        // End program
        Greenfoot.stop();  
    }

    public void incrementCoinCount() {
        MyWorld myworld = (MyWorld) getWorld();  
        myworld.setActionPaused();
        CoinBoard.getInstance().incrementCount();
        myworld.resetActionPaused();

    }

    public void powerUp() {
        LifeCounter.getInstance().powerUp();
    }

    public void lostLife() {
        MyWorld myworld = (MyWorld) getWorld();  
        music.pauseBackGround();
        boom.scale(80,80);
        List<Player> objects = myworld.getObjects(Player.class);
        objects.get(0).setImage(boom);
        LifeCounter.getInstance().lostLife();
        music.playExplosion();
        myworld.setActionPaused();
        myworld.resetLevelLoaded();
        myworld.resetTimer();
        Greenfoot.delay(50);
    }

    public void displayLevelScore(String msg) {
        MyWorld myworld = (MyWorld) getWorld();   
        msg = msg + " Complete";
        ScoreBoard s = new ScoreBoard (CoinBoard.getInstance().getCoinCount() , msg, "Score: ");
        myworld.addObject (s, myworld.getWidth()/2,myworld.getHeight()/2);
        Greenfoot.playSound("GameOver.wav");
        Greenfoot.delay(250);
    }

    
    
    
}
