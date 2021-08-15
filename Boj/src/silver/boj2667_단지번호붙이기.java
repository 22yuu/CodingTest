package silver;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2667_단지번호붙이기 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int dx[] = {1, -1, 0, 0 };
	static int dy[] = {0,  0, 1,-1 };
	
	
	public static int dfs(int x, int y, int cnt) {
		
		visited[x][y] = true;
		
		// 주변 4방향 탐색
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N ) {
				continue;
			}

			if(visited[nx][ny]) continue;
			
			if(map[nx][ny] == 1) {
				cnt++;
				visited[nx][ny] = true;
				cnt = dfs(nx, ny, cnt);
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i< N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		
		int count = 0; // 단지 수를 카운트하는 변수
		for(int i = 0; i< N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					int answer = dfs(i,j,1); // 자기자신을 세고 1
					list.add(answer);
				}
			}
		}
		
		// 오름차순으로 정렬
		Collections.sort(list);
		
		// 내림차순 정렬
		//Collections.sort(list, Collections.reverseOrder());
		// 배열도 마찬가지
		// Arrays.sort(배열, Collections.reverseOrder());
		
		// 단지수 출력
		System.out.println(list.size());
		
		// 단지별 집의 개수
		for(int i : list) System.out.println(i);
	}
}
