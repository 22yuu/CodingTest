package d2;

import java.util.*;
import java.io.*;

public class swea1204 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int[] scoreArray = new int[101]; // 0~100
			int max = Integer.MIN_VALUE;
			int maxIdx = 0;
			int temp = Integer.parseInt(br.readLine());
			String[] scores = br.readLine().split(" ");
			
			for(int i = 0; i < scores.length; i++) {
				int score = Integer.parseInt(scores[i]);
				scoreArray[score]++;
			}
			
			// find
			for(int i = 0; i < scoreArray.length; i++) {
				if(max < scoreArray[i]) {
					 max = scoreArray[i];
					 maxIdx = i;
				} else if(max == scoreArray[i]) {
					if(maxIdx < i) maxIdx = i;
				}
			}
			System.out.printf("#%d %d\n", test_case, maxIdx);
		}
	}
}
