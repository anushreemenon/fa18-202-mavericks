import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// leaf class in the composite pattern. All the leafs will extend this class
public class Leaf extends Actor implements Component {
    
    
    /**
     * Act - do whatever the leaf wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean isFinishLevelReached = false;
    
    public void act() 
    {
        World world = getWorld();
        // Add your action code here.
        int worldX = world.getWidth();      
        int worldY = world.getHeight();
        if(getFinishLevel()==false)
            setLocation((getX())%worldX, (getY()+1)%worldY);
    }
    public Leaf() {
        
    }
    public Leaf (String d) 
    {
       
    }
    
    public void addChild(Component c) {
        // no implementation
    }

    public void remove(Component c) {
        // no implementation
    }

    public Component getChild(int i) {
        // no implementation
        return null ;
    }
    
    
    public void display(){
        // add implementation
    }

    public void scale(int x, int y) {
        this.getImage().scale(x,y);
    }
    public void update(boolean state){
        this.isFinishLevelReached =  state;
    }
    public boolean getFinishLevel(){
        return isFinishLevelReached;
    }

     
}
