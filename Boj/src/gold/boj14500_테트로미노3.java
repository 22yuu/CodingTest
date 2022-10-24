package gold;

import java.util.*;
import java.io.*;

public class boj14500_테트로미노3 {
	
	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;
	private static int MAX = Integer.MIN_VALUE;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0, 0, -1, 1};

	public static void dfs(int x, int y, int sum, int count) {
		if(count == 4) {
			MAX = Math.max(MAX, sum);
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			
			if(!visited[nx][ny]) {
				if(count == 2) {
					visited[nx][ny] = true;
					dfs(nx, ny, sum + map[nx][ny], count + 1);
					visited[nx][ny] = false;
				}
				
				visited[nx][ny] = true;
				dfs(nx, ny, sum+map[nx][ny], count+1);
				visited[nx][ny] = false;
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputSizes = br.readLine().split(" ");
		
		N = Integer.parseInt(inputSizes[0]);
		M = Integer.parseInt(inputSizes[1]);
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, map[i][j], 1);
			}
		}
		
		System.out.println(MAX);

	}
	
	public static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
