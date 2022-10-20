package d3;

import java.util.*;
import java.io.*;


public class SWEA12741 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int answer = 0;
			
			int A = Integer.parseInt(st.nextToken()); // 전구 X : A초 부터 관찰 시작
			int B = Integer.parseInt(st.nextToken()); // 전구 X : B초 까지켜짐
			int C = Integer.parseInt(st.nextToken()); // 전구 Y : C초부터 관찰 시작
			int D = Integer.parseInt(st.nextToken()); // 전구 Y : D초까지 켜짐
			
			int temp1 = Math.min(B, D);
			int temp2 = Math.max(A, C);
			
			answer = temp1 - temp2 > 0 ? temp1 - temp2 : 0;
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}
