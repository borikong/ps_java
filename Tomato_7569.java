import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//BFS로 풀이
//기본 BFS와 동일한데 z축만 추가됨

class tomato1{
	int x,y,z; //z축이 있으므로
	
	public tomato1(int x, int y, int z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
}

//public class Main으로 바꿔야 함
public class Tomato_7569 {

	static int X,Y,Z;
	static int[][][] map;
	static int[] dx= {-1,1,0,0,0,0}; //왼, 오, 위, 아래, 아래층, 위층
	static int[] dy= {0,0,-1,1,0,0};
	static int[] dz= {0,0,0,0,-1,1};
	static Queue<tomato1> que;
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		boolean flag=false;
		
		X=input.nextInt();
		Y=input.nextInt();
		Z=input.nextInt();
		
		que=new LinkedList<tomato1>();
		map=new int[Z][Y][X];
		
		for (int i = 0; i <Z; i++) {
			for (int j = 0; j < Y; j++) {
				for (int z = 0; z < X; z++) {
					map[i][j][z]=input.nextInt();
					if(map[i][j][z]==1) {
						que.add(new tomato1(z,j,i));
					}
					if(map[i][j][z]==0) {
						flag=true; //토마토가 하나라도 덜 익은 상태이면 flag를 true로 만듦
					}
				}
			}
			
		} 
		
		if(flag) {
			BFS();
			//printmap();
			
			flag=false;
			int cnt=0;
			for (int i = 0; i < Z; i++) {
				for (int j = 0; j < Y; j++) {
					for (int z = 0; z < X; z++) {
						if(map[i][j][z]==0) {
							flag=true;
							cnt=0;
							break;
						}else {
							cnt=Math.max(cnt, map[i][j][z]);
						}
					}
					if(flag) break;
				}
				if(flag) break;
			}
			
			System.out.println(cnt-1);
		}else {
			System.out.print(0);
		}

	}
	
	public static void BFS() {
		
		while(!que.isEmpty()) {
			tomato1 t=que.remove();
			
			int x=t.x;
			int y=t.y;
			int z=t.z;
			
			for (int i = 0; i < dx.length; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				int nz=z+dz[i];
				
				if(nx<X&&nx>=0&&ny<Y&&ny>=0&&nz<Z&&nz>=0) {
					if(map[nz][ny][nx]==0) {
						map[nz][ny][nx]=map[z][y][x]+1;
						que.add(new tomato1(nx,ny,nz));
					}
				}
			}
		}
		
	}
	
	static void printmap() {
		for (int i = 0; i < Z; i++) {
			for (int j = 0; j < Y; j++) {
				for (int z = 0; z < X; z++) {
					System.out.print(map[i][j][z]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
