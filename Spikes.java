//Spikes.java
//Vasav Shah, Kevin Shi
//Creates spike objects. They are very similar to boxes excet when they are hit, the user starts falling. They also cause the user to lose
//coins.
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Spikes {
	private int xPos,yPos;
	private String type;
	private Rectangle spikeRect;
	private Image spikeImage;
	public boolean onScreen;
    public Spikes(int x,int y,int by){
    	//takes an x and y value and a by value as parameters
    	xPos=x;
    	yPos=y;
    	onScreen=true;
    	//Decides what image the box should take on depending on the level of the game
    	if (by<=3796 && by>=0){
    		type="wood";
    	}
    	else if(by>3796 && by<=7613){
    		type="stone";
    	}
    	else if(by>7613 && by<=18406){
    		type="green";
    	}
    	else{
    		type="steel";    		
    	}
    	loadImages();
    }
	public boolean checkCollision(Image ePic,Player p){
		//Checks to see if the player has collided with the image
		if (getImage()!=null){
			spikeRect= new Rectangle (xPos,yPos,getWidth(),getHeight());
			if (spikeRect.intersects(p.getRect())){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
    public void loadImages(){
    	//loads the image the spike takes on
    	spikeImage= new ImageIcon("gamelayerstuff/spikes/"+type+".png").getImage();
    }
//Getters
    public Image getImage(){
    	return spikeImage;
    }
    public int getHeight(){
    	return spikeImage.getHeight(null);
    }
    public int getWidth(){
    	return spikeImage.getWidth(null);
    }
    public int getX(){
    	return xPos;
    }
    public int getY(){
    	return yPos;
    }
    public boolean getOnScreen(){
    	return onScreen;
    }
//Setters
    public void setX(int x){
    	xPos=x;
    }
    public void setY(int y){
    	yPos=y;
    	if (y>1000){
    		onScreen=false;
    	}
    }
}