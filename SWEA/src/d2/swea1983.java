package d2;

import java.util.*;
import java.io.*;

public class swea1983 {
	static String[] COURSE_CREDIT = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String[] temp = br.readLine().split(" ");
			
			int N = Integer.parseInt(temp[0]);
			int K = Integer.parseInt(temp[1]);
			double[] scores = new double[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int midTerm = Integer.parseInt(st.nextToken());
				int finalTerm = Integer.parseInt(st.nextToken());
				int homework = Integer.parseInt(st.nextToken());
				
				double totalScore = (midTerm * 0.35) + (finalTerm * 0.45) + (homework * 0.2);
				
				scores[i] = totalScore;
//				System.out.println(scores[i]);
			}
			
			double findCourseCredit = scores[K - 1];
			int findIndex = 0;
			int div = N / 10;
			
			Arrays.sort(scores);
			
			for(int i = 0; i < N; i++) {
				if(scores[i] == findCourseCredit) findIndex = i;
			}
			
			int index = (N - findIndex - 1) / div;
			
			System.out.printf("#%d %s\n", test_case, COURSE_CREDIT[index]);
		}
		
	}
}
