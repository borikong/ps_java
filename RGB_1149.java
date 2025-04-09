import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dynamic programming
public class RGB_1149 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] h = new int[n+1][3]; //number of the house+1, rgb
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//i:r i-1: g(1) or b(2)
			h[i][0]= Math.min(h[i-1][1]+g, h[i-1][2]+b);
			// g
			h[i][1]= Math.min(h[i-1][0]+r, h[i-1][2]+b);
			// b
			h[i][2]= Math.min(h[i-1][0]+r, h[i-1][1]+g);
		}
		
		System.out.println(Math.min(h[n][0], Math.min(h[n][1], h[n][2])));
		
	}
}
