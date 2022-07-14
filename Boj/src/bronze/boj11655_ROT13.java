package bronze;

import java.util.*;
import java.io.*;

public class boj11655_ROT13 {
	
	public static String Convert(String s) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			char converted = ' ';
			
			if (48 <= ch && ch <= 57) {
				// 정수일 경우
		        sb.append(ch);
		        continue;
		    }
			
			if(ch >= 'a' && ch <= 'z') {
				// 소문자
				int rot = (int)ch + 13;
				int z = (int)'z';
				int a = (int)'a';
				
				if(rot > z) {
					int diff = rot - z;
					converted = (char)(a + (diff-1));
					sb.append(converted);
					continue;
				}
				sb.append((char)rot);
				continue;
				
			} else {
				// 대문자
				int rot = (int)ch + 13;
				int z = (int)'Z';
				int a = (int)'A';
				
				if(rot > z) {
					int diff = rot - z;
					converted = (char)(a + (diff - 1));
					sb.append(converted);
					continue;
				}
				sb.append((char)rot);
				continue;
			}
		}
		
		return sb.append(" ").toString();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		
		for(String str : strArr) {
			System.out.print(Convert(str));
		}
	}
}
