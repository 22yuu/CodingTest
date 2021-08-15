package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2675_문자열반복 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase <= T; testcase++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int iter = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			
			for(int i = 0; i < str.length(); i++) {
				for(int j =0; j < iter; j++) {
					System.out.println(str.charAt(i));
				}
			}
		}
		br.close();
	}
}
