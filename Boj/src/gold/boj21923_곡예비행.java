package gold;

import java.util.*;
import java.io.*;

public class boj21923_곡예비행 {
	
	public static int N, M;
	public static int map[][];
	public static int dx[] = {-1, 1, 0};
	public static int dy[] = { 0, 0, 1}; // 상, 하, 우
	public static boolean visited[][];
	
	public static int answer = 0;
	public static int max = Integer.MIN_VALUE;
	
	public static void dfs(int x, int y, int sum) {
		
		if(x == N-1 && y == M - 1) {
			max = Math.max(max, sum + map[x][y]);
			System.out.println(max);
			return;
		}
		
		for(int d = 0; d < 3; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			
			if(visited[nx][ny]) continue;
			
			visited[nx][ny] = true;
			dfs(nx, ny, sum + map[nx][ny]);
			visited[nx][ny] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[N-1][0] = true;
		dfs(N-1, 0, map[N-1][0]);
		//System.out.println(max);
		
	}
}
