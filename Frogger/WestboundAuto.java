import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * West-bound cars - 
 */
public class WestboundAuto extends Enemy
{
    private int speed;
    private Desert d;

    public WestboundAuto (int speed)
    {
        this.speed = -speed;
    }

    public void addedToWorld (World w)
    {
        d = (Desert)getWorld();
        setRotation(180);
    }

    /**
     * Act serves to check for cars in front and adjust speed when necessary. Also removes
     * this object when it reaches the edge of the screen.
     */
    public void act() 
    {

        if (d.isActionPaused() == false)
        {
            // Check if there is a slower car in front of me. This is possible
            // When the level goes up while a car is on the screen. This code
            if (!(atWorldEdge()))
            {
                Enemy carDirectlyInFrontOfMe = (Enemy)getOneObjectAtOffset (-getImage().getWidth()/2 + speed, 0, Enemy.class);
                if (carDirectlyInFrontOfMe == null)
                    setLocation (getX() + speed, getY());
                else
                    speed = carDirectlyInFrontOfMe.getSpeed();
            }
            
            // When I reach the edge of the world, end this object
            else 
            {
                d.reduceAutoCount(1);
                d.removeObject(this);
            }
        }
    } 

    /**
     * Returns true if at the edge of the world and in need of
     * self-removal
     */
    public boolean atWorldEdge()
    {
        if(getX() < (getImage().getWidth() / 2) - 20)
            return true;
        else
            return false;
    } 

    /**
     * Allows other cars to see how fast I am moving. Returns speed in pixels-per-act
     */
    public int getSpeed ()
    {
        return speed;
    }

}
