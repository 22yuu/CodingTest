package silver;

import java.util.*;
import java.io.*;

public class boj1946_���Ի�� {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		
		int T = sc.nextInt();
		
		
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[] interviewers = new int[n];
			ArrayList<Integer> list = new ArrayList<>();
			
			for(int i = 0; i < n; i++) {
				interviewers[sc.nextInt() - 1] = sc.nextInt(); // �迭�� index���� ���� ��� / �迭�� ���� ���� ���
			}
			
			int temp = interviewers[0];
			int answer = 1;
			for(int i = 1; i < n; i++) {
				if(temp > interviewers[i]) {
					// ���� ����� ������ ���� ����� ���� ���
					temp = interviewers[i];
					answer++;
				}
			}
			
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
				

	}

}
