package sort;

import java.util.*;
import java.io.*;

public class 위에서아래로 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
//		for(int i = 1; i < n; i++) {
//			if(arr[i-1] < arr[i]) {
//				int temp = arr[i-1];
//				arr[i-1] = arr[i];
//				arr[i] = temp;
//			}
//		}
		
		Arrays.sort(arr, Collections.reverseOrder());

		for(int num : arr) System.out.println(num);
	}
}
