import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Leaf
{
    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 2; //movement speed  
    private int vSpeed = 0; //vertical speed  
    private int acceleration = 2; //gravity effect while falling  
    private int jumpStrength = -8; 
    public void act() 
    {
        checkKeys();
    }  

     public void checkKeys()
    {
        if( Greenfoot.isKeyDown("left"))
        {
            move(-5);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            move(5);
        }
        if(Greenfoot.isKeyDown("up")) 
        { 
            jump("up");
        }
        if(Greenfoot.isKeyDown("down")) 
        {
           jump("down");
        }

    }
    
    public void jump(String keyEvent)  
    {  
       
            vSpeed = jumpStrength;  
            if(keyEvent.equals("up"))
            fall();   
            else
            fallDown();
    }
   
    
    public void fall()  
    {  
        setLocation(getX(), getY()+vSpeed);  
        vSpeed = vSpeed + acceleration;  
    }
    public void fallDown()  
    {  
        setLocation(getX(), getY()-vSpeed);  
        vSpeed = vSpeed - acceleration;  
    }
    


    
}

