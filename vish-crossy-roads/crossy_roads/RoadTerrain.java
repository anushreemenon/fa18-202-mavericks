import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Road_Terrain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoadTerrain extends Composite {
    /**
     * Act - do whatever the Road_Terrain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Component car;
    private ArrayList <Component> cars = new ArrayList<Component>()  ;
    private static int count = 0;
    private static int carY = 625;
    
    public void act() {
        
        display();

    }

    public Component getCar() {

        Component car;
        int carCounter = 0;    
        while (carCounter <= 2)
              carCounter = Greenfoot.getRandomNumber(15);

        return getChild(carCounter);
    }
    
    public void createRoads() {
        World myWorld = getWorld();
        Component rd;
        Actor road;
        int y = 600;
        for (int i=0; i<3; i++) {
            rd = getChild(i);
            road = (Actor)rd;
            myWorld.addObject(road,0,y);
            y-=100;
        }
    }

    
    public void display() {
        Actor actualCar;

        World myWorld = getWorld();

        count++;
        
        createRoads();
        
        List<Road> rt = myWorld.getObjects(Road.class);
            
        int rtY = rt.get(0).getY();
        
       // System.out.println("rtY = " + rtY);

        if (count%100 == 0) {
            car = getCar();
            actualCar = (Actor)car;
            
            //rt = myWorld.getObjects(RoadTerrain.class);

            
            //carY = rtY+25;
            if (carY <= rtY && carY > rtY-300)
                    myWorld.addObject(actualCar,1200,carY);

            carY -=50;

        }

    } 
        
        
}
