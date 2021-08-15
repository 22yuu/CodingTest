package gold;

import java.util.*;
import java.io.*;

public class boj21922_학부연구생민상 {

	public static int N, M;
	public static int map[][];
	public static boolean visited[][];
	
	public static int airCondCnt = 0; // 에어컨 수;
	public static List<int[]> airConList;
	
	public static int dx[] = {-1, 1,  0, 0};
	public static int dy[] = { 0, 0, -1, 1}; // 상하좌우
	
	public static int crossCount = 0;
	public static int answer = 0;
	public static int r, c;
	
	
	public static void dfs(int x, int y) {
		
		if(x < 0 || x >= N || y < 0 || y >= M) return;
		
		for(int d = 0; d < 4; d++) {
			sitCount(x, y, d);
		}
	}
	
	public static void sitCount(int x, int y, int d) {
		int nx = x;
		int ny = y;
		
		while(true) {
			nx = nx + dx[d];
			ny = ny + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
			
			if(visited[nx][ny]) answer--; // 겹칠 경우
			
			visited[nx][ny] = true;
			if(map[nx][ny] > 0) {
				item(nx,ny,map[nx][ny],d);
				break;
			}
			answer++;
		}
	}
	
	public static void item(int x, int y, int state, int d) {
		
		answer++; // 물건이 있는 자리도 앉을 수 있기 때문에 1증가
		if(state == 1) { // 좌우에서 들어오는 바람은 막히고, 위 아래에서 들어오는 바람은 통과
//			System.out.println(x + " " + y);
			if(d == 0 || d == 1) { // 바람이 좌, 우에서 들어올 때
				sitCount(x,y,d);
			}
		} else if(state == 2) {// 좌우에서 들어오는 방향은 통과 / 위, 아래에서 들어오는 바람은 막힘
//			System.out.println(x + " " + y);
			if(d == 2 || d == 3) {
				sitCount(x,y,d);
			}
		} else if(state == 3) { // 위에서 들어오는 방향은 좌로 / 좌에서 들어온 방향은 위로 , 우에서 들어온 바람은 아래로 / 아래에서 들어온 바람은 우로
//			System.out.println(x + " " + y);
			if(d == 1) { // 위에서 들어올 때
				// 좌로보내준다.
				sitCount(x, y, 2);
			} else if(d == 3) { // 왼쪽에서 바람이 들어올 때 (방향이 오른쪽이기 때문에 현재 위치에서는 왼쪽에서 바람이 들어온다) 
				// 위로 보내준다.
				sitCount(x, y, 0);
			} else if(d == 2) { // 오른쪽에서 바람이 들어올 때 (방향이 왼쪽이기 때문에 현재 위치에서는 오른쪽에서 바람이 들어온다)
				// 아래로 보내준다.
				sitCount(x, y, 1);
			} else if(d == 0) { // 아래에서 바람이 들어올 때 (방향이 위쪽이기 때문에 현재 위치에서는 아래에서 바람이 들어온다.)
				// 우로 보내준다.
				sitCount(x, y, 3);
			}
		} else if(state == 4) {
			//System.out.println(x + " " + y);
			if(d == 1) { // 위에서 들어올 때
				// 우로보내준다.
				sitCount(x, y, 3);
			} else if(d == 3) { // 왼쪽에서 바람이 들어올 때 (방향이 오른쪽이기 때문에 현재 위치에서는 왼쪽에서 바람이 들어온다) 
				// 아래로 보내준다.
				sitCount(x, y, 1);
			} else if(d == 2) { // 오른쪽에서 바람이 들어올 때 (방향이 왼쪽이기 때문에 현재 위치에서는 오른쪽에서 바람이 들어온다)
				// 위로 보내준다.
				sitCount(x, y, 0);
			} else if(d == 0) { // 아래에서 바람이 들어올 때 (방향이 위쪽이기 때문에 현재 위치에서는 아래에서 바람이 들어온다.)
				// 좌로 보내준다.
				sitCount(x, y, 2);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		airConList = new ArrayList<>();
		
		r = -1;
		c = -1;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 9) {
					r = i;
					c = j;
					airConList.add(new int[] {r,c});
					airCondCnt++;
				}
			}
		}
		
		if(r == -1) {
			answer = 0;
			System.out.println(answer);
			return;
		}
		
		answer = airCondCnt;
		
		for(int i = 0; i < airCondCnt; i++) {
			int[] temp = airConList.get(i);
			
			r = temp[0];
			c = temp[1];
			
			dfs(r,c);	
		}
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		System.out.println(answer);
		
		
	}
}