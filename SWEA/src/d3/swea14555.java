package d3;

import java.util.*;
import java.io.*;

public class swea14555 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String[] str = br.readLine().split("");
			int answer = 0;
			
			for(int i = 0; i < str.length - 1; i++) {
				
				if(str[i].equals("(")) {
					if(str[i+1].equals(")") || str[i+1].equals("|")) answer++;
				} else if(str[i].equals("|")) {
					if(str[i+1].equals(")")) answer++;
				}
			}
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}
