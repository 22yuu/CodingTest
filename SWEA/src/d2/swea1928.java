package d2;

import java.util.*;
import java.io.*;

public class swea1928 {
	
	private static Map<String, Integer> EncodingMap = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		/* Init Encdoing Map*/
		EncodingMap.put("A", 0);
		EncodingMap.put("B", 1);
		EncodingMap.put("C", 2);
		EncodingMap.put("D", 3);
		EncodingMap.put("E", 4);
		EncodingMap.put("F", 5);
		EncodingMap.put("G", 6);
		EncodingMap.put("H", 7);
		EncodingMap.put("I", 8);
		EncodingMap.put("J", 9);
		EncodingMap.put("K", 10);
		EncodingMap.put("L", 11);
		EncodingMap.put("M", 12);
		EncodingMap.put("N", 13);
		EncodingMap.put("O", 14);
		EncodingMap.put("P", 15);
		EncodingMap.put("Q", 16);
		EncodingMap.put("R", 17);
		EncodingMap.put("S", 18);
		EncodingMap.put("T", 19);
		EncodingMap.put("U", 20);
		EncodingMap.put("V", 21);
		EncodingMap.put("W", 22);
		EncodingMap.put("X", 23);
		EncodingMap.put("Y", 24);
		EncodingMap.put("Z", 25);
		EncodingMap.put("a", 26);
		EncodingMap.put("b", 27);
		EncodingMap.put("c", 28);
		EncodingMap.put("d", 29);
		EncodingMap.put("e", 30);
		EncodingMap.put("f", 31);
		EncodingMap.put("g", 32);
		EncodingMap.put("h", 33);
		EncodingMap.put("i", 34);
		EncodingMap.put("j", 35);
		EncodingMap.put("k", 36);
		EncodingMap.put("l", 37);
		EncodingMap.put("m", 38);
		EncodingMap.put("n", 39);
		EncodingMap.put("o", 40);
		EncodingMap.put("p", 41);
		EncodingMap.put("q", 42);
		EncodingMap.put("r", 43);
		EncodingMap.put("s", 44);
		EncodingMap.put("t", 45);
		EncodingMap.put("u", 46);
		EncodingMap.put("v", 47);
		EncodingMap.put("w", 48);
		EncodingMap.put("x", 49);
		EncodingMap.put("y", 50);
		EncodingMap.put("z", 51);
		EncodingMap.put("0", 52);
		EncodingMap.put("1", 53);
		EncodingMap.put("2", 54);
		EncodingMap.put("3", 55);
		EncodingMap.put("4", 56);
		EncodingMap.put("5", 57);
		EncodingMap.put("6", 58);
		EncodingMap.put("7", 59);
		EncodingMap.put("8", 60);
		EncodingMap.put("9", 61);
		EncodingMap.put("+", 62);
		EncodingMap.put("/", 63);
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String[] str = br.readLine().split("");
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < str.length; i++) {
//				sb.append(Integer.toBinaryString(EncodingMap.get(str[i])));
//				System.out.println(Integer.toBinaryString(EncodingMap.get(str[i])));
				String temp = Integer.toBinaryString(EncodingMap.get(str[i]));
				if(temp.length() < 6) {
					String zeros = "";
					for(int j = 0; j < 6 - temp.length(); j++) zeros += 0;
					
					temp = zeros + temp;
				}
				
//				System.out.println(temp);
				sb.append(temp);
			}
			String combinedStr = sb.toString();
			String temp = "";
			sb = new StringBuilder();
			for(int i = 0; i < combinedStr.length(); i++) {
				temp += "" + combinedStr.charAt(i);
				
				if(i != 0 && (i+1)%8 == 0) {
//					System.out.println((char)Integer.parseInt(temp, 2));
					sb.append("" + (char)Integer.parseInt(temp, 2));
//					System.out.println(temp + " " + Integer.parseInt(temp, 2));
					temp = "";
				}
				
			}
			
			System.out.printf("#%d %s\n", test_case, sb.toString());
		}
	}
}
