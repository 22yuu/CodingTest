package gold;

import java.util.*;
import java.io.*;

public class boj21922_�кο������λ� {

	public static int N, M;
	public static int map[][];
	public static boolean visited[][];
	
	public static int airCondCnt = 0; // ������ ��;
	public static List<int[]> airConList;
	
	public static int dx[] = {-1, 1,  0, 0};
	public static int dy[] = { 0, 0, -1, 1}; // �����¿�
	
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
			
			if(visited[nx][ny]) answer--; // ��ĥ ���
			
			visited[nx][ny] = true;
			if(map[nx][ny] > 0) {
				item(nx,ny,map[nx][ny],d);
				break;
			}
			answer++;
		}
	}
	
	public static void item(int x, int y, int state, int d) {
		
		answer++; // ������ �ִ� �ڸ��� ���� �� �ֱ� ������ 1����
		if(state == 1) { // �¿쿡�� ������ �ٶ��� ������, �� �Ʒ����� ������ �ٶ��� ���
//			System.out.println(x + " " + y);
			if(d == 0 || d == 1) { // �ٶ��� ��, �쿡�� ���� ��
				sitCount(x,y,d);
			}
		} else if(state == 2) {// �¿쿡�� ������ ������ ��� / ��, �Ʒ����� ������ �ٶ��� ����
//			System.out.println(x + " " + y);
			if(d == 2 || d == 3) {
				sitCount(x,y,d);
			}
		} else if(state == 3) { // ������ ������ ������ �·� / �¿��� ���� ������ ���� , �쿡�� ���� �ٶ��� �Ʒ��� / �Ʒ����� ���� �ٶ��� ���
//			System.out.println(x + " " + y);
			if(d == 1) { // ������ ���� ��
				// �·κ����ش�.
				sitCount(x, y, 2);
			} else if(d == 3) { // ���ʿ��� �ٶ��� ���� �� (������ �������̱� ������ ���� ��ġ������ ���ʿ��� �ٶ��� ���´�) 
				// ���� �����ش�.
				sitCount(x, y, 0);
			} else if(d == 2) { // �����ʿ��� �ٶ��� ���� �� (������ �����̱� ������ ���� ��ġ������ �����ʿ��� �ٶ��� ���´�)
				// �Ʒ��� �����ش�.
				sitCount(x, y, 1);
			} else if(d == 0) { // �Ʒ����� �ٶ��� ���� �� (������ �����̱� ������ ���� ��ġ������ �Ʒ����� �ٶ��� ���´�.)
				// ��� �����ش�.
				sitCount(x, y, 3);
			}
		} else if(state == 4) {
			//System.out.println(x + " " + y);
			if(d == 1) { // ������ ���� ��
				// ��κ����ش�.
				sitCount(x, y, 3);
			} else if(d == 3) { // ���ʿ��� �ٶ��� ���� �� (������ �������̱� ������ ���� ��ġ������ ���ʿ��� �ٶ��� ���´�) 
				// �Ʒ��� �����ش�.
				sitCount(x, y, 1);
			} else if(d == 2) { // �����ʿ��� �ٶ��� ���� �� (������ �����̱� ������ ���� ��ġ������ �����ʿ��� �ٶ��� ���´�)
				// ���� �����ش�.
				sitCount(x, y, 0);
			} else if(d == 0) { // �Ʒ����� �ٶ��� ���� �� (������ �����̱� ������ ���� ��ġ������ �Ʒ����� �ٶ��� ���´�.)
				// �·� �����ش�.
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