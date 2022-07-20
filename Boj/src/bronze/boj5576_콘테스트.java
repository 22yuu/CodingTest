package bronze;

import java.util.*;
import java.io.*;

public class boj5576_콘테스트 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] W = new int[10];
		int[] K = new int[10];
		
		for(int i = 0; i < 10; i++) W[i] = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < 10; i++) K[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(W);
		Arrays.sort(K);
		
		int W_Sum = W[9] + W[8] + W[7];
		int K_Sum = K[9] + K[8] + K[7];
		
		System.out.println(W_Sum + " " + K_Sum);
	}

}
