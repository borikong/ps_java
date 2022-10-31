package pratice;

import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;

class tomato1{
	int x,y,z;
	
	tomato1(int x, int y, int z){
		this.x=x;
		this.y=y;
		this.x=x;
	}
}

public class Tomato_7569_pr {
	static int X,Y,Z;
	static int[][][] map;
	static Queue<tomato1> que;
	
	static int[] dx= {-1,1,0,0,0,0};
	static int[] dy= {0,0,-1,1,0,0};
	static int[] dz= {0,0,0,0,-1,1};
	
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		X=input.nextInt();
		Y=input.nextInt();
		Z=input.nextInt();
		
		map=new int[Z][Y][X];
		
		for (int i = 0; i < Z; i++) {
			for (int j = 0; j < Y; j++) {
				for (int p = 0; p < X; p++) {
					map[i][j][p]=input.nextInt();
					
				}
			}
		}
		
		
		
	}
	
	public static void printmap() {
		for (int i = 0; i < dx.length; i++) {
			for (int j = 0; j < dx.length; j++) {
				for (int j2 = 0; j2 < dx.length; j2++) {
					
				}
			}
		}
	}
}
