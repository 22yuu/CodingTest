package silver;

import java.util.*;
import java.io.*;

public class boj4963_섬의개수 {
	static int N, M;
	static int map[][];
	static boolean visited[][];
	
	static int dx[] = {1, -1, 0,  0, 1, -1,  1, -1};
	static int dy[] = {0,  0, 1, -1, 1, -1, -1,  1}; // 8방향
	
	
	public static void dfs(int x, int y) {
		
		visited[x][y] = true;
		
		 for(int d = 0; d < 8; d++) {
			 int nx = x + dx[d];
			 int ny = y + dy[d];
			 
			 if(nx <0 || ny < 0 || nx >= N || ny >= M) continue;
			 
			 if(visited[nx][ny]) continue;
			 
			 visited[nx][ny] = true;
			 if(map[nx][ny] == 1) dfs(nx, ny);
		 }
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
	
		
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			if(N == 0 && M == 0) break;
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j <M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <M; j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			bw.write(cnt + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
