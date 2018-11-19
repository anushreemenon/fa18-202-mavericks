import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class river_terrain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RiverTerrain extends Composite
{
    /**
     * Act - do whatever the river_terrain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   private Component log;
   private static int count = 0;
   private static int y = 225;

   
   public void act() {
     display();  
   }

    public Component getLog() {

        Component log;
        int logCount = 0;   
        
        while (logCount < 1)
              logCount = Greenfoot.getRandomNumber(10);

        return getChild(logCount);
    }
    
    public void createRiver() {
        World myWorld = getWorld();
        Component river;
        Actor actualRiver;
        river = getChild(0);    //first element of composite is river. remaining ones are logs
        actualRiver = (Actor)river;
        myWorld.addObject( actualRiver, 0, 100 );

    }

    
    public void display() {
        Actor actualLog;

        World myWorld = getWorld();

        count++;
        
        createRiver();

        if (count%35 == 0) {
            log = getLog();
            actualLog = (Actor)log;

            myWorld.addObject(actualLog,1200,y);
            
            if (y <= 100)
                y = 225;
            else
                y -=50;

        }
       

    } 
        
    
}
