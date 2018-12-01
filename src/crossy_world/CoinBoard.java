import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Font;
import greenfoot.Color;
import java.util.*;

/**
 * class LevelCounter 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoinBoard extends Actor
{
    private CoinCounter coin; 
    private DisplayMessage displayMessage;
    private int coinCount;
    World myWorld;
    static final int COINS_FOR_EXTRA_LIFE = 5;
    private int totalCount;
    private static Sound single_instance = null; 
    private static CoinBoard coin_board_instance = null; 
    protected Mediator mediator;
    
    public static CoinBoard getInstance() 
    { 
        if (coin_board_instance == null) 
            coin_board_instance = new CoinBoard(); 
  
        return coin_board_instance; 
    } 
    private CoinBoard ()
    {
        coinCount = 0;
        totalCount = 0;
        String str = " " + coinCount;
        displayMessage = new DisplayMessage(str);
        coin = new CoinCounter();
        coin.getImage().scale(60,60);
        
    }

    public void incrementCount ()
    {
        coinCount++;
        totalCount++;
        if ((coinCount % COINS_FOR_EXTRA_LIFE) == 0) {
            if (mediator == null){
                List<Mediator> objects = myWorld.getObjects(Mediator.class);
                mediator = objects.get(0);
            }
            mediator.powerUp();
            coinCount = 0;
        }
        String str = " " + coinCount; 
        displayMessage.updateMessage(str);
    }

    public void loadCoinBoard () {
        myWorld = getWorld();
        myWorld.addObject (coin, myWorld.getWidth() - 120, 30);
        myWorld.addObject (displayMessage, myWorld.getWidth() - 70, 30);
    }

    public int getCoinCount() {
        return totalCount;
    } 
    
    public void resetCoinBoard() {
        coinCount = 0;
        totalCount = 0;
    }

}
