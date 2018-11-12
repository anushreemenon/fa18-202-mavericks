import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


import java.util.ArrayList;

public class composite extends Actor implements Component {

    protected ArrayList<Component> components = new ArrayList<Component>()  ;
    
    /**
     * Act - do whatever the composite wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public composite ()
    {
       
    }
    
    public composite ( String d )
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
        // for (Component obj  : components)
        // {
        //     obj.printDescription();
        // }
    }
}