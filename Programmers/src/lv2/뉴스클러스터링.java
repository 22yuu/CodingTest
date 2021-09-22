package lv2;

import java.util.*;
import java.io.*;

public class 뉴스클러스터링 {
	
	public static String pattern = "[^a-zA-Z]";
	
	public static void main(String[] args) {
		String str1 = "france";
		String str2 = "E=M*C^2";
		
		str1 = str1.replace(pattern, "");
        str2 = str2.replaceAll(pattern, "");
        
        System.out.println(str2);
        
		str1 = str1.toUpperCase();
		
        for(int i = 0; i < str1.length() - 1; i++) {
            String temp = str1.substring(i, i+2);
            System.out.println(temp);
        }
		
//		System.out.println('A' - 65);
//		System.out.println('*' - 65);
//		System.out.println('+' - 65);
//		System.out.println(str1);
	}
}
