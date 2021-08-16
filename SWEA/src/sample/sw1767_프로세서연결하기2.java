package sample;

import java.util.*;
import java.io.*;

public class sw1767_���μ��������ϱ�2 {

	static int N;
	static int map[][];
	static int total_core_count;
	static int max;
	static int min;

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static List<int[]> list;

	public static void search(int idx, int core_count, int line_length) {

		if (idx == total_core_count) {
			if (core_count > max) { // �ھ� ������ �ִ��ΰ�?
				max = core_count;
				min = line_length;
			} else if (core_count == max) {
				// ���� ����� ���� ���
				if (min > line_length) {
					min = line_length;
				}
			}
			return;
		} // ���� ����

		int current_core[] = list.get(idx);
		int r = current_core[0];
		int c = current_core[1];
		int length = 0;

		// 4���� Ž��
		for (int d = 0; d < 4; d++) {
			// d �������� ������ ��������?
			if (isAvailable(r, c, d)) {// ��Ʈ��ŷ
				// ����
				length = connect(r, c, d, 2);
				search(idx + 1, core_count + 1, line_length + length);
				connect(r, c, d, 0); 
			}
		}
		// ���� �ھ ������ ��쿡�� �ھ� ������ �ִ��� ��찡 ���� �� ������
		search(idx + 1, core_count, line_length);

	}

	public static boolean isAvailable(int r, int c, int d) {
		int nr = r;
		int nc = c;

		while (true) {
			nr = nr + dr[d];
			nc = nc + dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				break;

			if (map[nr][nc] >= 1) // �����ϰų� �ھ ������
				return false; // ����
		}
		return true;
	}

	public static int connect(int r, int c, int d, int type) {
		int nr = r;
		int nc = c;
		int count = 0;

		while (true) {
			nr = nr + dr[d];
			nc = nc + dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				break;

			map[nr][nc] = type;
			count++;
		}

		return count;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testcase = 0; testcase < T; testcase++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<int[]>();
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			total_core_count = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					if (map[i][j] == 1 && (i == 0 || j == 0 || i == N - 1 || j == N - 1))
						continue;
					if (map[i][j] == 1) {
						total_core_count++;
						list.add(new int[] { i, j });
					}
				}
			}
			
			search(0, 0, 0);
			System.out.println("#" + (testcase+1) + " " + min);
		}
	}
}
