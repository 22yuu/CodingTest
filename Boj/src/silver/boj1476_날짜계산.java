package silver;

import java.util.*;
import java.io.*;

public class boj1476_날짜계산 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String year[] = br.readLine().split(" ");
		
		int E = Integer.parseInt(year[0]);
		int S = Integer.parseInt(year[1]);
		int M = Integer.parseInt(year[2]);
		
		int e = 0, s = 0, m = 0, answer = 0;
		while(true) {
			
			e++;
			s++;
			m++;
			
			
			if(e > 15) e = 1;
			if(s > 28) s = 1;
			if(m > 19) m = 1;
			
			answer++;
			if(E == e && S == s && M == m) {
				break;
			}
		}
		
		System.out.println(answer);
		
		
		
	}
}
