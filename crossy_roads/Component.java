public interface Component {
    void display() ;
    Component getChild(int i);
    void addChild(Component c);
    void remove(Component c);   
}