package gold;

import java.util.*;
import java.io.*;

public class boj14503_�κ�û�ұ� {

	static int N, M;
	static int map[][];
	static boolean visited[][];
	
	static int dx[] = {-1, 0, 1,  0};
	static int dy[] = { 0, 1, 0, -1}; // �ϵ�����
	static int cleanCount = 0;
	
	public static void clean(int x, int y, int dir) {

		if(map[x][y] == 0 && !visited[x][y]) {
			visited[x][y] = true;
			cleanCount++;
		}
		
		boolean check = false;
		int originDir = dir;
		for(int i = 0; i < 4; i++) {
			int nextDir = (dir+3) % 4;
			int nx = x + dx[nextDir];
			int ny = y + dy[nextDir];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			
			if(map[nx][ny] == 0 && !visited[nx][ny]) {
				clean(nx, ny, nextDir);
				visited[nx][ny] = true;
				check = true;
			}
			
			dir = nextDir;
		}
		
		if(!check) {
			// �� ���� ��� û�� �Ǿ��ų� ��
			int nextDir = (originDir + 2) % 4; // ������ ����
			int nx = x + dx[nextDir];
			int ny = y + dy[nextDir];
			
			if(nx > 0 && nx < N && ny > 0 && ny < M) { 
				if(map[nx][ny] == 0 && visited[nx][ny]) { // û�Ҹ� �߰�, ���� �ƴ� ��� 
					clean(nx, ny, originDir); // ���� ������ ������ä ����
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// �� ũ��
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// �κ� ������ġ �� ����
		st = new StringTokenizer(br.readLine());
		int robot_x = Integer.parseInt(st.nextToken());
		int robot_y = Integer.parseInt(st.nextToken());
		int robot_dir = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		visited = new boolean [N][M];
		
		for(int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean(robot_x, robot_y, robot_dir);
		
		System.out.println(cleanCount);
		
		
	}
}
