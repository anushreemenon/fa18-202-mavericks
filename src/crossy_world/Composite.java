import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


import java.util.ArrayList;
// Composite class in the composite pattern. All the terrains will extend this class
public class Composite extends Actor implements Component {

    protected ArrayList<Component> components = new ArrayList<Component>()  ;
    
    /**
     * Act - do whatever the composite wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public Composite ()
    {
       
    }
    
    public Composite ( String d )
    {
       
        
    }
    

    public void addChild(Component c) {
        components.add( c ) ;
    }
     
    public void remove(Component c) {
        components.remove(c) ;
    }
     
    public Component getChild(int i) {
        return components.get( i ) ;
    }
    
    public void display(){
        // add implementation below
         for (Component obj  : components)
         {
             obj.display();
         }
    }

   
}