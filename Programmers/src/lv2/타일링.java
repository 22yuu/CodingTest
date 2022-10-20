package lv2;

public class ≈∏¿œ∏µ {
	
	public static long solution(int n) {
        long answer = 0;
        
        if(n == 2) return 3;
        if(n == 4) return 11;
        
        long[] dp = new long[n/2];
        
        dp[0] = 3;
        dp[1] = 11;
        
        for(int i = 2; i < n/2; i++) {
            dp[i] = (int)((dp[i - 1] * 4 % 1000000007 ) - dp[i-2] % 1000000007 + 1000000007) % 1000000007;
//            System.out.println(dp[i]);
        }
        return dp[n/2 - 1];
    }
	
	public static void main(String[] args) {
		for(int i = 2; i <= 20; i +=2) {
			System.out.println(i + " : " + solution(i));
		}
	}

}
