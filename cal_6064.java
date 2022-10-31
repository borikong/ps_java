import java.util.Scanner;

//M,N,x,y
//x < M 이면 x' = x + 1이고, 그렇지 않으면 x' = 1
//T개의 테스트케이스 =>T줄

public class cal_6064 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int T=input.nextInt();
		
		for (int t = 0; t < T; t++) {
			int M=input.nextInt();
			int N=input.nextInt();
			int x=input.nextInt();
			int y=input.nextInt();
			
			int ans=0;
			int i=0;
			
			int lcm=lcm(M,N); //x부터 구할 것이기 때문
			int year=0;
			
			
			while(year<lcm) { //추정한 값이 최소공배수보다 작은 경우 멈춤
				year=M*i+x;//x의 순환 횟수(i회 순환되며 i가 1씩 증가)
				//System.out.println(year);
				if((year%N)==y) { //x로 추정한 year을 순환하는 N으로 나눈 나머지가 y
					ans=year;
					break;
				}
				i++;
			}
			
			if(ans==0) {
				System.out.println(-1);
			}else {
				System.out.println(ans);
			}
		}
		
	}
	
	static int lcm(int n1, int n2) {
		return (n1*n2)/gcd(n1,n2);
	}
	
	static int gcd(int n1, int n2) { //최대공약수
		if(n2==0)
			return n1;
		
		return gcd(n2,n1%n2);
	}

}
