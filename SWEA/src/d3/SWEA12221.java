package d3;

import java.util.*;
import java.io.*;

public class SWEA12221 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String inputs[] = br.readLine().split(" ");
			int answer = -1;
			
			int n1 = Integer.parseInt(inputs[0]);
			int n2 = Integer.parseInt(inputs[1]);
			
			if(!checkNumber(n1) && !checkNumber(n2)) answer = n1 * n2;
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
	
	public static boolean checkNumber(int num) {
		// 2자리 이상이면 10 이상의 수!  2자리 이상이면 true를 리
		return Math.log10(num) + 1 >= 2;
	}
}
