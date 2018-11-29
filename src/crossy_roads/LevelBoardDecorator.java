import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Font;
import greenfoot.Color;

/**
 * Write a description of class LevelCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelBoardDecorator extends Actor implements ILevelBoardDecorator
{
	private ILevelBoardDecorator levelBoard;
	
	public LevelBoardDecorator(ILevelBoardDecorator board){
		this.levelBoard = board;
		this.setImage(((LevelBoard) board).getImage());
	}
	
	public void showLevelBoard() {
		int level = ((LevelBoard)levelBoard).getLevel();
		LevelBoard b = (LevelBoard) this.levelBoard;
		GreenfootImage image = ((Actor)b).getImage();
		//setImage(image);
		image.setColor (b.getBackgroundColor());
        image.fill();
        image.setColor (b.getTextColor());
        String s = "LEVEL " + level;
        image.drawString(s, 1, 32);
	}
}
