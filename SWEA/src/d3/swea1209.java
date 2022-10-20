package d3;

import java.util.*;
import java.io.*;

public class swea1209 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		 for(int test_case = 1; test_case <= 10; test_case++) {
			 int max = Integer.MIN_VALUE;
			 
			 int map[][] = new int[100][100];
			 int leftCrossSum = 0;
			 int rightCrossSum = 0;
			 int testCase = Integer.parseInt(br.readLine());
			 
			 // init map & sum of rows
			 for(int i = 0; i < 100; i++) {
				 String temp[] = br.readLine().split(" ");
				 int sum = 0;
				 
				 for(int j = 0; j < 100; j++) {
					 map[i][j] = Integer.parseInt(temp[j]);
					 sum += map[i][j];
				 }
				 
				 max = Math.max(max, sum);
			 }
			 
			 
			 for(int i = 0; i < 100; i++) {
				 int sum = 0;
				 for(int j = 0; j < 100; j++) {
					 sum += map[j][i]; // sum of columns
					 
					 if(i == j) leftCrossSum += map[i][j];
				 }
				 max = Math.max(max, sum);
			 }
			 
			 max = Math.max(max, leftCrossSum);
			 
			 // sum of right cross
			 int index = 0;
			 for(int i = 99; i >= 0; i--) {
				 rightCrossSum += map[index++][i];
			 }
			 
			 max = Math.max(max, rightCrossSum);
			 
			 System.out.printf("#%d %d\n", test_case, max);
		 }
	}
}
