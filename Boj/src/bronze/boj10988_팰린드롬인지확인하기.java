package bronze;

import java.util.*;
import java.io.*;

public class boj10988_팰린드롬인지확인하기 {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String origin = br.readLine();
		String reverse = sb.append(origin).reverse().toString();
		
		if(origin.equals(reverse)) System.out.println(1);
		else System.out.println(0);

	}

}
