package d3;

import java.util.*;
import java.io.*;

public class SWEA11445_무한사전 {
	
	private static int T;
	private static Map<Integer, Character> alphabet;
	private static String answer;
	
	private static char toChar(int value) {
		char c =(char)(value);
		return c;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		alphabet = new HashMap<>();
		
		answer = "Y";
		
		// init map
		int a = 97;
		for(int i = 0; i < 26; i++) {
			int n = a + i;
			alphabet.put(n, toChar(n));
		}
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String P = br.readLine();
			String Q = br.readLine();
			
			char[] pChars = P.toCharArray();
			char[] qChars = Q.toCharArray();
			int pLen = pChars.length;
			int qLen = qChars.length;
			
			int pIdx = pLen - 1;
			int qIdx = qLen - 1;
			
			if(pLen == qLen) {
				Loop:for(int i = 0; i < pLen; i++) {
					
					if(pChars[i] == qChars[i]) continue;
					
					if(pChars[i] < qChars[i]) {
						break Loop;
					}else if(pChars[i] > qChars[i]){
						answer = "N";
					}
				}
			} else if(pLen < qLen) {
				int count = 0;
				boolean isSame = false;
				
				Loop:for(int i = 0; i < pLen; i++) {
					
					if(pChars[i] == qChars[i]) {
						count++;
						isSame = count == pLen;
						continue;
					}
					
					if(pChars[i] < qChars[i]) {
						break Loop;
					}else if(pChars[i] > qChars[i]){
						answer = "N";
					}
					
					
					
				}
				
				if(isSame) {
					
					answer = qChars[pLen] == 'a' ? "N" : "Y";
				}
				
			} else {
				answer = "N";
			}
			
			
			System.out.printf("#%d %s\n", test_case, answer);
			
		}
	}
}
