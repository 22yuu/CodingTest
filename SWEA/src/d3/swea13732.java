package d3;

import java.util.*;
import java.io.*;

public class swea13732 {
	
	private static String answer = "";
	private static int N;
	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {-1, 1, 0, 0};
	private static int[][] map;
	private static boolean[][] visited;
	private static int MAX;
	
	public static void dfs(int x, int y, int value) {
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 0) continue;
			
			if(visited[nx][ny]) continue;
			
			visited[nx][ny] = true;
			dfs(nx, ny, value+1);
			visited[nx][ny] = false;
		}
//		System.out.println(value);
		
		MAX = Math.max(MAX, value);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			answer = "yes";
			map = new int[N][N];
			visited = new boolean[N][N];
			MAX = Integer.MIN_VALUE;
			
			// init map
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {
					char ch = str.charAt(j);
					if(ch == '.') map[i][j] = 0;
					else map[i][j] = 1;
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 1) {
						dfs(i,j, 0);
						break;
					}
				}
			}
			
			System.out.println(MAX);
			int sq = (int)Math.sqrt(MAX);
			
			if(MAX == 0 || MAX != sq*sq) answer = "no";
//			print(map);
			
			System.out.printf("#%d %s\n", test_case, answer);
		}
	}
	
	
	public static void print(int[][] map) {
		int length = map.length;
		
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
