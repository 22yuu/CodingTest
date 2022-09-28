package d2;

import java.util.*;
import java.io.*;

public class swea1989 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= T; test_case++) {
			char[] str = sc.next().toCharArray();
			int result = 1;
			int mid = (int)(str.length / 2) ;
			int lastIndex = str.length - 1;
			
			
			for(int i = 0; i < mid; i++) {
				if(str[i] != str[lastIndex - i]) {
					result = 0;
					break;
				}
			}
			
			System.out.printf("#%d %d", test_case, result);
		}
	}

}
