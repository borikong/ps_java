package algorithm;

public class Euclidean {

	public static void main(String[] args) {
		
		System.out.println(ecd(6,10));
	}
	
	public static int ecd(int a, int b) {
		int r=a%b;
		if(r==0) {
			return b;
		}
		
		return ecd(b,r);
	}
	
}
