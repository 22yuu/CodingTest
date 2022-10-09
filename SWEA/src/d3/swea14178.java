package d3;

import java.util.*;
import java.io.*;

public class swea14178 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int answer = 0;
			
			int D = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			
			answer = (int)Math.ceil((double)D / ((N*2)+1));
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}
