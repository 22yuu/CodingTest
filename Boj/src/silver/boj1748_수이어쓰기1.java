package silver;
import java.util.*;
import java.io.*;

public class boj1748_수이어쓰기1 {

		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		if(N <= 9) {
			System.out.println(N);
			return;
		}
		
		for(int i = 1; i <=N; i++) {
			sb.append(i);
		}
		
		String nums = sb.toString();
		
		System.out.println(nums.length());;

	}

}
