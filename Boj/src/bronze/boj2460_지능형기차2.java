package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj2460_지능형기차2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int people = 0;
		int max = 0;
		
		for(int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());
			
			people -= out;
			people += in;
			
			max = Math.max(max, people);
			
		}
		System.out.println(max);
	}

}
