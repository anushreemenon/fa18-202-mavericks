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
   private int logY = 300;
   private int logFrequeny;

   public RiverTerrain(int f) {
       logFrequeny = f;
    }
   
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
        myWorld.addObject( actualRiver, 0, 0 );

    }

    
    public void display() {
        Actor actualLog;

        World myWorld = getWorld();
        count++;    
        createRiver();     
        List<River> rv = myWorld.getObjects(River.class);    
        int rvY = rv.get(0).getY();
 
        if (count%logFrequeny == 0) {
            log = getLog();
            actualLog = (Actor)log;
            
            if (logY >= rvY-100 && logY <= rvY+100) {
                    myWorld.addObject(actualLog,1200,logY+50);
                    logY -=50;
            }
            else {  
                logY = rvY+100;
        
        }
       
    }
   } 
}
        
    
