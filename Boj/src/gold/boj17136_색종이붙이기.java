package gold;

import java.util.*;
import java.io.*;

public class boj17136_�����̺��̱� {

	private final static int SIZE = 10;
	public static int map[][];
	public static int paper[] = {0, 5, 5, 5, 5, 5};
	public static int answer = Integer.MAX_VALUE;

	
	// ��Ʈ��ŷ
	public static void dfs(int x, int y, int cnt) {
		
		if(x >= SIZE-1 && y > SIZE-1) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		if(answer <= cnt) {
			return;
		}
		
		if(y > SIZE-1) {
			dfs(x+1, 0, cnt);// ������ 
			return;
		}
		
		if(map[x][y] == 1) {
			for(int i = 5; i >= 1; i--) { // ū ������ ���� ���̸鼭 Ž��
				if(paper[i] > 0 && isAvailable(x, y, i)) {
					action(x, y, i, 0);
					paper[i]--; // ������ �ִ� 5������ ���̱� ����
					dfs(x, y+1, cnt+1);
					action(x, y, i, 1);
					paper[i]++;
				}
			}
		} else {
			dfs(x, y + 1, cnt);
		}
	}
	
	// �����̸� ���̰ų� ����. state ���� 0 : ����, 1 : ����.
	public static void action(int x, int y, int size, int state) {
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				map[i][j] = state;
			}
		}
	}
	
	
	public static boolean isAvailable(int x, int y, int size) {
		
		for(int i = x; i < x+size; i++) {
			for(int j = y; j < y+size; j++) {
				if(i < 0 || i >= SIZE || j < 0 || j >= SIZE) {
					return false;
				}
				
				if(map[i][j] == 0) return false;
				
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[SIZE][SIZE];
		
		for(int i = 0; i < SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < SIZE; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0,0);
		
		if(answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		
		System.out.println(answer);
		
	}
}
 