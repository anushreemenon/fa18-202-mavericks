



import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Level1Strategy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1Strategy extends Actor implements LevelStrategy{
    // instance variables - replace the example below with your own
    public void LoadTerrains() {
        
      //  RoadTerrain roadTerrain = new RoadTerrain() ;
      
      RiverTerrain riverTerrain = new RiverTerrain();
      
      MyWorld myWorld =  getWorldOfType(MyWorld.class);

    
      River r = new River();
      
      myWorld.addObject(r, 50, 50);
      
      Log log1 = new Log();
      Log log2 = new Log();
      Log log3 = new Log();
      
      riverTerrain.addChild ( r );
      riverTerrain.addChild ( log1 );
      riverTerrain.addChild ( log2 );
      riverTerrain.addChild ( log3 );
      
      riverTerrain.display();
      

        
       // river_terrain river_t = new river_terrain() ;
       // rail_terrain rail_t = new rail_terrain() ;
       // land_terrain land_t = new land_terrain() ;
        
        // set up hierarchy for road terrain
       /* road rd = new road() ;
        car_blue car1 = new car_blue() ;
        car car2 = new car() ;
        road_t.addChild( rd ) ;
        road_t.addChild( car1 ) ;
        road_t.addChild( car2 ) ;

        
        terrains.addChild( road_t );
        terrains.addChild( river_t );
        terrains.addChild( rail_t );
        terrains.addChild( land_t );
        */
        
    }
}
