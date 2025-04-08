import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리_14940 {
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int x;
	static int y;
	static int[][] map; 
	static int[][] visited;
	static int[][] distance;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		Point startPoint = null;
		
		map = new int[y][x];
		visited = new int[y][x];
		distance = new int[y][x];
		
		for (int i = 0; i < y; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < x; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
				if(map[i][j]==0)
					distance[i][j] = 0;
				else
					distance[i][j] = -1;
				if(map[i][j]==2){
					startPoint=new Point(j, i);
				}
			}
		} // end for
		
		bfs(startPoint);
		
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				System.out.print(distance[i][j]);
				if(j==x-1) continue;
				System.out.print(" ");					
			}
			
			if(i==y-1) continue;
			
			System.out.println();
		}

	}
	
	public static void bfs(Point start) {
		Queue<Point> queue= new LinkedList<Point>();

		queue.add(start);
		visited[start.getY()][start.getX()]=1;
		distance[start.getY()][start.getX()]=0;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int i=0; i<4;i++) {
				int nx = p.getX() + dx[i];
				int ny = p.getY() + dy[i];
				
				if(nx<0 || ny<0 || nx>=x || ny>=y || visited[ny][nx]==1 || map[ny][nx]==0) continue;
				distance[ny][nx]=distance[p.getY()][p.getX()]+1;
				queue.add(new Point(nx, ny));
				visited[ny][nx]=1;
			}
		}
	}
}

class Point{
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
