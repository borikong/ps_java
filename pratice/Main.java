package pratice;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int T=input.nextInt();
		
		for (int t = 0; t < T; t++) {
			int M=input.nextInt();
			int N=input.nextInt();
			int x=input.nextInt();
			int y=input.nextInt();
			
			int year=x;
			int last=lcm(N,M);
			
			while(true) {
				
				if(year>last) {
					System.out.println(-1);
					break;
				}else if(((year%N)==0?N:year%N)==y) { //year이 N보다 작으면 N, 크면 나머지
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
