import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EastboundAuto extends Enemy
{
    private int speed;
    private Desert d;

    public EastboundAuto (int speed)
    {
        this.speed = speed;

    }

    public void addedToWorld (World w)
    {
        d = (Desert)getWorld();
    }

    public void act() 
    {

        if (d.isActionPaused() == false)
        {
            if (!(atWorldEdge()))
            {
                Enemy carDirectlyInFrontOfMe = (Enemy)getOneObjectAtOffset (getImage().getWidth()/2 + speed, 0, Enemy.class);
                if (carDirectlyInFrontOfMe == null)
                    setLocation (getX() + speed, getY());
                else
                    speed = carDirectlyInFrontOfMe.getSpeed();
            }
            else 
            {
                d.reduceAutoCount(1);
                d.removeObject(this);
            }
        }
    }    

    public boolean atWorldEdge()
    {
        if(getX() > getWorld().getWidth() - (getImage().getWidth() / 2) + 20)
            return true;

        else
            return false;
    }
    public int getSpeed ()
    {
        return speed;
    }
}
