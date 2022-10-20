package d2;

import java.io.*;
import java.util.*;

public class swea1288 {

	public static boolean isDone(int[] numbers) {
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] == 0) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int index = 0;
			int[] numbers = new int[10];
			
			while(isDone(numbers)) {
				int temp = ++index*N;
				
				while(temp > 0) {
					int num = temp % 10;
					temp /= 10;
					numbers[num]++;
				}
				
			}
			
			System.out.printf("#%d %d\n", test_case, index*N);
		}
	}
}
