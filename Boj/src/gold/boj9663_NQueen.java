package gold;

import java.util.*;
import java.io.*;

public class boj9663_NQueen {
	
	private static int[] map; // index: 열 / 값 : 행 
	private static int N;
	private static int count = 0;
	
	public static boolean isPossible(int col) {
		
		for(int i = 0; i < col; i++) {
			if(map[col] == map[i]) {
				return false;
			}
			
			
			/*
			 * 대각선상에 놓여있는 경우
			 * (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우다)
			 */
			
			else if(Math.abs(col - i) == Math.abs(map[col] - map[i])) {
				return false;
			}
		}
		
		
		return true;
	}
	
	public static void nQueen(int depth) {
		
		if(depth == N) {
			count++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			map[depth] = i;
			
			if(isPossible(depth)) {
				nQueen(depth+1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N];
		nQueen(0);
		System.out.println(count);
	}
}
