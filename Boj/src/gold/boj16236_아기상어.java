package gold;

import java.util.*;
import java.io.*;

public class boj16236_�Ʊ��� {

	// �Ʊ� ��� �ʱ� �� 2
	// �Ʊ� �� ���� �������� ũ�Ⱑ ������ ũ�Ⱑ 1 ����
	static int N;
	static int sea[][];
	static int arr[][]; // ���� �� �ִ� ����� �ִ� ��ġ�� �Ÿ��� ������ �迭
	static int dx[] = {1, -1, 0,  0};
	static int dy[] = {0,  0, 1, -1};
	static int eat_cnt = 0; // �Ʊ� �� ���� ����� ��
	static int size =  2; // �Ʊ� ��� ũ��
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
			
			
			// 4���� Ž��!
			for(int d = 0; d < 4; d++) {
				int nx = np.x + dx[d];
				int ny = np.y + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				
				if(visited[nx][ny] || sea[nx][ny] > size) continue; // �湮�߰ų�, �ڽź��� ū ������ �н�
				
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					arr[nx][ny] = arr[np.x][np.y] + 1; // �Ʊ� �� �̵��� �Ÿ��� ī��Ʈ
				}
				
				if(sea[nx][ny] != 0 && sea[nx][ny] < size) { // �Ʊ� ���� ���� ����� �߰�
					// �Ʊ� ��� ��ġ �缳�� �� �ּ� �Ÿ� �� ����
					if(min_dist > arr[nx][ny]) { // �̵� �Ÿ��� ���� �ּ� �̵� �Ÿ����� ������ �Դ´�.
						min_x = nx;
						min_y = ny; // �ش� ��ġ�� ����⸦ �԰� �Ʊ� ����� ��ġ�� �����ϱ� ���� ��ǥ ����
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
			// �ʱ�ȭ
			visited = new boolean[N][N];
			arr = new int[N][N];
			
			min_dist = MAX_DIST;
			min_x = MAX_N;
			min_y = MAX_N;
			
			bfs(startX, startY);
			
			if(min_x != MAX_N && min_y != MAX_N) { // �ʱ� �����ߴ� �ּ� ����� �ٸ��� -> ���հ� �߰�
				result += arr[min_x][min_y];
				
				eat_cnt++;
				
				if(eat_cnt == size) {
					size++;
					eat_cnt = 0;
				}
				
				sea[min_x][min_y] = 0; // �Դ´�.
				
				startX = min_x;
				startY = min_y;
			}else {
				break;
			}
		}
		System.out.println(result);
	}
}
