package silver;

import java.util.*;
import java.io.*;

public class boj2581_¼Ò¼ö {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int start = Integer.parseInt(br.readLine());
		int end = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = 0;
		
		while(start <= end) {
			
			if(isPrimNum(start)) {
				
				if(sum == 0) min = start;
				sum += start;
			}
			start++;
		}
		
		if(sum == 0) System.out.println("-1");
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
	
	public static boolean isPrimNum(int num) {
		
		if(num == 1) return false;
		
		int cnt = 0;
		for(int i = 2; i < num; i++) {
			if(num % i == 0 ) cnt++;
			
			if(cnt >= 1) return false;
		}
		return true;
	}
}
