package silver;

import java.util.*;
import java.io.*;

public class boj1316_그룹단어체커 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] alphabet;
		
		String[] strArr = new String[N];
		
		int cnt = 0;
		for(int i =0; i < N; i++) {
			strArr[i] = br.readLine();
			char prev = strArr[i].charAt(0);
			boolean isGroupWord = true;
			alphabet = new int[26];
			
			for(int j = 0; j < strArr[i].length(); j++) {
				char curr = strArr[i].charAt(j);
				if(prev == curr) {
					alphabet[curr - 'a']++;
				} else {
					prev = curr;
					if(alphabet[curr-'a'] > 0) {
						isGroupWord = false;
						break;
					} else {
						alphabet[curr-'a']++;
					}
				}
				
			}
			
			if(isGroupWord) cnt++;
		}
		
		System.out.println(cnt);
	}
}
