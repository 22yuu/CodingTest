package lv2;

import java.util.*;
import java.io.*;

public class 뉴스클러스터링 {
	
	public static String pattern = "[a-zA-Z]";
    public static List<String> strList1 = new ArrayList<>();
    public static List<String> strList2 = new ArrayList<>();
    public static List<String> union = new ArrayList<>();
    public static List<String> intersection = new ArrayList<>();
	
    public static void addList(String str, List<String> list) {
        
        for(int i = 0; i < str.length() - 1; i++) {
            String temp = str.substring(i, i+2);
            int check = 0;
            for(int j = 0; j < temp.length(); j++) {
            	char c = temp.charAt(j);
            	int value = c - 65;
            	
            	if(value >= 0 && value <= 26) {
            		check++;
            	}
            }
            
            if(check == 2) {
            	list.add(temp);
            }
        }
    }
    
	public static void main(String[] args) {
		String str1 = "france";
		String str2 = "E=M*C^2";
		
		//str1 = str1.replace(pattern, "");
        //str2 = str2.replaceAll(pattern, "");
        
        System.out.println(str2);
        
		str1 = str1.toUpperCase();
		
        addList(str1, strList1);
        addList(str2, strList2);
		
        
        if(str2.matches(pattern)) {
        	System.out.println("일치");
        } else {
        	System.out.println("불일치");
        }
        
        System.out.println(strList1.toString());
        System.out.println(strList2.toString());
	}
}
