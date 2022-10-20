package silver;

import java.util.*;
import java.io.*;

public class boj2468_안전영역 {

	private static int N;
	private static int MaxHeight = Integer.MIN_VALUE;
	private static int MinHeight = Integer.MAX_VALUE;
	private static int MaxIsland = Integer.MIN_VALUE;
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static int[][] map;
	private static boolean[][] visited;
	
	public static void dfs(int w, int h, int height) {
		
	
		visited[w][h] = true;
		
		for(int d = 0; d < 4; d++) {
			int nx = w + dx[d];
			int ny = h + dy[d];
			
			if(ny < 0 || nx < 0 || nx >= N || ny >= N) continue;
			
			if(visited[nx][ny] || map[nx][ny] <= height) continue;
			
			visited[nx][ny] = true;
			
			if(map[nx][ny] > height) dfs(nx, ny, height);
			
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				MaxHeight = Math.max(MaxHeight, map[i][j]);
				MinHeight = Math.min(MinHeight, map[i][j]);
			}
			
		}
		
		int height = MinHeight;
		
		
		while(height <= MaxHeight) {
			int cnt = 0;
			visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <N; j++) {
					if(!visited[i][j] && map[i][j] > height) {
						dfs(i,j, height);
						cnt++;
					}
				}
			}
			
			height++;
			
			MaxIsland = Math.max(MaxIsland, cnt);
			
//			System.out.println(MaxIsland);
		}
		// 아무 지역도 침수안될 경우
		int answer = MaxIsland > 0 ? MaxIsland : N * N;
		
		System.out.println(answer);

	}

}
