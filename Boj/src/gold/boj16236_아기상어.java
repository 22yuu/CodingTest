package gold;

import java.util.*;
import java.io.*;

public class boj16236_아기상어 {

	// 아기 상어 초기 값 2
	// 아기 상어가 먹은 마리수와 크기가 같으면 크기가 1 증가
	static int N;
	static int sea[][];
	static int arr[][]; // 먹을 수 있는 물고기 있는 위치의 거리를 저장할 배열
	static int dx[] = {1, -1, 0,  0};
	static int dy[] = {0,  0, 1, -1};
	static int eat_cnt = 0; // 아기 상어가 먹은 물고기 수
	static int size =  2; // 아기 상어 크기
	static boolean visited[][];
	static int MAX_DIST = 400; // 2 <= N <= 20
	static int MAX_N = 20;
	static int min_x, min_y, min_dist, result = 0;
	
	public static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs(int x, int y) {
		
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(x, y));
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			Point np = que.poll();
			
			
			// 4방향 탐색!
			for(int d = 0; d < 4; d++) {
				int nx = np.x + dx[d];
				int ny = np.y + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				
				if(visited[nx][ny] || sea[nx][ny] > size) continue; // 방문했거나, 자신보다 큰 물고기는 패스
				
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					arr[nx][ny] = arr[np.x][np.y] + 1; // 아기 상어가 이동한 거리를 카운트
				}
				
				if(sea[nx][ny] != 0 && sea[nx][ny] < size) { // 아기 상어보다 작은 물고기 발견
					// 아기 상어 위치 재설정 및 최소 거리 값 설정
					if(min_dist > arr[nx][ny]) { // 이동 거리가 현재 최소 이동 거리보다 작으면 먹는다.
						min_x = nx;
						min_y = ny; // 해당 위치의 물고기를 먹고 아기 상어의 위치를 저장하기 위한 좌표 설정
						min_dist = arr[nx][ny]; 
						min_dist = arr[nx][ny]; 
					}
					else if (min_dist == arr[nx][ny]) {
						if(min_x == nx) {
							if(min_y > ny) {
								min_x = nx;
								min_y = ny;
							}
						}else if (min_x > nx) {
							min_x = nx;
							min_y = ny;
						}
					}
				}
				que.offer(new Point(nx,ny));
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int startX = 0;
		int startY = 0;
		
		N = Integer.parseInt(br.readLine());
		
		sea = new int[N][N];
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				sea[i][j] = input;
				
				if(input == 9) {
					startX = i;
					startY = j;
					sea[i][j]=0;
				}
			}
		}
		
		while(true) {
			// 초기화
			visited = new boolean[N][N];
			arr = new int[N][N];
			
			min_dist = MAX_DIST;
			min_x = MAX_N;
			min_y = MAX_N;
			
			bfs(startX, startY);
			
			if(min_x != MAX_N && min_y != MAX_N) { // 초기 설정했던 최소 값들과 다르다 -> 먹잇감 발견
				result += arr[min_x][min_y];
				
				eat_cnt++;
				
				if(eat_cnt == size) {
					size++;
					eat_cnt = 0;
				}
				
				sea[min_x][min_y] = 0; // 먹는다.
				
				startX = min_x;
				startY = min_y;
			}else {
				break;
			}
		}
		System.out.println(result);
	}
}
