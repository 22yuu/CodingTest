package d3;

import java.util.*;
import java.io.*;

public class swea1244 {
	
	public static int findMaxIndex(int[] arr, int start) {
		// 배열에서 최대값 인덱스를 찾기
		
		if(arr.length - 1 == start) return start;
		
		int max = arr[start];
		int maxIndex = start;
		
		for(int i = start+1; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
//			StringBuilder sb = new StringBuilder();
			
			String[] temp = br.readLine().split(" ");
			
			String[] nums = temp[0].split("");
			int iter = Integer.parseInt(temp[1]);
			int[] numArr = new int[nums.length];
			
			for(int i = 0; i < nums.length; i++) {
				numArr[i] = Integer.parseInt(nums[i]);
			}
			
			int index = 0;
			
			while(iter >= 0) {
				StringBuilder sb = new StringBuilder();
				int maxIndex = findMaxIndex(numArr, index);
				
				// swap
				if(index != maxIndex) {
					numArr = swap(numArr, index, maxIndex);
					index++;
				} 
				else {
					// index 값과 maxIndex 값이 같다면 마지막이거나 남은 숫자들 중 최대값이 없음 
					// 그래도 반드시 교환을 해야됨 예 ) iter : 1 / 94 -> 49 
					
					maxIndex = findMaxIndex(numArr, index);
					System.out.println(index + " " + maxIndex);
					numArr = swap(numArr, index, maxIndex);
					index++;
					if(index > numArr.length - 1) {
						index--;
					}
				}
				
				iter--;
				for(int n : numArr) sb.append(n);
				System.out.printf("#%d current index %d / current Max Index %d / current array values %s\n", iter, index, maxIndex, sb.toString());
			} // end while loop;
			
//			for(int n : numArr) sb.append(n);
//			System.out.printf("#%d %s\n", test_case, sb.toString());
			
		} // end test case loop
	} // end main
	
	public static int[] swap(int[] arr, int index, int maxIndex) {
		
		int temp = arr[index];
		arr[index] = arr[maxIndex];
		arr[maxIndex] = temp;
		
		return arr;
	}
}
