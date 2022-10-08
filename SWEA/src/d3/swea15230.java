package d3;

import java.util.*;
import java.io.*;

public class swea15230 {

	private static String[] alphabets = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k","l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String[] strs = br.readLine().split("");
			int answer = 0;
			
			for(int i = 0; i < strs.length; i++) {
				if(strs[i].equals(alphabets[i])) answer++;
				else break;
			}
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}
