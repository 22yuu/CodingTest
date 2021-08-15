package d3;

import java.util.*;
import java.io.*;

public class sw5215_�ܹ��Ŵ��̾�Ʈ {

	static int N; // ����� ����
	static int L; // �ִ� Į�θ�
	static int listSize;
	static int max;

	static List<int[]> list;

	public static void hamburger(int idx, int prefer, int cal) {

		// Į�θ��� ���� �ʰ��Ѵٸ� ����
		if (cal > L)
			return;

		// ��� ����� ��
		if (idx == listSize) {
			max = Math.max(max, prefer);
			return;
		}

		int value[] = list.get(idx);

		// �� ��Ḧ ����� ���
		hamburger(idx + 1, prefer + value[0], cal + value[1]);

		// �� ��Ḧ ��� ���� ���
		hamburger(idx + 1, prefer, cal);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // ����� ����
			L = Integer.parseInt(st.nextToken()); // �ִ� Į�θ�
			list = new ArrayList<>();
			max = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				if (l < L)
					list.add(new int[] { n, l });
			}

			listSize = list.size();

			hamburger(0, 0, 0);

			System.out.println("#" + testcase + " " + max);

		}
	}
}
