import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Font;
import greenfoot.Color;

/**
 * Write a description of class LevelCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoinBoard extends Actor
{
    private CoinCounter coin; 
    private DisplayMessage displayMessage;
    private int coin_count;
    MyWorld myWorld;

    public CoinBoard (MyWorld world)
    {
        coin_count = 0;
        String str = " " + coin_count;
        displayMessage = new DisplayMessage(str);
        coin = new CoinCounter();
        coin.getImage().scale(60,60);
        myWorld = world;
    }

    public void incrementCount ()
    {
        coin_count++;
        String str = " " + coin_count; 
        displayMessage.updateMessage(str);
    }

    public void loadCoinBoard () {
        myWorld.addObject (coin, 1100, 100);
        myWorld.addObject (displayMessage, 1150, 100);
    }

}
