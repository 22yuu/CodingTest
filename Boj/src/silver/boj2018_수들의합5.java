package silver;

import java.util.*;
import java.io.*;

public class boj2018_수들의합5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int answer = 0;
		
		int left = 1;
		int right = 1;
		int sum = 1;
		
		while(left <= right && right <= n) {
			
			if(sum == n) {
				answer++;
				sum -= left;
				left++;
				right++;
				sum+=right;
			} else if( sum < n) {
				right++;
				sum += right;
			} else {
				sum -= left;
				left++;
			}
		}
		
		
		System.out.println(answer);

	}

}
