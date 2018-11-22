
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Level1Strategy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1Strategy extends Actor implements LevelStrategy {
    //private List<Leaf> observers = new ArrayList<Leaf>();
    private int targetTimer=0;
    private static boolean isFinalLevelReached = false;
    private Target target;
    
    public void act(){
        runTargetTimer();
    }
	
    public void runTargetTimer()
    {
        if(getFinalLevelState()==false){
            if(targetTimer==2000){
                addTarget();
            }
            else
                targetTimer++;
            } 
    }
    public static void setFinalLevelState(boolean state){
        isFinalLevelReached = state;
    }
    public static boolean getFinalLevelState(){
        return isFinalLevelReached;
    }
    

    public void addTarget(){
        MyWorld myWorld =  getWorldOfType(MyWorld.class);
        myWorld.addObject( target, 600, 50);
        
    }
    
    public void loadTerrains() {      
        MyWorld myWorld =  getWorldOfType(MyWorld.class);

         // D. River terrain:
	    // 1. Create river terrain object
        RiverTerrain riverTerrain = new RiverTerrain();
      
	    // 2. Create river object
		River r = new River();
		
		// 3. Adding river terrain to my world
        myWorld.addObject(riverTerrain,0,0);
        // 4. Scale river image
        r.getImage().scale(2400,300);
      
		// 5. Create wooden log objects
        Log log1 = new Log();                                                                                                                                      
		Log log2 = new Log();                                                                                                                                      
		Log log3 = new Log();
		Log log4 = new Log(); 
		Log log5 = new Log();
		Log log6 = new Log();
		Log log7 = new Log();
		Log log8 = new Log();
		Log log9 = new Log();
		
		// 6. Scale log images
        log1.getImage().scale(120,30);
        log2.getImage().scale(120,30);
        log3.getImage().scale(120,30);
        log4.getImage().scale(120,30);
        log5.getImage().scale(120,30);
        log6.getImage().scale(120,30);
        log7.getImage().scale(120,30);
        log8.getImage().scale(120,30);
        log9.getImage().scale(120,30);
      
	    // 7. Setup composite pattern
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
      
	    // 8. Display the river terrain
        riverTerrain.display();

        
        LandTerrain landTerrain1 = new LandTerrain(); 
        
        // 2. Land objects
        Land l1 = new Land();//Upper 

        l1.getImage().scale(2500,100);

        // 3. Tree objects
        Tree t1 = new Tree();
        Tree t2 = new Tree();		
        Tree t3 = new Tree();
        Tree t4 = new Tree();
        Tree t5 = new Tree();
        Tree t6 = new Tree();
        Tree t7 = new Tree();
        Tree t8 = new Tree();
        Tree t9 = new Tree();
        Tree t10 = new Tree();
        Tree t11 = new Tree();
        Tree t12 = new Tree();
        Tree t13 = new Tree();
        Tree t14 = new Tree();
    
        // 4. Rock objects
        Rock r1 = new Rock();
        Rock r2 = new Rock();
        Rock r3 = new Rock();
        Rock r4 = new Rock();
        Rock r5 = new Rock();
        Rock r6 = new Rock();
        Rock r7 = new Rock();
        Rock r8 = new Rock();
        Rock r9 = new Rock();
        Rock r10 = new Rock();

        // 5. Scale rock images to required sizes
		r1.getImage().scale(50,50);
        r2.getImage().scale(50,50);
	    r3.getImage().scale(50,50);
		r4.getImage().scale(50,50);     
		r5.getImage().scale(50,50);
	    r6.getImage().scale(60,60);
        r7.getImage().scale(60,60);
        r8.getImage().scale(60,60);
        r9.getImage().scale(50,50);
        r10.getImage().scale(70,70);
		
        // 6. Scale tree images to appropriate size
        t1.getImage().scale(30,75);
        t2.getImage().scale(30,75);
		t3.getImage().scale(30,75);
        t4.getImage().scale(30,75);
        t5.getImage().scale(30,75);
        t6.getImage().scale(30,75);
        t7.getImage().scale(40,85);
        t8.getImage().scale(40,85);
        t9.getImage().scale(40,85);
        t10.getImage().scale(40,85);
        t11.getImage().scale(40,85);
        t12.getImage().scale(40,85);
        t13.getImage().scale(20,65);
        t14.getImage().scale(20,65);
        
        // 7. Scale image of land to appropriate size
        l1.getImage().scale(2500,300);

        // 8. Setup the composite pattern for land terrain
        landTerrain1.addChild ( l1 );

        //9. Adding trees as children on LandTerrain1
        landTerrain1.addChild ( t3 );
        landTerrain1.addChild ( t4 );
		landTerrain1.addChild ( t5 );
        landTerrain1.addChild ( t6 );
        landTerrain1.addChild ( t7 );
        landTerrain1.addChild ( t8 );

        //10. Adding rocks as children to Landterrain1
        landTerrain1.addChild ( r1 );
        landTerrain1.addChild ( r2 );
        landTerrain1.addChild ( r5 );
        landTerrain1.addChild ( r6 );
        landTerrain1.addChild ( r7 );
        landTerrain1.addChild ( r8 );

        //11. Adding Land1 to world
        myWorld.addObject( l1, 0, 300);

        myWorld.addObject( t3, 540, 300);
        myWorld.addObject( t4, 150, 300);
        myWorld.addObject( t5, 50, 300);
        myWorld.addObject( t6, 580, 300);
        myWorld.addObject( t7, 750, 300);
        myWorld.addObject( t8, 900, 300);

        myWorld.addObject( r1, 700, 300);
        myWorld.addObject( r2, 250, 300);
        myWorld.addObject( r5, 950, 300);
		myWorld.addObject( r6, 950, 300);
		myWorld.addObject( r7, 950, 300);
        myWorld.addObject( r8, 950, 300);


       

        // C. Road terrain:
	    // 1. Create object pof road terrain
        RoadTerrain roadTerrain = new RoadTerrain();
		
		// 2. Create objects of road
        Road rd1 = new Road();
        Road rd2 = new Road();
        Road rd3 = new Road();

        // 3. Create objects of car
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
     
	    // 4. Setting up road terrain
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
      
        // 5. Scale road images to appropriate size
        rd1.getImage().scale(2500,100);
        rd2.getImage().scale(2500,100);
        rd3.getImage().scale(2500,100);
      
	    // 6. Scale car images
        car1.getImage().scale(70,30);
        car2.getImage().scale(70,30);
        car3.getImage().scale(70,30);
        car4.getImage().scale(70,30);
        car5.getImage().scale(70,30);
        car6.getImage().scale(70,30);
        car7.getImage().scale(70,30);
        car8.getImage().scale(70,30);
        car9.getImage().scale(70,30);
        car10.getImage().scale(70,30);
        car11.getImage().scale(70,30);
        car12.getImage().scale(70,30);
      
	    // 7. Adding road terrain to the my world
        myWorld.addObject( roadTerrain, 0, 400 );



        //LandTerrain2

        LandTerrain landTerrain2 = new LandTerrain();
        Land l2 = new Land();//Lower
        l2.getImage().scale(2500,120);

        landTerrain2.addChild ( l2 );

        landTerrain2.addChild ( t1 );
        landTerrain2.addChild ( t2 );

        landTerrain2.addChild ( t9 );
        landTerrain2.addChild ( t10 );
        landTerrain2.addChild ( t11 );
        landTerrain2.addChild ( t12 );
        landTerrain2.addChild ( t13 );

        landTerrain2.addChild ( r3 );

        landTerrain2.addChild ( r4 );
        landTerrain2.addChild ( r9 );
        landTerrain2.addChild ( r10 );
        
        myWorld.addObject( l2, 0, 700);

        myWorld.addObject( t1, 400, 700);
        myWorld.addObject( t2, 840, 700);

        myWorld.addObject( t9, 790, 700);
        myWorld.addObject( t10, 1070, 700);
        myWorld.addObject( t11, 50, 670);
        myWorld.addObject( t12, 150, 700);
        myWorld.addObject( t13, 250, 640);
        myWorld.addObject( t14, 250, 640);

        myWorld.addObject( r3, 250, 700);
        myWorld.addObject( r4, 950, 700);

		myWorld.addObject( r5, 950, 700);
		myWorld.addObject( r6, 950, 700);
		myWorld.addObject( r7, 950, 700);
        myWorld.addObject( r8, 950, 700);
        
        myWorld.addObject( r9, 740, 700);
        myWorld.addObject( r10, 500, 700);

        // B. Coins:
	    // 1. Construct coin objects
        Coin coin1 = new Coin();
        Coin coin2 = new Coin();
        Coin coin3 = new Coin();
        Coin coin4 = new Coin();
        Coin coin5 = new Coin();

	    // 2. Add coins to Land terrain 1 (why? Next question, Why not land terrain 2??)
        landTerrain1.addChild ( coin1 );
        landTerrain1.addChild ( coin2 );
        landTerrain1.addChild ( coin3 );
        landTerrain1.addChild ( coin4 );
        landTerrain1.addChild ( coin5 );

		// 3. add the coins to MyWorld
        myWorld.addObject( coin1, 1000, 700);
        myWorld.addObject( coin2, 500, 500);
        myWorld.addObject( coin3, 600, 600);
        myWorld.addObject( coin4, 100, 700);
        myWorld.addObject( coin5, 350, 650);


        // E. Create the Player and it to appropriate coordinatesin the world
        Player p = new Player();
        p.getImage().scale(50,50);
        myWorld.addObject( p, 600, 700);
      
	  // F. Setup the 'Target' terrain
        target = new Target();
        target.getImage().scale(myWorld.getWidth(),100);  

        
    }
}