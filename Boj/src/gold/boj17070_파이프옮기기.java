package gold;

import java.util.*;
import java.io.*;

public class boj17070_파이프옮기기 {
	
	static int n;
	static int[][] map;
	static int[][] dp;
	static int dx[] = {0,1,1};
	static int dy[] = {1,0,1}; // 오, 아래, 대각
	static int answer = 0;
	
	public static void dfs(int x, int y, int stats) {
		
		if(x == n && y == n) {
			answer++;
		}
		
		for(int d = 0 ; d < 3; d++) { // stats 파이프 상태 - 0 : 가로, 1: 세로, 2 : 대각
			
			if(stats == 0 && d == 1) { // 파이프가 가로에서는 아래로 갈 수 없다.
				continue;
			} 
			if (stats == 1 && d == 0) { // 파이프가 세로에서는 오른쪽으로 갈 수 없다. 
				continue;
			} 
			
			// 대각선으로 이동 시 전부 빈칸이어야 한다.
			if( d == 2) {
				if(y + 1 <= n && x + 1 <= n) {
					if(map[x][y+1] != 0 ||  map[x+1][y] != 0) {
						continue;
					}
				}
			}
			
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx > 0 && nx <= n && ny > 0 && ny <= n) {
				if(map[nx][ny] != 1) {
					dfs(nx, ny, d); 
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		
		for(int i =1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(1,2,0);
		System.out.println(answer);
		
		br.close();
	} 
}
