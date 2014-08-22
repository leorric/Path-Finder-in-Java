package ui;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import util.Consts;

public class Cursor {
	
	private int x;
	private int y;
	private Image img;
	private boolean chosen; //��ɫ�Ƿ�ѡ��

	
	
	public Cursor(int x,int y){
		this.x = x;
		this.y = y;
		ImageIcon icon = new ImageIcon(getClass().getResource("../resources/s2.png"));
		img = icon.getImage();
	}
	
	public void drawSelf(Graphics2D g2d) {  
		int offset = Consts.HCS;
		int horizon = x * Consts.HCS + offset;
		int vertical = y * Consts.VCS;
	
		g2d.drawImage(img,horizon,vertical, null);	
	}
	
	public void move(int direction){
		switch(direction){
			case 1:
				x += 1;
				return;
			case -1:
				x -= 1;
				return;
			case 2:
				y += 1;
				return;
			case -2:
				y -= 1;
				return;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isChosen() {
		return chosen;
	}

	public void setChosen(boolean chosen) {
		this.chosen = chosen;
	}
}
