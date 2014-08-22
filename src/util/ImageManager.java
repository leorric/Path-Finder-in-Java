package util;


import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageManager {
	
	private Image ground;
	private Image topWall;
	private Image sideWall;
	private Image cursor;
	private Image army;
	private Image target;
	private static ImageManager instance;
	  
	public static ImageManager getInstance(){
		  if(instance == null){
			  return new ImageManager();
		  }
		  return instance;
	}
	  
	private ImageManager(){
		  ground = loadImg("../resources/ground5.jpg");
		  topWall = loadImg("../resources/wall5.jpg");
		  sideWall = loadImg("../resources/sidewall5.jpg");
		  //cursor = loadImg("../resources/select.jpg");
		  army = loadImg("../resources/army.jpg");
		  target = loadImg("../resources/target.jpg");
	}
	  
	public Image loadImg(String imgUrl){
		 ImageIcon icon = new ImageIcon(getClass().getResource(imgUrl));
		 return icon.getImage();
	}
	
	public Image getImageByType(int type){
			Image img = null;
			switch(type) {
				case 1:
					img = ground;
					break;
					
				case 2:
					img = topWall;
					break;
					
				case 3:
					img = sideWall;
					break;	
				
				case 4:
					img = target;
					break;	
			}
			return img;
	}  
	  
	public Image getGround() {
		return ground;
	}

	public Image getTopWall() {
		return topWall;
	}

	public Image getSideWall() {
		return sideWall;
	}

	public Image getCursor() {
		return cursor;
	}

	public Image getArmy() {
		return army;
	}

	public Image getTarget() {
		return target;
	}

	public void setTarget(Image target) {
		this.target = target;
	}
}
