import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
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
    private static int y = 625;
    public void act() {
        Actor actualCar;

        World myWorld = getWorld();

        count++;
        
        createRoads();

        if (count%100 == 0) {
            car = getCar();
            actualCar = (Actor)car;
            myWorld.addObject(actualCar,1200,y);
            cars.add(car);
            if (y < 375)
                y = 625;
            else
                y -=50;

        }

         for (Component car  : cars) {
            int pos = 0;
            actualCar = (Actor)car;
            
             if (actualCar.getX() == 0) {
                pos = 1200;
            }
             else {
                pos = 0;
            }
             
            actualCar.setLocation(pos + actualCar.getX() - 1, actualCar.getY());
           
         }
    }

    public Component getCar() {

        Component car;
        int carCounter = 1;    
        while (carCounter < 3)
              carCounter = Greenfoot.getRandomNumber(9);

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

}