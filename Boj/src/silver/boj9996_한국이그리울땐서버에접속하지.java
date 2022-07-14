package silver;

import java.util.*;
import java.io.*;

public class boj9996_한국이그리울땐서버에접속하지 {

	private static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String pattern = br.readLine();
		String[] splitted = pattern.split("\\*");
		String pStart = splitted[0];
		String pEnd = splitted[1];
		
		
		for(int i = 0 ; i < N; i++) {
			String str = br.readLine();

			if(pattern.replace("*", "").equals(str)) {
				System.out.println("DA");
				continue;
			}
			
			if(pattern.replace("*", "").length() > str.length()) {
				/*
					1
					abcd*cdef
					abcdef
					NE
					이처럼 중복도 피해줘야함
				 */
				System.out.println("NE");
				continue;
			}
				
			
			if(str.length() < pStart.length() || str.length() < pEnd.length()) {
				System.out.println("NE");
				continue;
			}
			
			String start = str.substring(0, pStart.length());
			String end = str.substring(str.length() - pEnd.length());
			
			if(pStart.equals(start) && pEnd.equals(end)) System.out.println("DA");
			else System.out.println("NE");
		}
		

	}

}
