package d3;

import java.util.*;
import java.io.*;

public class swea14413 {

	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {1, -1, 0, 0};
	public static String[][] map;
	public static int N, M;
	
	public static boolean isPossible(int x, int y) {

		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			
			if(map[x][y].equals(".") && map[nx][ny].equals("?")) {
				map[nx][ny] = "#";
			} else if(map[x][y].equals("#" ) && map[nx][ny].equals("?")) {
				map[nx][ny] = ".";
			}
			
			if(map[x][y].equals(map[nx][ny])) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String answer = "possible";
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new String[N][M];
			
			// Initialize map array
			for(int i = 0; i < N; i++) {
				map[i] = br.readLine().split("");
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(!map[i][j].equals("?") && !isPossible(i, j)) answer = "impossible";
				}
			}
			
			System.out.printf("#%d %s\n", test_case, answer);
		} // end test case loop
	}
}
