package bronze;

import java.util.*;
import java.io.*;

public class boj2752_세수정렬 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strArr = br.readLine().split(" ");
		
		int[] nums = new int[strArr.length];
		
		for(int i = 0; i < strArr.length; i++) nums[i] = Integer.parseInt(strArr[i]);
		
		Arrays.sort(nums);
		
		for(int num : nums) System.out.print(num + " ");
		
	}

}
