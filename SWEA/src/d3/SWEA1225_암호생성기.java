package d3;

import java.io.*;

public class SWEA1225_암호생성기 {

	public static int[] swap(int[] nums) {
		for(int i = 0; i < nums.length - 1; i++) {
			int temp = nums[i];
			nums[i] = nums[i+1];
			nums[i+1] = temp;
		}
		
		return nums;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int nums[] = new int[8];
			String strTemp = br.readLine(); // 입력 값에서 쓸모 없는 테스트케이스 번호 저장 
			String str[] = br.readLine().split(" ");
			
			// init nums array
			for(int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(str[i]);
			
			int operand = 1;
			
			while(true) {
				
				if(operand == 6) operand = 1;
				
				nums[0] = nums[0] - operand <= 0 ? 0 : nums[0] - operand;
				
				if(nums[0] == 0) {
					nums = swap(nums);
					break;
				}
				
				// operand를 뺀 값을 맨 뒤로
				nums = swap(nums);
				
				operand++;
			}
			
			System.out.printf("#%d %d %d %d %d %d %d %d %d\n", test_case, nums[0], nums[1], nums[2], nums[3], nums[4], nums[5], nums[6], nums[7]);
		}
	}
}
