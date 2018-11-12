import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Frog in my "Frogger" game.
 * 
 * By Jordan Cohen
 */
public class Frogger extends Actor
{
    private int speed;
    private boolean active;

    public Frogger ()
    {
        active = true;
        speed = 2;
    }

    /**
     * Act - do whatever the Frogger wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeys();

        if (checkWin() )
        {
            endGame(true);
        }
        else if(checkDeath() && active == true)
        {
            active = false;
            endGame(false);
        }

    }   
    
    public void addedToWorld (World w)
    {
        active = true;
    }
    
    private void checkKeys()
    {
        if (active == true)
        {
            if (Greenfoot.isKeyDown("up"))
            {
                setLocation (getX(), getY() - speed);
            }
            if (Greenfoot.isKeyDown("down"))
            {
                setLocation (getX(), getY() + speed);
            }
            if (Greenfoot.isKeyDown("left"))
            {
                setLocation (getX() - speed, getY());
            }
            if (Greenfoot.isKeyDown("right"))
            {
                setLocation (getX()  + speed, getY());
            }
        }
    }

    private boolean checkDeath()
    {
        Enemy e = (Enemy)getOneIntersectingObject(Enemy.class);
        if (e != null)
        {
            // if an enemy is detected colliding with Frogger, then death = true :(
            return true;
        }
        return false;
    }

    private boolean checkWin()
    {
        if (getY() <= 32)
        {
            active = false;
            return true;  
        }
        else
            return false;
    }

    /**
     * endGame method will expect true (for success) or false (for failure!)
     */
    private void endGame (boolean win)
    {
        // Return a message declaring win or lose to the Desert (World)
        Desert d = (Desert)getWorld();
        d.endLevel (win);
    }
    
    public void setSpeed (int speed)
    {
        this.speed = speed;
    }
}
