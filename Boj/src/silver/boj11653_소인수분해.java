package silver;

import java.util.*;
import java.io.*;


public class boj11653_���μ����� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int i = 2;
		
		while(i <= N) {
			
			if(N%i == 0) {
				System.out.println(i);
				N /= i;
			} else {
				i += 1;
			}
		}
	}
}
