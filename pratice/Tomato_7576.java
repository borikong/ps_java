package pratice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class tomato{
	int x,y;
	
	tomato(int x, int y){
		this.x=x;
		this.y=y;
	}
}


public class Tomato_7576 {

	static int N,M;
	static Queue<tomato> que;
	static int[][] map;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		
		N=input.nextInt(); //x
		M=input.nextInt(); //y
		
		que=new LinkedList<tomato>();
		map=new int[M][N];
		
		for (int i = 0; i <M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=input.nextInt();
				if(map[i][j]==1) {
					que.add(new tomato(j,i));
				}
			}
		}
		
		BFS();
		
		boolean flag=false;
		int cnt=0;
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==0) {
					cnt=0;
					flag=true;
					break;
				}else {
					cnt=Math.max(cnt, map[i][j]);
				}
			}
			if(flag) {
				break;
			}
			
		}
		
		System.out.println(cnt-1);

	}
	
	public static void BFS() {
		
		while(!que.isEmpty()) {
			tomato t=que.remove();
			int x=t.x;
			int y=t.y;
			
			for (int i = 0; i < 4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if (nx<N&&nx>=0&&ny<M&&ny>=0) {
					if(map[ny][nx]==0) {
						map[ny][nx]=map[y][x]+1;
						que.add(new tomato(nx,ny));
					}
				}
			}
			
		}
		
		printmap();
		
	}
	
	public static void printmap() {
		System.out.println();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
