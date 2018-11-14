



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
      
      GreenfootImage log1Img, log2Img, log3Img, riverImg, playerImg;
      
      RiverTerrain riverTerrain = new RiverTerrain();
      
      MyWorld myWorld =  getWorldOfType(MyWorld.class);
      
      myWorld.addObject(riverTerrain, 50, 50); 
    
      River r = new River();
      
      riverImg = r.getImage();
      
      riverImg.scale(1200,400);
      
       
      Log log1 = new Log();
      log1Img = log1.getImage();
      log1Img.scale(80,40);
      Log log2 = new Log();
      log2Img = log2.getImage();
      log2Img.scale(80,40);

      
      Log log3 = new Log();
      log3Img = log3.getImage();
      log3Img.scale(80,40);
      
      riverTerrain.addChild ( r );
      riverTerrain.addChild ( log1 );
      riverTerrain.addChild ( log2 );
      riverTerrain.addChild ( log3 );
      
      myWorld.addObject( r, 40, 50 );
      myWorld.addObject( log1, 540, 50);
      myWorld.addObject( log2, 540, 125);
      myWorld.addObject( log3, 540, 200);
      
      Player p = new Player();
      
      playerImg = p.getImage();
      playerImg.scale(40,40);
      myWorld.addObject( p, 200, 300);
      
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
