package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1110_더하기사이클 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		
		int num = Integer.parseInt(br.readLine());
		int a = (num % 100) / 10 ;
		int b = num % 10;
		int sum = 0;
		int cnt = 0;
		String str = "";
		int answer = -1;
		
		while(true) {

			sum = a + b;
			sb = new StringBuilder();
			
			if(num == answer) break;
			
			a =  b;
			b = sum % 10;
			
			str = sb.append(a).append(b).toString();
			answer = Integer.parseInt(str);
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
