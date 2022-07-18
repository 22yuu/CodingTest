package silver;

import java.util.*;
import java.io.*;

public class boj2468_안전영역 {

	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0,0,-1,1};
	private static int[][] map;
	private static int[][] visited;
	private static int maxHeight;
	
	public static void dfs(int idx) {
		
		if(idx > maxHeight) return;
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		 map = new int[n][n];
		 visited = new int[n][n];
		 maxHeight = Integer.MIN_VALUE;
		 
		// map 만들기
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				
			}
		}
		
		

	}

}
