package gold;

import java.io.*;
import java.util.*;

/*
 * 17%에서 틀림...
 * 
 * */

public class boj14500_테트로미노2 {

	private static int[][] map;
	private static int[][] wWind = new int[3][2];
	private static int[][] hWind = new int[2][3];
	private static int N, M; // 세로, 가로
	private static int answer = Integer.MIN_VALUE;
	
	public static void widthWindow(int r, int c) {
		int nr = r + 3;
		int nc = c + 2;
		
		if(nr > N-1 || nc > M-1) return;
		
		int h = -1;
		int w = 0;
		int sum = 0;
		
		for(int i = r; i < nr; i++) {
			h++;
			w = 0;
			for(int j = c; j < nc; j++) {
				wWind[h][w++] = map[i][j];
				sum += map[i][j];
			}
			
		}
		
		// 0,1 ㄴ / 1,1 ㄱ
		answer = Math.max(answer, sum - wWind[0][1] - wWind[1][1]); // ㄴ
		answer = Math.max(answer, sum - wWind[1][0] - wWind[2][0]); // ㄱ
		answer = Math.max(answer, sum - wWind[0][0] - wWind[1][0]);
		answer = Math.max(answer, sum - wWind[1][1] - wWind[2][1]);
		answer = Math.max(answer, sum - wWind[0][1] - wWind[2][0]);  
		answer = Math.max(answer, sum - wWind[0][0] - wWind[2][1]);
		answer = Math.max(answer, sum - wWind[0][1] - wWind[2][1]); // ㅏ
		answer = Math.max(answer, sum - wWind[0][0] - wWind[2][0]); // ㅓ
	}
	
	public static void heightWindow(int r, int c) {
		int nr = r + 2;
		int nc = c + 3;
		
		if(nr > N-1 || nc > M-1) return;
		
		int h = -1;
		int w = 0;
		int sum = 0;
		
		for(int i = r; i < nr; i++) {
			h++;
			w = 0;
			for(int j = c; j < nc; j++) {
				hWind[h][w++] = map[i][j];
				sum += map[i][j];
			}
			
		}
		
		// 0,1 ㄴ / 1,1 ㄱ
		answer = Math.max(answer, sum - hWind[1][1] - hWind[1][2]); // 
		answer = Math.max(answer, sum - hWind[0][1] - hWind[1][1]); // 
		answer = Math.max(answer, sum - hWind[0][0] - hWind[0][1]);
		answer = Math.max(answer, sum - hWind[0][1] - hWind[0][2]);
		answer = Math.max(answer, sum - hWind[0][0] - hWind[1][2]);  
		answer = Math.max(answer, sum - hWind[0][2] - hWind[1][0]);
		answer = Math.max(answer, sum - hWind[0][0] - hWind[0][2]); // ㅗ
		answer = Math.max(answer, sum - hWind[1][0] - hWind[1][2]); // ㅜ
	}
	
	public static void square(int i, int j) {
		
		if((i+1) > N-1 || (j+1) > M-1) return;
		
		int sum = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+1][j+1];
		
		
		answer = Math.max(answer, sum);		
	}
	
	public static void checkLine() {
		
		// 가로 라인
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M-3; j++) {
				int wLine = map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3];
				answer = Math.max(answer, wLine);
			}
		}
		
		
		
		// 세로 라인
		for(int j = 0; j < M; j++) {
			for(int i = 0; i < N-3; i++) {
				int cLine = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
				answer = Math.max(answer, cLine);
			}
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		print();
		// 라인 먼저 체크
		checkLine();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				widthWindow(i,j);
				heightWindow(i,j);
				square(i,j);
				
			}
		}
		
		System.out.println(answer);
	}
	
	public static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
