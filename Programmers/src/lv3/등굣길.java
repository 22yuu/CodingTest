package lv3;

//https://programmers.co.kr/learn/courses/30/lessons/42898
	
public class µî±·±æ {
	static final int MOD = 1000000007;
    
	public static int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m + 1][n + 1];
        
        for (int[] t : puddles) {
            dp[t[0]][t[1]] = -1;
        }

        dp[0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    System.out.print(dp[i][j] + " ");
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
                    System.out.print(dp[i][j] + " ");
                }
            }
            System.out.println();
        }
        return dp[m][n];
    }
    
    
    public static void main(String[] args) {
		
    	int puddles[][] = {{2,2}};
    	
    	System.out.println(solution(4,3,puddles));
	}
}
