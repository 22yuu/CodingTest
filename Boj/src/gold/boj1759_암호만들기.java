package gold;

import java.util.*;
import java.io.*;

public class boj1759_암호만들기 {

	private static int L, C;
	private static char[] strs;
	private static char[] sel;
	private static List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
	
	// 최소 1개 모음과 최소 2개의 자음으로 구성
	public static boolean isValid(String str) {
		
		char[] chars = str.toCharArray();
		int vowelCount = 0; // 모음 카운트
		int consonantCount = 0; // 자음 카운트
		
		for(int i = 0; i < chars.length; i++) {
			if(vowels.contains(chars[i])) {
				vowelCount++;
			} else {
				consonantCount++;
			}
		}
		
		if(vowelCount >= 1 && consonantCount >= 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void func(int start, int idx) {
		
		if(idx == L) {
			String str = new String(sel);
			if(isValid(str)) System.out.println(str);
			return;
		}
		
		
		for(int i = start; i < C; i++) {
			sel[idx] = strs[i];
			func(i+1, idx+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		String[] temp = br.readLine().toLowerCase().split(" ");
		
		strs = new char[C];
		sel  = new char[L];
		
		for(int i = 0; i < C; i++) strs[i] = temp[i].charAt(0);
		Arrays.sort(strs);
		func(0, 0);
		
//		isValid("acis");
		
	}
}
