package listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import ui.Cursor;
import ui.FireEmblePanel;
import util.Util;
import entity.Character;
import entity.Location;;
public class InstructionListener extends KeyAdapter{
	
	private JPanel panel;
	
	public InstructionListener(JPanel panel){
		this.panel = panel;
	}
	
	public void keyPressed(KeyEvent e){
		int[][] map = ((FireEmblePanel)panel).getMap();
		Cursor cursor = ((FireEmblePanel)panel).getCursors();
		Character c = ((FireEmblePanel)panel).getC();
		int k = e.getKeyCode();
		int direction = 0;
		int x = 0;
		int y = 0;
		switch(k){
			case KeyEvent.VK_UP:
				direction = -2;
				break;
				
			case KeyEvent.VK_DOWN:
				direction = 2;
				break;
				
			case KeyEvent.VK_LEFT:
				direction = -1;
				break;
				
			case KeyEvent.VK_RIGHT:
				direction = 1;
				break;
				
			case KeyEvent.VK_S:  // create wall
			
				x = cursor.getX();
				y = cursor.getY();
				map[y][x] = 2;
				 ((FireEmblePanel)panel).setMap(map);
				break;
			
			case KeyEvent.VK_D: // create ground
				x = cursor.getX();
				y = cursor.getY();
				map[y][x] = 1;
				 ((FireEmblePanel)panel).setMap(map);
				break;
			
			case KeyEvent.VK_T: // create ground
				x = cursor.getX();
				y = cursor.getY();
				map[y][x] = 4;
				 ((FireEmblePanel)panel).setMap(map);
				 
				break;
				
			case KeyEvent.VK_X:
				x = cursor.getX();
				y = cursor.getY();
				if(cursor.isChosen()){
					System.out.println("move");
					c.setBlink(false);
					Location lo = new Location(x,y);
					Thread move = new MoveThread(c,lo,map,cursor);
					move.start();
					
					
				}else{
					
					if(c.getLo().getX()==x && c.getLo().getY() == y){
						System.out.println("chosen");
						c.setBlink(true);
						cursor.setChosen(true);
					}
				}
				break;
				
			
			case KeyEvent.VK_P:
				Util.printMap(map);
				break;
		}
		cursor.move(direction);
	}
	
	class MoveThread extends Thread{
		private Character c;
		private Location lo;
		private int[][] map;
		private Cursor cursor;
		public MoveThread(Character c,Location lo,int[][] map,Cursor cursor){
			this.c = c;
			this.lo = lo;
			this.map = map;
			this.cursor = cursor;
		}
		
		public void run(){
			c.moveForward(map, lo);
			cursor.setChosen(false);
		}
	}
}
