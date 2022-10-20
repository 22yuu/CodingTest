package silver;

import java.util.*;
import java.io.*;

public class boj1254_펠린드롬만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(make(sc.nextLine()));
		sc.close();
	}
	
	private static int make(String str) {
		int i, len = str.length();
		for(i=0;i<len;i++)
			if(isPalindrome(str.substring(i)))
				return i + len;
		return len << 1;
	}
	
	private static boolean isPalindrome(String str) {
		int i, len = str.length(), half = len >>> 1;
		for(i=0;i<=half;i++)
			if(str.charAt(i) != str.charAt(len-i-1))
				return false;
		return true;
	}
}
