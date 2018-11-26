import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Font;
import greenfoot.Color;

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
    MyWorld myWorld;
    static final int COINS_FOR_EXTRA_LIFE = 5;
    private int totalCount;

    public CoinBoard (MyWorld world)
    {
        coinCount = 0;
        totalCount = 0;
        String str = " " + coinCount;
        displayMessage = new DisplayMessage(str);
        coin = new CoinCounter();
        coin.getImage().scale(60,60);
        myWorld = world;
    }

    public void incrementCount ()
    {
        coinCount++;
        totalCount++;
        if ((coinCount % COINS_FOR_EXTRA_LIFE) == 0) {
            myWorld.powerUp();
            coinCount = 0;
        }
        String str = " " + coinCount; 
        displayMessage.updateMessage(str);
    }

    public void loadCoinBoard () {
        myWorld.addObject (coin, myWorld.getWidth() - 120, 30);
        myWorld.addObject (displayMessage, myWorld.getWidth() - 70, 30);
    }

    public int getCoinCount() {
        return totalCount;
    }

}
