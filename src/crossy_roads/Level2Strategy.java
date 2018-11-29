
import java.util.ArrayList;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Level2Strategy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2Strategy extends Actor implements LevelStrategy {
    private int targetTimer=0;
    
    private  boolean isFinishLevelReached = false;
    private int carSpeed = 5;
    private int logSpeed = 4;
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

    public int getCarSpeed(){
       return carSpeed;
    }
    
    public int getLogSpeed(){
       return logSpeed;
    }
    
    public void runTargetTimer()
    {
        boolean finishstate = getFinishLevel();
        if(finishstate==false){
            
            if(targetTimer==3000){
                addTarget();
            }
            else
                targetTimer++;
        } 
        else{
            notifyAllObservers(finishstate);
            System.out.println("Setting next level");
            myWorld.setNextLevel();
            setFinishLevel(false);
        }
        
    }
    
     public void resetTimer(){
        targetTimer = 0;
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
        RiverTerrain riverTerrain = new RiverTerrain(25);
        try {
        // 2. Create river object
        River r = new River();

        // 4. Scale river image
        // r.getImage().scale(2400,300);
      
        // 5. Create wooden log objects
        Log log1 = new Log();
        log1.attachStrategy(this);
        
        Log log2 = log1.clone();
        log2.attachStrategy(this);
        
        Log log3 = log1.clone();
        log3.attachStrategy(this);
        
        Log log4 = log1.clone(); 
        log4.attachStrategy(this);
        
        Log log5 = log1.clone();
        log5.attachStrategy(this);
        
        Log log6 = log1.clone();
        log6.attachStrategy(this);
        Log log7 = log1.clone();
        log7.attachStrategy(this);
        Log log8 = log1.clone();
        log8.attachStrategy(this);
        Log log9 = log1.clone();
        log9.attachStrategy(this);
        
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
    }
    catch (CloneNotSupportedException ex) {
        System.out.println("Caught exception");
    }
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

        try {
        // 3. Tree objects
        Tree t1 = new Tree();
        Tree t2 = t1.clone();       
        Tree t3 = t1.clone(); 
        Tree t4 = t1.clone(); 
        Tree t5 = t1.clone(); 
        Tree t6 = t1.clone(); 
        Tree t7 = t1.clone(); 
        Tree t8 = t1.clone(); 
        Tree t9 = t1.clone(); 
        Tree t10 = t1.clone(); 
        Tree t11 = t1.clone(); 
        Tree t12 = t1.clone(); 
        Tree t13 = t1.clone(); 
        Tree t14 = t1.clone(); 
 
        // 4. Rock objects
        Rock r1 = new Rock();
        Rock r2 = r1.clone();
        Rock r3 = r1.clone();      
        Rock r4 = r1.clone();
        Rock r5 = r1.clone();
        Rock r6 = r1.clone();
        Rock r7 = r1.clone();
        Rock r8 = r1.clone();
        Rock r9 = r1.clone();
        Rock r10 = r1.clone();
        
        r1.scale(30,40);
        r2.scale(30,40);
        r3.scale(30,40);
        r4.scale(30,40);

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
        myWorld.addObject( coin1, 1000, y);
        myWorld.addObject( coin2, 500, y+200);
        myWorld.addObject( coin3, 600, y);
        myWorld.addObject( coin4, 100, y+300);
        myWorld.addObject( coin5, 350, y+100);
        
           } catch (CloneNotSupportedException ex) {
        System.out.println("Caught exception");
    }

    }
   
       
  public void createRoadTerrain(int y) {
        
       //------------------------------------------------------------
        // C. Road terrain:
        // 1. Create object pof road terrain
        RoadTerrain roadTerrain = new RoadTerrain();
        try {
        // 2. Create objects of road
        Road rd1 = new Road();
        Road rd2 = new Road();
        Road rd3 = new Road();

        // 3. Create objects of car
        CarBlue car1 = new CarBlue();
        car1.attachStrategy(this);
        Car car2 = new Car();   
        car2.attachStrategy(this);
        CarBlue car3 = car1.clone();
        car3.attachStrategy(this);
        CarBlue car4 = car1.clone(); 
        car4.attachStrategy(this);
        Car car5 = car2.clone();
        car5.attachStrategy(this);
        CarBlue car6 = car1.clone();
        car6.attachStrategy(this);
        CarBlue car7 = car1.clone();
        car7.attachStrategy(this);
        Car car8 = car2.clone();   
        car8.attachStrategy(this);
        CarBlue car9 = car1.clone();
        car9.attachStrategy(this);
        CarBlue car10 = car1.clone();
        car10.attachStrategy(this);
        Car car11 = car2.clone();    
        car11.attachStrategy(this);
        CarBlue car12 = car1.clone();
        car12.attachStrategy(this);

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
    } catch (CloneNotSupportedException ex) {
        System.out.println("Caught exception");
    }
    }
    
    
    
   public void createPlayer() {
        // F. Create the Player and it to appropriate coordinatesin the world
        p = new Player();
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

    public void notifyAllObservers(boolean finishstate){
        leaf.update(finishstate);
        target.update(finishstate);
        p.update(finishstate);
        notifyRedCars(finishstate);
        notifyBlueCars(finishstate);
        notifyLogs(finishstate);
        notifyCoins(finishstate);
    }
}
