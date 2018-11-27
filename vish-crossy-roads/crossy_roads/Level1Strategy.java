
import java.util.ArrayList;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Level1Strategy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1Strategy extends Actor implements LevelStrategy {
    private int targetTimer=0;
    
    private  boolean isFinishLevelReached = false;
    private static int speed = 3;
    private Target target;
    private MyWorld myWorld;

    private ArrayList<Car> redcarObservers = new ArrayList<>();
    private ArrayList<CarBlue> bluecarObservers = new ArrayList<>();
    private ArrayList<Log> logObservers = new ArrayList<>();
    private ArrayList<Coin> coinObservers = new ArrayList<>();

    private Player p;
    private Leaf leaf;

    public void act(){
       runTargetTimer();
       
    }

    public static int getSpeed(){
       return speed;
    }
    
    public void runTargetTimer()
    {
        boolean finishstate = getFinishLevel();
        if(finishstate==false){
            
            if(targetTimer==2000){
                addTarget();
            }
            else
                targetTimer++;
        } 
        else{
            notifyAllObservers(finishstate);
        }
        
    }
    public void setFinishLevel(boolean state){
        isFinishLevelReached = state;
    }

    public boolean getFinishLevel(){
        return isFinishLevelReached;
    }

    public void addTarget(){
        MyWorld myWorld =  getWorldOfType(MyWorld.class);
        myWorld.addObject( target, 600, 50);
    }
    
    public void loadTerrains() {    

        myWorld =  getWorldOfType(MyWorld.class);  
        leaf = new Leaf();

        int y = 0;
      
        createRiverTerrain(y);
        
        y+=300;        
        createLandTerrain(y);
        
        y+=100;
        createRoadTerrain(y);
        
        y+=300;
        createLandTerrain(y);

        createPlayer();
        createTarget();
    }
    
    public void createTarget(){
        target = new Target();
        target.attachStrategy(this);
        target.getImage().scale(myWorld.getWidth(),100);
    }
    public void createRiverTerrain(int y) {
        //------------------------------------------------------------
         // A. River terrain:
        // 1. Create river terrain object
        RiverTerrain riverTerrain = new RiverTerrain();
      
        // 2. Create river object
        River r = new River();

        // 4. Scale river image
        // r.getImage().scale(2400,300);
      
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
        
        this.attachLogs(log1);
        this.attachLogs(log2);
        this.attachLogs(log3);
        this.attachLogs(log4);

        notifyLogs(false);
      
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


        // 3. Adding river terrain to my world
        myWorld.addObject(riverTerrain,0,y);
      
    }
    
    public void createLandTerrain(int y) {
        
        //------------------------------------------------------------
         // B. Land Terrain 1:
        
        // Lan Terrain Creation
        LandTerrain landTerrain1 = new LandTerrain(); 
        
        // 2. Land objects
        Land l1 = new Land();//Upper 


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
        r6.scale(60,60);
        r7.scale(60,60);
        r8.scale(60,60);
        r10.scale(70,70);
        
        // 6. Scale tree images to appropriate size
        t7.scale(40,85);
        t8.scale(40,85);
        t9.scale(40,85);
        t10.scale(40,85);
        t11.scale(40,85);
        t12.scale(40,85);
        t13.scale(20,65);
        t14.scale(20,65);
        
        // 7. Scale image of land to appropriate size

        if (y == 300)
            l1.scale(2500,300);
        else
            l1.scale(2500,120);


         // 8. Setup the composite pattern for land terrain
        landTerrain1.addChild ( l1 );

        //9. Adding trees as children on LandTerrain1
        landTerrain1.addChild ( t3 );
        landTerrain1.addChild ( r1 );

        landTerrain1.addChild ( t4 );
        landTerrain1.addChild ( r2 );

        landTerrain1.addChild ( t5 );
        landTerrain1.addChild ( r5 );

        landTerrain1.addChild ( t6 );
        landTerrain1.addChild ( r6 );

        landTerrain1.addChild ( t7 );
        landTerrain1.addChild ( r7 );

        landTerrain1.addChild ( t8 );  
        landTerrain1.addChild ( r8 );

        myWorld.addObject(landTerrain1,0,y);

        
        //------------------------------------------------------------
        // E.Coins
        // 1. Construct coin objects
        Coin coin1 = new Coin();
        Coin coin2 = new Coin();
        Coin coin3 = new Coin();
        Coin coin4 = new Coin();
        Coin coin5 = new Coin();

        this.attachCoins(coin1);
        this.attachCoins(coin2);
        this.attachCoins(coin3);
        this.attachCoins(coin4);
        this.attachCoins(coin5);
        

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

    }
   
       
    public void createRoadTerrain(int y) {
        
       //------------------------------------------------------------
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

        this.attachRedCars(car2);
        this.attachRedCars(car5);
        this.attachRedCars(car8);
        this.attachRedCars(car11);
        notifyRedCars(false);

        this.attachBlueCars(car1);
        this.attachBlueCars(car3);
        this.attachBlueCars(car4);
        this.attachBlueCars(car6);
        this.attachBlueCars(car7);
        this.attachBlueCars(car9);
        this.attachBlueCars(car10);
        this.attachBlueCars(car12);

        notifyBlueCars(false);
        
     
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
      
        // 7. Adding road terrain to the my world
        myWorld.addObject( roadTerrain, 0, y );

    }
    
    
   public void createPlayer() {
        // F. Create the Player and it to appropriate coordinatesin the world
        p = new Player();
        //System.out.println("Attaching myWorld as the observer for Player..");
        p.attachObserver(myWorld);
        p.getImage().scale(50,50);
        myWorld.addObject( p, 600, 650);
    }
    public void attachRedCars(Car car){
        redcarObservers.add(car);
    }
    public void notifyRedCars(boolean state){
        for (Car car : redcarObservers){
            car.update(state);
        }
    }
    public void attachBlueCars(CarBlue car){
        bluecarObservers.add(car);
    }
    public void notifyBlueCars(boolean state){
        for (CarBlue car : bluecarObservers){
            car.update(state);
        }
    }

    public void attachLogs(Log log){
        logObservers.add(log);
    }
    public void notifyLogs(boolean state){
        for (Log log : logObservers){
            log.update(state);
        }
    }
    public void attachCoins(Coin coin){
        coinObservers.add(coin);
    }
    public void notifyCoins(boolean state){
        for (Coin coin  : coinObservers){
            coin.update(state);
        }
    }

    public void notifyAllObservers(boolean state){
        leaf.update(finishstate);
        target.update(finishstate);
        p.update(finishstate);
        notifyRedCars(finishstate);
        notifyBlueCars(finishstate);
        notifyLogs(finishstate);
        notifyCoins(finishstate);
    }
}