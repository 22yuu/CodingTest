package d2;

import java.io.*;
import java.util.*;

public class swea1946 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			sb.append("#").append(test_case).append("\n");
			int iter = 0;
			
			for(int i = 0; i < N; i++) {
				String[] inputs = br.readLine().split(" ");
				String str = inputs[0];
				int num = Integer.parseInt(inputs[1]);
				
				for(int j = 0; j < num; j++) {
					sb.append(str);
					iter++;
					if(iter == 10) {
						sb.append("\n");
						iter = 0;
					}
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
