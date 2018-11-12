import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends greenfoot.World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);

        // Ensure that player is on top of everything else
        setPaintOrder(player.class, log.class, car.class, car_blue.class, road.class);
        
        composite terrains = new composite() ;
        
        road_terrain road_t = new road_terrain() ;
        river_terrain river_t = new river_terrain() ;
        rail_terrain rail_t = new rail_terrain() ;
        land_terrain land_t = new land_terrain() ;
        
        road rd = new road() ;
        car_blue car1 = new car_blue() ;
        car car2 = new car() ;
        road_t.addChild( rd ) ;
        road_t.addChild( car1 ) ;
        road_t.addChild( car2 ) ;


        terrains.addChild( road_t );
        terrains.addChild( river_t );
        terrains.addChild( rail_t );
        terrains.addChild( land_t );

        // Add the life counter to the World
        addObject (rd, 67, 25);
       
    }
}
