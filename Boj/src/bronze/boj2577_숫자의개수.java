package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2577_숫자의개수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int count[] = new int[10];
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int mul = A * B * C;
		
		String result = sb.append(mul).toString();
		
		for(int i =0; i < result.length(); i++) {
			count[result.charAt(i) - '0'] += 1;
		}
		
		
		for(int i =0; i < count.length; i++) {
			System.out.println(count[i]);
		}
		
		
		
		
	}
}
