/**
 * Write a description of class interface1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface LevelStrategy  
{
    public void loadTerrains();
    public void setFinishLevel(boolean state);
    public int getCarSpeed();
    public int getLogSpeed();
    public void resetTimer();
    public String levelInfo();
    
}
