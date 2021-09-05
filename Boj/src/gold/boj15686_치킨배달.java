package gold;

import java.util.*;
import java.io.*;


/*
 * 0은 빈칸, 1은 집, 2는 치킨집
 * 
 */
public class boj15686_치킨배달 {
	
	public static int N, M;
	public static int map[][];
	public static int dx[] = {-1, 1, 0,  0};
	public static int dy[] = { 0, 0, 1, -1};
	public static boolean visited[][];
	public static int[][] dist;
	
	public static void dfs(int x, int y) {
		
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int nHomes = 0;
		int nChickens = 0;
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				
				if(num == 1) {
					nHomes++;
				} else if( num == 2) {
					nChickens++;
				}
			}
		}
		
		dist = new int[nHomes][nChickens];
		
		
		
		
	}
	
	public static int getDistance() {
		return 0;
	}
}
