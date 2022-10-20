package d2;

import java.io.*;
import java.util.*;

public class swea1945 {
	
	private static int[] OPERAND = {2, 3, 5, 7, 11};
	private static int SIZE = OPERAND.length;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] counts = new int[SIZE];
			sb.append("#").append(test_case).append(" ");
			int index = 0;
			
			while(true) {
				if(index == SIZE) break;
				
				if(N % OPERAND[index] == 0) {
					counts[index]++;
					N /= OPERAND[index];
				} else {
					sb.append(counts[index]).append(" ");
					index++;
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
