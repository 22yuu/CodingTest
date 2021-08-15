package silver;

import java.util.*;
import java.io.*;

public class boj1018_체스판다시칠하기 {
	
	static char[][] board;
	static char[][] window = new char[8][8];
	static String[] answers = { "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW" };
	static int M, N;

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		List<Integer> list = new ArrayList<>();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		board = new char[M][N];
		
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			for(int j = 0; j <N; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i <= M - 8; i++) {
			for(int j =0; j <= N - 8; j++) {
				list.add(check(i, j));
			}
		}

		Collections.sort(list);
		System.out.println(list.get(0));
	}

	
	
	public static int check(int x, int y) {
		
		int ans =64; // 흰색으로 시작할 때
		int cnt = 0;
		for(int i = x; i < x+8;i++) {
			for(int j =y; j < y+8; j++) {
				if(board[i][j] != answers[i-x].charAt(j-y)) cnt++;
			}
		}
		
		return Math.min(cnt, 64-cnt);
	}
}
