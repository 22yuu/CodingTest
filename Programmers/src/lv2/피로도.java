package lv2;

import java.util.*;

public class ÇÇ·Îµµ {
	
	static int answer;
    static boolean[] visited;
    
    public static void dfs(int k, int[][] dungeons, int idx, int cnt) {
        if(idx == dungeons.length) {
            answer = answer > cnt ? answer: cnt;
            return;
        }
        
        for(int i =0; i < dungeons.length; i++) {
            if(dungeons[i][0] > k || visited[i]) continue;
            visited[i] = true;
            dfs(k-dungeons[i][1], dungeons, idx+1, cnt+1);
            visited[i] = false;
        }
        dfs(k, dungeons, idx+1, cnt);
    }
    
    public static int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0, 0);
        
        return answer;
    }

    public static void main(String[] args) {
    	int[][] dungeons = new int[][] {{80,20}, {50,40}, {30,10}};
    	
    	System.out.println(solution(80, dungeons));
    }
}
