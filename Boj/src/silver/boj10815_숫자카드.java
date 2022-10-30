package silver;

import java.util.*;
import java.io.*;

public class boj10815_숫자카드 {
	
	private static int N, M;
	private static int NUMBERS[];
	private static int[] targetNumbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		NUMBERS = new int[20000001];
		
		N = Integer.parseInt(br.readLine());
		
		
		String[] inputs = br.readLine().split(" ");
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(inputs[i]);
			
			if(num < 0) {
				num = (num * -1) + 10000000;
			}
			
			NUMBERS[num]++;
		}
		
		M = Integer.parseInt(br.readLine());
		targetNumbers = new int[M];
		
		inputs = br.readLine().split(" ");
		
		for(int i = 0; i < M; i++) {
			targetNumbers[i] = Integer.parseInt(inputs[i]);
		}
		
		for(int i = 0; i < targetNumbers.length; i++) {
			int num = targetNumbers[i];
			
			if(num < 0) {
				num = (num * -1) + 10000000;
			}
			
			if(NUMBERS[num] == 1) sb.append(1 + " ");
			else sb.append(0 + " ");
		}
		
		System.out.println(sb.toString());
	}
}
