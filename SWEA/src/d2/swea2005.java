package d2;

import java.util.Scanner;

public class swea2005 {
	
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int[] prevNums;
		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			prevNums = new int[N+1]; // 임시로 초기화
			System.out.println("#"+test_case);
			for(int i = 1; i <= N; i++) {
				int[] nums = new int[i+1];

				for(int j = 1; j <= i; j++) {
					if(j == 1 || j == i) {
						System.out.print("1");
						nums[j] = 1;
					} else {
						nums[j] = prevNums[j] + prevNums[j-1];
						System.out.print(nums[j]);
					}
					System.out.print(" ");
					
				}
				System.out.println();
				prevNums = nums.clone();
			}
		}
	}
}
