package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 62%에서 시간 초과
public class boj2573_빙산 {
	
	static int dx[] = { 1, -1, 0,  0 };
	static int dy[] = { 0,  0, 1, -1 };
	static int N, M;
	static int sum;
	static int[][] map;
	static int[][] melting;
	static boolean[][] visited;
	
	public static void print(int map[][]) {
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public static boolean dfs(int x, int y) {
		
		// map의 범위 초과시 return
		if(x < 0 || y < 0 || x >= N || y >= M) return false;
		
		if(visited[x][y]) {
			return false;
		} else {
			visited[x][y] = true;
		}
		
		// map의 값이 0이 아닐 경우
		if(map[x][y] != 0) {
			
			visited[x][y] = true;
			
			int cnt = 0;
			// 주변 4방향 탐색 후
			for(int i = 0; i < dx.length; i++) {
				if(map[x + dx[i]][y + dy[i]] == 0) { // 0이 있으면 카운트
					cnt++;
				}
				dfs(x+dx[i], y+dy[i]);
			}
			melting[x][y] = cnt;
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];

		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bf.close();
		
		//print();
		
		int result = 0; // 섬의 갯수를 셀 변수
		int cnt = 0; // 섬이 두 덩어리 이상 분리 될때까지 걸린 최소 시간(년)
		
		while(true) {
			
			melting = new int[N][M];
			visited = new boolean[N][M];
			result = 0;
			

			print(map);
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(dfs(i,j)) {
//						System.out.println("i : " + i + ", j : " + j );
//						System.out.println(map[i][j]);
						result += 1;
					}
				}
				
				//System.out.println(result);
				if(cnt == 0 && result >=2) {
					System.out.println("cnt1 : " + cnt);
					print(map);
					return;
				} else if (result >= 2) {
					System.out.println("cnt2 : " + cnt);
					print(map);
					return;
				}
			}
			
			sum = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					map[i][j] -= melting[i][j];
					
					if(map[i][j] < 0) map[i][j] = 0; // map의 값이 0보다 작아질 경우 다시 0으로 설정
					sum += map[i][j];
				}
			}
			
			if( sum == 0 && result == 0) {
				System.out.println("0");
				return;
			}

			cnt++;
		}
	}
}


/*
5 5
0 0 0 0 0
0 6 9 6 0
0 3 3 9 0
0 6 1 6 0
0 0 0 0 0

정답 4

5 5
0 0 0 0 0
0 0 10 10 0
0 10 0 10 0
0 0 10 10 0
0 0 0 0 0

정답 0

5 5
0 0 0 0 0
0 10 10 10 0
0 10 0 10 0
0 10 10 10 0
0 0 0 0 0

처음에 dfs로 잘 풀었는데... 시간초과 에러뜸 이유는 출력 조건 
"첫 줄에 빙산이 분리되는 최초의 시간(년)을 출력한다. 만일 빙산이 다 녹을 때까지 분리되지 않으면 0을 출력한다."에서
만일 빙산이 다 녹을 때까지 분리되지 않으면 0을 출력한다. -> 해당 조건에 대한 처리를 하지 않아서 59~62퍼쯤에서 시간초과 오류 발생...
 * */
