package d3;

import java.io.*;

public class SWEA15612_ü�������Ƿ��ġ {

	private static int N = 8;
	private static String[][] map;
	private static String answer;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	private static boolean isAvailable(int r, int c, int dir) {
		int nr = r;
		int nc = c;

		while (true) {
			nr = nr + dx[dir];
			nc = nc + dy[dir];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				break;

			if (map[nr][nc].equals("O"))
				return false;
		}
		return true;
	}

	private static boolean search(int r, int c) {

		int count = 0;

		for (int d = 0; d < 4; d++) {

			if (isAvailable(r, c, d)) {
				// ���� �� Ȥ�� �࿡ ���� ���� -> �� ��ġ ����
				count++;
			}
		}

		return count == 4;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			map = new String[N][N];
			int Rook = 0; // Rook�� ������ ī��Ʈ�� ����
			answer = "no";

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().split("");
			}

			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j].equals("O")) {
						if(search(i,j)) {
							Rook++;
						}
					}
				}
			}
		
			answer = Rook == 8 ? "yes" : "no";

			System.out.printf("#%d %s\n", test_case, answer);
		}
	}
}
