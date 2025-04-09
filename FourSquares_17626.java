import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//dynamic programming
public class FourSquares_17626 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int min=0;
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=1;
		
		for (int i = 2; i <= n; i++) { 
			min=Integer.MAX_VALUE;
			
			//제곱 되는 것들을 먼저 구한다음 나머지 숫자의 최소
			for (int j = 1; j*j <= i; j++) {
				min = Math.min(min, dp[i-j*j]);
			}
				
			// 제곱수j*j의 경우는 횟수 +1
			dp[i]=min+1;
		}
		
		System.out.println(dp[n]);
	}
	
}
