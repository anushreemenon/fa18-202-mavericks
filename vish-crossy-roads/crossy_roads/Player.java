import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

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

	private boolean checkObstacle(int dx, int dy) {
	    if(getObjectsAtOffset(dx, dy, Tree.class).size() == 0) {
		    if(getObjectsAtOffset(dx, dy, Rock.class).size() == 0)
			    return false;
	    }
	    return true;
	}

	public void checkKeys()
	{
		boolean obstacle = true;
		if( Greenfoot.isKeyDown("left"))
		{
			obstacle = checkObstacle(-10, 0);
			if(!obstacle)
				move(-5);
		}
		if(Greenfoot.isKeyDown("right"))
		{
			obstacle = checkObstacle(10, 0);
			if(!obstacle)
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
		boolean obstacle = checkObstacle(0, vSpeed*2);
		if(!obstacle) {
			setLocation(getX(), getY()+vSpeed);  
			vSpeed = vSpeed + acceleration;  
		}
	}
	public void fallDown()  
	{  
		boolean obstacle = checkObstacle(0, -vSpeed*2);
		if(!obstacle) {
			setLocation(getX(), getY()-vSpeed);  
			vSpeed = vSpeed - acceleration;  
		}
	}
}

