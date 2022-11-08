package silver;

import java.io.*;

public class boj11052_카드구매하기 {
	
	private static int N;
	private static int dp[] = new int [1001];
	private static int prices[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		String[] inputs = br.readLine().split(" ");
		
		prices = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			prices[i] = Integer.parseInt(inputs[i - 1]);
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j =1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + prices[j]);
			}
		}
		
		System.out.println(dp[N]);
	}
}
