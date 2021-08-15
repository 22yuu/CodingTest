package math;

public class factorial {
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;
	
	
	public static int fact(int n) {
		// 5! 5 x 4 x 3 x 2 x 1
		if(n == 3) return n;
		return n*fact(n-1); //5 * fact(4) -> 4 * fact(3) -> 3 * fact(2) -> 2 * fact(1);
	}						//5*24 = 120  <-	24		 <-	    6		<-     2
	
	public static void main(String[] args) {
		System.out.println(max);
		System.out.println(min);
	}
}
