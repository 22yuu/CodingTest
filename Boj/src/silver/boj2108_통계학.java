package silver;


import java.util.*;
import java.io.*;

public class boj2108_����� {
		
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
		
		// ������ �Ҽ��� ���� ù° �ڸ����� �ݿø� : N���� ������ ���� N���� ���� ��
		int mean = Math.round(sum / n);
		
		// �߾Ӱ� : N���� ������ �����ϴ� ������ �������� ��� �� �߾ӿ� ��ġ�ϴ� ��
		Arrays.sort(nums);
		Integer mid = nums[n/2]; // n�� ������ Ȧ��
		int min = nums[0];
		
		Arrays.sort(nums, Collections.reverseOrder());
		int max = nums[0];
		
		// �ֺ� ��
		
		// ���� : �ִ񰪰� �ּڰ��� ����
		int range = max - min;
		
		// ���
		// ������
		System.out.println(mean);
		
		// �߾Ӱ�
		System.out.println(mid);
		
		// �ֺ�
		
		// ����
		System.out.println(range);
		
		
		
	}
}
