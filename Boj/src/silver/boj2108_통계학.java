package silver;


import java.util.*;
import java.io.*;

public class boj2108_통계학 {
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Integer[] nums = new Integer[n];
		int count[] = new int[8001];
		
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		int sum = 0;
		for(int num : nums) sum += num;
		
		// 산술평균 소수점 이하 첫째 자리에서 반올림 : N개의 수들의 합을 N으로 나눈 값
		int mean = Math.round(sum / n);
		
		// 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
		Arrays.sort(nums);
		Integer mid = nums[n/2]; // n은 무조건 홀수
		int min = nums[0];
		
		Arrays.sort(nums, Collections.reverseOrder());
		int max = nums[0];
		
		// 최빈 값
		
		// 범위 : 최댓값과 최솟값의 차이
		int range = max - min;
		
		// 출력
		// 산술평균
		System.out.println(mean);
		
		// 중앙값
		System.out.println(mid);
		
		// 최빈값
		
		// 범위
		System.out.println(range);
		
		
		
	}
}
