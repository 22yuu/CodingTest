package silver;
import java.util.*;
import java.io.*;

public class boj11727_2xn≈∏¿œ∏µ2 {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		
		if(n == 1) {
			System.out.println(1);
			return;
		} else if(n == 2) {
			System.out.println(3);
			return;
		}
		
		dp[1] = 1;
		dp[2] = 3;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + 2 * dp[i-2];
			dp[i] %= 10007;
		}
		
		System.out.println(dp[n]);
	}
}
