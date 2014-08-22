package action;

import java.util.Map;

import util.Consts;
import util.Util;

import entity.Location;
import entity.Character;
public class MoveX implements Moveable{
	
	
	
	public int fakeMove(Character c,Location dest,int[][] map){
		Location start = c.getLo();
		int result = 0;
		int count = 0;
		while(true){
			result = moveOneStep(c,dest,map);
			printLocation(c.getLo());
			count++;
			if(result == 0){
				return 10000; //no way to dest
			}else if(result == 2){
				return count;
			}
			if(count>100) {
				System.out.println("ABD");
				return count;
			}
		}
	}
	
	public int moveOneStep(Character c,Location dest,int[][] map){
		Location lo = c.getLo();
		Map<String,String> route = c.getRoute();
		int x = lo.getX();
		int y = lo.getY();
		int destX = dest.getX();
		int destY = dest.getY();
		int tempX = x;
		int tempY = y;
		int horizon = 0;
		int vertical = 0;
		int type = 0;
		boolean hasBeen = false;
		
		
		// x towords destination
		if(x < destX){
			tempX = x+1;
			horizon = 1;
		}else if(x > destX){
			tempX = x-1;
			horizon = -1;
		}
		//check
		hasBeen = hasBeen(tempX, tempY,route);
		type = map[y][tempX];
		if(type == Consts.GROUND && !hasBeen){
			c.setLocationX(tempX);
//			lo.setX(tempX);
//			System.out.println("putX:"+""+x+tempY);
			route.put(""+tempX+"|"+y, "");
			return 1;
		}else if(Util.reachDestination(dest, tempX, y)){
			c.setLocationX(tempX);
//			lo.setX(tempX);
			System.out.println("reach");
			return 2;
		}
		
		// y towards destination
		if(y < destY){
			tempY = y+1;
			vertical = 1;
		}else if(y > destY){
			tempY = y-1;
			vertical = -1;
		}
		//check
		hasBeen = hasBeen(x, tempY,route);
		type = map[tempY][x];
		if(type == Consts.GROUND && !hasBeen){
			c.setLocationY(tempY);
//			lo.setY(tempY);
//			System.out.println("putY:"+""+x+tempY);
			route.put(""+x+"|"+tempY, "");
			return 1;
		}else if(Util.reachDestination(dest, x, tempY)){
			c.setLocationY(tempY);
//			lo.setY(tempY);
			System.out.println("reach");
			return 2;
		}
		
		//to place never been
		Location nextLocation = this.toPlaceNeverBeen(c, map,dest,horizon, vertical);
		if(nextLocation == null){
			return 0;
		}else if(!nextLocation.equals(dest)){
			return 1;
		}else{
			System.out.println("reach");
			return 2;
		}
	}
	
	private Location toPlaceNeverBeen(Character c,int[][] map,Location dest,int horizon,int vertical){
		Location current = c.getLo();
		
		Map<String,String> route = c.getRoute();
		
		int x = current.getX();
		int y = current.getY();
		int tempX = x;
		int tempY = y;
		int type = 0;
		boolean hasBeen = false;
		
		if(Util.checkPositionAvail(x-1,y,route,map)){
			tempX = x-1;
		}else if(Util.checkPositionAvail(x+1,y,route,map)){
			tempX = x+1;
		}else{
			hasBeen = true;
		}
		if(tempX != x){
//			c.setLocationX(tempX);
			route.put(""+tempX+"|"+y, "");
			return current;
		}
		
		if(Util.checkPositionAvail(x,y-1,route,map)){
			tempY = y-1;
		}else if(Util.checkPositionAvail(x,y+1,route,map)){
			tempY = y+1;
		}else{
			hasBeen = true;
		}
		
		if(tempY != y){
//			c.setLocationY(tempY);
			route.put(""+x+"|"+tempY, "");
			return current;
		}
	
		return null;
	}
	
	private boolean hasBeen(int x,int y,Map<String,String> route){
		String id = ""+x+"|"+y;
		String result = route.get(id);
		if(result == null){
			return false;
		}else{
			return true;
		}
	}
	
	private void printLocation(Location lo){
		System.out.println("current place: ["+lo.getX()+","+lo.getY()+"]");	
	}
}
