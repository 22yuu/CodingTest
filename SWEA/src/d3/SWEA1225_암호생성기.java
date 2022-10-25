package d3;

import java.io.*;

public class SWEA1225_��ȣ������ {

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
			String strTemp = br.readLine(); // �Է� ������ ���� ���� �׽�Ʈ���̽� ��ȣ ���� 
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
				
				// operand�� �� ���� �� �ڷ�
				nums = swap(nums);
				
				operand++;
			}
			
			System.out.printf("#%d %d %d %d %d %d %d %d %d\n", test_case, nums[0], nums[1], nums[2], nums[3], nums[4], nums[5], nums[6], nums[7]);
		}
	}
}
