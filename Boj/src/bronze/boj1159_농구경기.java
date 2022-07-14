package bronze;

import java.util.*;
import java.io.*;

public class boj1159_³ó±¸°æ±â {

	private static int N;
	private static HashMap<Character, Integer> hm;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		hm = new HashMap<>();
		String answer = "";
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			
			char ch = str.charAt(0);
			
			if(hm.get(ch) != null ) {
				hm.put(ch, hm.get(ch) + 1);
				continue;
			}
			
			hm.put(ch, 1);
		}
		
		
		for(char ch : hm.keySet()) {
			if(hm.get(ch) >= 5) answer += ch;
			System.out.println(ch + " : " +  hm.get(ch));
		}
		
		char[] StringToChar = answer.toCharArray();
		
		Arrays.sort(StringToChar);
		
		answer = new String(StringToChar);
		
		if(!answer.equals("")) System.out.println(answer);
		else System.out.println("PREDAJA");
		
		

	}

}
