package bronze;

import java.util.*;
import java.io.*;

public class boj2331_ºÐÇØÇÕ {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = (N/2); i < N; i++) {
			int result = Generator(i) + i;
			if(N == result) {
				list.add(i);
			}
		}
		
		if(list.size() == 0) {
			System.out.println(list.size());
		}else {
			System.out.println(list.get(0));
		}
	}
	
	public static int Generator(int N) {
		
		if(N == 0) return 0;
		
		int mod = N % 10;
		
		return Generator(N/10) + mod;
		
	}
	
}
