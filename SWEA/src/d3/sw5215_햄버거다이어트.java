package d3;

import java.util.*;
import java.io.*;

public class sw5215_햄버거다이어트 {

	static int N; // 재료의 갯수
	static int L; // 최대 칼로리
	static int listSize;
	static int max;

	static List<int[]> list;

	public static void hamburger(int idx, int prefer, int cal) {

		// 칼로리의 합이 초과한다면 리턴
		if (cal > L)
			return;

		// 모든 경우의 수
		if (idx == listSize) {
			max = Math.max(max, prefer);
			return;
		}

		int value[] = list.get(idx);

		// 이 재료를 사용할 경우
		hamburger(idx + 1, prefer + value[0], cal + value[1]);

		// 이 재료를 사용 안할 경우
		hamburger(idx + 1, prefer, cal);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 개수
			L = Integer.parseInt(st.nextToken()); // 최대 칼로리
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
