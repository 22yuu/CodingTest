package bronze;

import java.util.*;
import java.io.*;

public class boj10808_¾ËÆÄºª°³¼ö {

	private static int[] alpha;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		alpha = new int[26];
		
		for(int i = 0; i < s.length(); i++) {
			alpha[s.charAt(i) - 'a']++;
		}
		
		for(int n : alpha) System.out.print(n + " ");

	}

}
