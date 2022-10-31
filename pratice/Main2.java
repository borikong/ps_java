package pratice;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int T=input.nextInt();
		
		for (int t = 0; t < T; t++) {
			int M=input.nextInt();
			int N=input.nextInt();
			int x=input.nextInt();
			int y=input.nextInt();
			
			int lcm=lcm(M,N);
			int year=x;
			
			
			while(true) { //추정한 값이 최소공배수보다 큰 경우 멈춤
				if(year>lcm) {
					System.out.println(-1);
					break;
				}else if(((year%N)==0?N:year%N)==y) {
					System.out.println(year);
					break;
				}
				year+=M;
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
