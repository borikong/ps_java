
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//bfs
//너비우선탐색 하면서 탐색 할 때 마다 부모노드+1만큼 숫자 넣어주기

//토마토 객체를 만듦
class tomato{
	int x;
	int y;
	
	tomato(int x,int y){
		this.x=x;
		this.y=y;
	}
}

public class Tomato_7576 {
	static int N; //x
	static int M; //y
	static int[] dx= {-1,1,0,0}; //x축으로 좌, 우, 위, 아래
	static int[] dy= {0,0,-1,1};//y축으로 좌, 우, 위, 아래
	
	static int[][] map; //토마토 판을 표현할 이차원 배열
	
	static Queue<tomato> que; //익은 토마토 객체를 담을 queue
	

	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		N=input.nextInt(); //x
		M=input.nextInt(); //y
		
		map=new int[M][N]; //M열 N행 크기의 2차원 배열을 만듦
		que=new LinkedList<tomato>(); //

		//사용자로 부터 받은 입력을 토마토 판에 담는다.
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=input.nextInt();
				if(map[i][j]==1) {
					que.add(new tomato(j,i)); //j가 x이고 i가 y
				}
			}
		}
		
		//BFS 알고리즘 사용
		BFS();
		
		int cnt=0;
		boolean flag=false;
		
		//빈 토마토 판이 있는지 찾기 0이면 flag를 true로 만들고 break
		for (int i = 0; i < M; i++) {
			for (int j = 0; j <N; j++) {
				if(map[i][j]==0) { //썩지 않은 토마토가 있으면
					cnt=0;
					flag=true; 
					break;
				}else {
					cnt=Math.max(cnt, map[i][j]); //가장 오래 걸리는 날짜를 선택해야 하므로 max
						
				}
			}
			if(flag) {
				break; //썩지 않은 토마토가 있다면 break
			}
		}
		
		System.out.println(cnt-1); //처음 토마토를 1부터 시작했으므로 1을 빼줌
	}
	
	//Queue
	//add() : 맨 뒤에 삽입, 성공시 true 반환, 꽉 찬 경우 IllegalStateException
	//offer(): 맨 뒤에 삽입, 성공시 true, 실패시 false
	//remove() : 큐 맨 앞에 있는 값 반환 후 삭제, 빈 경우 NoSuchElementException

	
	public static int BFS() {
		
		while(!que.isEmpty()) { //que가 비지 않았다면
			tomato t=que.remove(); //que에서 토마토 객체 꺼냄
			
			//remove()함수로 pop()한 x,y 좌표를 꺼내줌
			int x=t.x; //꺼낸 객체에 저장된 x 좌표
			int y=t.y; //꺼낸 객체에 저장되 y 좌표
			
			for (int i = 0; i < 4; i++) {
				int nx=x+dx[i]; 
				int ny=y+dy[i]; 

				
				if(nx<N&&nx>=0&&ny<M&&ny>=0) {
					if(map[ny][nx]==0) { //썩지 않은 토마토가 있으면
						que.add(new tomato(nx,ny)); //큐에 추가
						map[ny][nx]=map[y][x]+1; //
					}
				}
				
			}
		}
		
		
		printmap();
		
		return 0;
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
