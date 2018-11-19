



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
      
      GreenfootImage log1Img, log2Img, log3Img, riverImg, playerImg, r1Img, r2Img , t1Img, t2Img, trackImg, trainImg;
      GreenfootImage rd1Img,rd2Img, rd3Img, land1Img,landImg, car1Img,car2Img,car3Img, car4Img,car5Img,car6Img, r3Img, r4Img, t3Img, t4Img;
      GreenfootImage log4Img, log5Img, log6Img, log7Img, log8Img, log9Img, car7Img,car8Img,car9Img, car10Img,car11Img,car12Img;
      MyWorld myWorld =  getWorldOfType(MyWorld.class);
      
      LandTerrain landTerrain1 = new LandTerrain(); 
      Land l1 = new Land();
      
      Tree t1 = new Tree();
      Tree t2 = new Tree();
      
      t1Img = t1.getImage();
      t1Img.scale(30,75);
      
      t2Img = t2.getImage();
      t2Img.scale(30,75);
      
     
      land1Img = l1.getImage();
      land1Img.scale(2400,200);
      
      Rock r3 = new Rock();
      r3Img = r3.getImage();
      r3Img.scale(50,50);
      
      Rock r4 = new Rock();
      r4Img = r4.getImage();
      r4Img.scale(50,50);
      
      
      landTerrain1.addChild ( l1 );
      landTerrain1.addChild ( t1 );
      landTerrain1.addChild ( t2 );
      landTerrain1.addChild ( r3 );
      landTerrain1.addChild ( r4 );
      

      myWorld.addObject( l1, 0, 700);
      myWorld.addObject( t1, 400, 700);
      myWorld.addObject( t2, 840, 700);
      myWorld.addObject( r3, 250, 700);
      myWorld.addObject( r4, 950, 700);
      
      RoadTerrain roadTerrain = new RoadTerrain();   
      
      Road rd1 = new Road();
      Road rd2 = new Road();
      Road rd3 = new Road();
      CarBlue car1 = new CarBlue();           
      Car car2 = new Car();          
      CarBlue car3 = new CarBlue();
      CarBlue car4 = new CarBlue();           
      Car car5 = new Car();          
      CarBlue car6 = new CarBlue();
      CarBlue car7 = new CarBlue();
      Car car8 = new Car();
      CarBlue car9 = new CarBlue();
      CarBlue car10 = new CarBlue();
      Car car11 = new Car();
      CarBlue car12 = new CarBlue();
     
      roadTerrain.addChild ( rd1 );      
      roadTerrain.addChild ( rd2 );
      roadTerrain.addChild ( rd3 );
      roadTerrain.addChild ( car1 );
      roadTerrain.addChild ( car2 );
      roadTerrain.addChild ( car3 );
      roadTerrain.addChild ( car4 );
      roadTerrain.addChild ( car5 );
      roadTerrain.addChild ( car6 );
      roadTerrain.addChild ( car7 );
      roadTerrain.addChild ( car8 );
      roadTerrain.addChild ( car9 );
      roadTerrain.addChild ( car10 );
      roadTerrain.addChild ( car11 );
      roadTerrain.addChild ( car12 );
      
      
      rd1Img = rd1.getImage();
      rd1Img.scale(2400,100);
      
      rd2Img = rd2.getImage();
      rd2Img.scale(2400,100);
      
      rd3Img = rd3.getImage();
      rd3Img.scale(2400,100);
      
      car1Img = car1.getImage();
      car1Img.scale(70,30);
      
      car2Img = car2.getImage();
      car2Img.scale(70,30);
      
      car3Img = car3.getImage();
      car3Img.scale(70,30);
      
      car4Img = car4.getImage();
      car4Img.scale(70,30);
      
      car5Img = car5.getImage();
      car5Img.scale(70,30);
      
      car6Img = car6.getImage();
      car6Img.scale(70,30);
      
      car4Img = car4.getImage();
      car4Img.scale(70,30);
      
      car5Img = car5.getImage();
      car5Img.scale(70,30);
      
      car6Img = car6.getImage();
      car6Img.scale(70,30);
      
      car7Img = car7.getImage();
      car7Img.scale(70,30);
      
      car8Img = car8.getImage();
      car8Img.scale(70,30);
      
      car9Img = car9.getImage();
      car9Img.scale(70,30);
      
      car10Img = car10.getImage();
      car10Img.scale(70,30);
      
      car11Img = car11.getImage();
      car11Img.scale(70,30);
      
      car12Img = car12.getImage();
      car12Img.scale(70,30);
      
      
      //myWorld.addObject( rd1, 0, 600 );
      //myWorld.addObject( rd2, 0, 500 );
      //myWorld.addObject( rd3, 0, 400 );
      myWorld.addObject( roadTerrain, 0, 400 );
     /*
      myWorld.addObject( car1, 1200, 625);
      myWorld.addObject( car2, 1200, 575);
      myWorld.addObject( car3, 1200, 525);
      myWorld.addObject( car4, 1200, 475);
      myWorld.addObject( car5, 1200, 425);
      myWorld.addObject( car6, 1200, 375);
     */
      
      LandTerrain landTerrain2 = new LandTerrain();   
      Land l = new Land();
      
      Tree t3 = new Tree();
      Tree t4 = new Tree();
      
      t3Img = t3.getImage();
      t3Img.scale(30,75);
      
      t4Img = t4.getImage();
      t4Img.scale(30,75);
      
     
      landImg = l.getImage();
      landImg.scale(2400,100);
      
      Rock r1 = new Rock();
      r1Img = r1.getImage();
      r1Img.scale(50,50);
      
      Rock r2 = new Rock();
      r2Img = r2.getImage();
      r2Img.scale(50,50);
    
      landTerrain2.addChild ( l );
      landTerrain2.addChild ( t3 );
      landTerrain2.addChild ( t4 );
      landTerrain2.addChild ( r1 );
      landTerrain2.addChild ( r2 );
      
      myWorld.addObject( l, 0, 300);
      myWorld.addObject( t3, 540, 300);
      myWorld.addObject( t4, 150, 300);
      myWorld.addObject( r1, 700, 300);
      myWorld.addObject( r2, 250, 300);
    
      RiverTerrain riverTerrain = new RiverTerrain();
      
      myWorld.addObject(riverTerrain,0,100);
      
      River r = new River();
      
      riverImg = r.getImage();
      
      riverImg.scale(2400,300);
      
      Log log1 = new Log();
      log1Img = log1.getImage();
      log1Img.scale(120,30);
      LogRight log2 = new LogRight();
      log2Img = log2.getImage();
      log2Img.scale(120,30);
      Log log3 = new Log();
      log3Img = log3.getImage();
      log3Img.scale(120,30);
      
      Log log4 = new Log();
      log4Img = log4.getImage();
      log4Img.scale(120,30);
      LogRight log5 = new LogRight();
      log5Img = log5.getImage();
      log5Img.scale(120,30);
      Log log6 = new Log();
      log6Img = log6.getImage();
      log6Img.scale(120,30);
      
      Log log7 = new Log();
      log7Img = log7.getImage();
      log7Img.scale(120,30);
      LogRight log8 = new LogRight();
      log8Img = log8.getImage();
      log8Img.scale(120,30);
      Log log9 = new Log();
      log9Img = log9.getImage();
      log9Img.scale(120,30);
      
      riverTerrain.addChild ( r );
      riverTerrain.addChild ( log1 );
      riverTerrain.addChild ( log2 );
      riverTerrain.addChild ( log3 );
      riverTerrain.addChild ( log4 );
      riverTerrain.addChild ( log5 );
      riverTerrain.addChild ( log6 );
      riverTerrain.addChild ( log7 );
      riverTerrain.addChild ( log8 );
      riverTerrain.addChild ( log9 );
      



      
      
      
      riverTerrain.display();

      // Set up rail terrain
      /*
      RailTerrain railTerrain = new RailTerrain();
      
      Track track = new Track();
      
      trackImg = track.getImage();
      
      trackImg.scale(2400,300);
      
      Train train = new Train();
      trainImg = train.getImage();
      trainImg.scale(120,40);
      railTerrain.addChild ( train );
      
      
      myWorld.addObject( railTerrain, 0, 00 );
      myWorld.addObject( train, 1200, 200);
      */
      Player p = new Player();
      
      playerImg = p.getImage();
      playerImg.scale(50,50);
      myWorld.addObject( p, 600, 700);
      
      //railTerrain.display();
       
    }
}
