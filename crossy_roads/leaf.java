import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// leaf class in the composite pattern. All the leafs will extend this class
public class Leaf extends Actor implements Component {
    
    
    /**
     * Act - do whatever the leaf wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
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

    
     
}
