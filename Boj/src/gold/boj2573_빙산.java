package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 62%���� �ð� �ʰ�
public class boj2573_���� {
	
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
		
		// map�� ���� �ʰ��� return
		if(x < 0 || y < 0 || x >= N || y >= M) return false;
		
		if(visited[x][y]) {
			return false;
		} else {
			visited[x][y] = true;
		}
		
		// map�� ���� 0�� �ƴ� ���
		if(map[x][y] != 0) {
			
			visited[x][y] = true;
			
			int cnt = 0;
			// �ֺ� 4���� Ž�� ��
			for(int i = 0; i < dx.length; i++) {
				if(map[x + dx[i]][y + dy[i]] == 0) { // 0�� ������ ī��Ʈ
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
		
		int result = 0; // ���� ������ �� ����
		int cnt = 0; // ���� �� ��� �̻� �и� �ɶ����� �ɸ� �ּ� �ð�(��)
		
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
					
					if(map[i][j] < 0) map[i][j] = 0; // map�� ���� 0���� �۾��� ��� �ٽ� 0���� ����
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

���� 4

5 5
0 0 0 0 0
0 0 10 10 0
0 10 0 10 0
0 0 10 10 0
0 0 0 0 0

���� 0

5 5
0 0 0 0 0
0 10 10 10 0
0 10 0 10 0
0 10 10 10 0
0 0 0 0 0

ó���� dfs�� �� Ǯ���µ�... �ð��ʰ� ������ ������ ��� ���� 
"ù �ٿ� ������ �и��Ǵ� ������ �ð�(��)�� ����Ѵ�. ���� ������ �� ���� ������ �и����� ������ 0�� ����Ѵ�."����
���� ������ �� ���� ������ �и����� ������ 0�� ����Ѵ�. -> �ش� ���ǿ� ���� ó���� ���� �ʾƼ� 59~62���뿡�� �ð��ʰ� ���� �߻�...
 * */
