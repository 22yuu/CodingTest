package silver;

import java.util.*;
import java.io.*;

public class boj2417_정수제곱근 {

	static long bs(long n) {
		// binary search
		
		long left = 0;
		long right = n - 1;
		long mid = (left + right) / 2;
		
		
		while(left <= right) {
			mid = (left + right) / 2;
			
			if(mid < Math.sqrt(n)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return left;
		
		
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		
		long answer = bs(n);
		System.out.println(answer);
		
//		long answer = (long)(Math.sqrt(n));
//		if(answer * answer != n) answer += 1;
//		System.out.println(answer);
		
		

	}

}
