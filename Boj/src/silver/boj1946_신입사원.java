package silver;

import java.util.*;
import java.io.*;

public class boj1946_신입사원 {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		
		int T = sc.nextInt();
		
		
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[] interviewers = new int[n];
			ArrayList<Integer> list = new ArrayList<>();
			
			for(int i = 0; i < n; i++) {
				interviewers[sc.nextInt() - 1] = sc.nextInt(); // 배열의 index값은 서류 등수 / 배열의 값은 면접 등수
			}
			
			int temp = interviewers[0];
			int answer = 1;
			for(int i = 1; i < n; i++) {
				if(temp > interviewers[i]) {
					// 서류 등수는 낮지만 면접 등수가 높은 경우
					temp = interviewers[i];
					answer++;
				}
			}
			
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
				

	}

}
