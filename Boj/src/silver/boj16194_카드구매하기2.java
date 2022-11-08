package silver;

import java.util.*;
import java.io.*;

public class boj16194_카드구매하기2 {
	
	private static int N;
	private static int dp[] = new int [1001];
	private static int prices[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		String[] inputs = br.readLine().split(" ");
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		
		prices = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			prices[i] = Integer.parseInt(inputs[i - 1]);
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j =1; j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j] + prices[j]);
			}
		}
		
		System.out.println(dp[N]);
		
		
	}
}
