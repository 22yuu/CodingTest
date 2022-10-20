package d2;

import java.io.*;
import java.util.*;

// 1/31, 2/28, 3/31, 4/30, 5/31, 6/30, 7/31, 8/31, 9/30, 10/31, 11/30, 12/31

public class swea1948 {

	public static int[] DATES = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			
			int m1 = Integer.parseInt(st.nextToken());
			int d1 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			int d2 = Integer.parseInt(st.nextToken());

			if(m1 == m2) {
				answer = (d2 - d1) + 1;
			} else if(m2 - m1 == 1) {
				int temp = DATES[m1] - d1;
				
				answer = temp + d2 + 1;
			}
			else {
				// 두 월 사이의 월들의 일 수를 모두 더함
				for(int m = m1+1; m < m2; m++) {
					answer += DATES[m];
				}
				
				int temp = DATES[m1] - d1;
				
				answer += temp + d2 + 1;
			}
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}
