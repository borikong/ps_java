import java.util.*;

public class 적록색약_10026 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String[] s;
		int N=input.nextInt();
		String[][] map=new String[N][N];
		for (int i = 0; i < N; i++) {
			s=input.next().split("");
//			System.out.println(Arrays.toString(s));
			map[i]=s;
		}
		
		printmap(N, map);
	}


	public static void printmap(int N,String[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void bfs() {
		
	}

}
