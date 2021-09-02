package silver;

import java.util.*;
import java.io.*;

/*
	익은 토마토와 인접해 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
	인접한 토마토는 4방향이며, 대각선 방향에 있는 토마토들에게는 영향을 주지 못함, 혼자 저절로 익는 경우는 없다.
	창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 구하여라
	
	
 */
public class boj7576_토마토 {

	static int N, M;
	static int map[][];
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0,  0, 1,-1};
	static int total_tomato = 0; // 총 토마토의 갯수
	static int tomato = 0; // 익은 토마토의 갯수
	static boolean visited[][];
	
	public static void dfs(int x, int y) {
		
		if(visited[x][y]) return;
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
		

			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			if(visited[nx][ny] || map[nx][ny] == -1 || map[nx][ny] == 1) continue;
			
			visited[nx][ny] = true;
			
			if(map[nx][ny] == 0) {
				map[nx][ny] = 1;
				tomato++;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int day = 0;
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i< N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >=0) {
					total_tomato++;
				}
			}
		}
		
		//System.out.println("토마토 총 갯수 : " + total_tomato);
		while(true) {

			visited = new boolean[N][M];
			int currentTomato = 0;
			int prevtTomato = tomato;
			
			for(int i = 0; i< N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1) {
						dfs(i,j);
						currentTomato++;
					}
				}
			}
			System.out.println(tomato);

			for(int i = 0; i< N; i++) {
				for(int j = 0; j < M; j++) {
					System.out.print(map[i][j]);
				}
			System.out.println();
			}

			
			if(currentTomato == total_tomato) break;
			day++;
			
			if(prevtTomato == tomato) {
				day = -1;
				break;
			}
		}
		System.out.println(day);
		

		
	}
}
