import java.util.Scanner;

//M,N,x,y
//x < M 이면 x' = x + 1이고, 그렇지 않으면 x' = 1
//T개의 테스트케이스 =>T줄

//최소공배수, 최대공약수
//년도를 M으로 나눈 나머지와 N으로 나눈 나머지의 공통 수를 구해야 함
//년도%M=x 년도%N=y

//brute force

public class cal_6064 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		//T=input.nextInt();
		
		int M=input.nextInt();
		int N=input.nextInt();
		int x=input.nextInt();
		int y=input.nextInt();
		
		int ans;
		int i=0;
		
		while(true) {
			i++;
			if((i%M==x)&&(i%N==y)) {
				ans=i;
				break;
			}
		}
		
		System.out.println(ans);

	}

}
