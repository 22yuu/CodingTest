package silver;

import java.util.*;
import java.io.*;

public class boj1436_¿µÈ­°¨µ¶¼ò {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 1;
		int movieNum = 666;
		
		while(cnt != N) {
			movieNum++;
			
			if(String.valueOf(movieNum).contains("666")) {
				cnt++;
			}
		}
		System.out.println(movieNum);
	}
}
