package action;

import entity.Location;
import entity.Character;
public interface Moveable {
	
	int fakeMove(Character c,Location dest,int[][] map);
}
