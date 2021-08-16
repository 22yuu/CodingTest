package bronze;

import java.util.*;
import java.io.*;

//반복문 사용하면 시간초과

public class boj2869_달팽이는올라가고싶다 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
        
		int day = (V - B) / (A - B);
		if((V-B) % (A-B) != 0)
			day++;
		
		System.out.println(day);
	}
}
