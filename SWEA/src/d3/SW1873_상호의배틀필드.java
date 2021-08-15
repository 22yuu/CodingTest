package d3;

import java.util.*;
import java.io.*;

public class SW1873_상호의배틀필드 {

	public static char map[][];
	public static boolean visited[][];

	public static int H;
	public static int W;
	public static int N;
	public static String input_str;
	public static char command[];

	public static int dr[] = { -1, 1, 0, 0 };
	public static int dc[] = { 0, 0, -1, 1 };

	public static Tank tank;

	public static class Tank {
		int r, c, d;

		public Tank(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	public static void Play(int idx, int r, int c, int direction) {

		if (idx == N) {
			tank = new Tank(r,c,direction);
			return;
		}

		tank = new Tank(r, c, direction);

		// 명령 파악
		char com = command[idx];

		if (com == 'S') {
			Shooting(r, c, direction);
			Play(idx + 1, r, c, direction);
		} else if (com == 'U') {
			if (Move(r, c, 0)) { // 위로 갈 수 있나?
				// 갈 수 있다
				map[r][c] = '.';
				Play(idx + 1, r + dr[0], c + dc[0], 0);
			} else {
				Play(idx + 1, r, c, 0); // 갈 수 없다면 다음 명령어 실행
			}

		} else if (com == 'D') {

			if (Move(r, c, 1)) { // 아래로 갈 수 있나?
				// 갈 수 있다
				map[r][c] = '.';
				Play(idx + 1, r + dr[1], c + dc[1], 1);
			} else {
				Play(idx + 1, r, c, 1); // 갈 수 없다면 다음 명령어 실행
			}

		} else if (com == 'L') {

			if (Move(r, c, 2)) { // 왼쪽(좌)으로 갈 수 있나?
				// 갈 수 있다
				map[r][c] = '.';
				Play(idx + 1, r + dr[2], c + dc[2], 2);
			} else {
				Play(idx + 1, r, c, 2); // 갈 수 없다면 다음 명령어 실행
			}

		} else if (com == 'R') {

			if (Move(r, c, 3)) { // 오른쪽(우)으로 갈 수 있나?
				// 갈 수 있다
				map[r][c] = '.';
				Play(idx + 1, r + dr[3], c + dc[3], 3);
			} else {
				Play(idx + 1, r, c, 3); // 갈 수 없다면 다음 명령어 실행
			}
		}
	}

	public static void Shooting(int r, int c, int d) {
		int nr = r + dr[d];
		int nc = c + dc[d];

		// 포탄이 맵 밖으로 나갔을 경우
		if (nr < 0 || nc < 0 || nr >= H || nc >= W)
			return; // 포탄 소멸

		if (map[nr][nc] == '#') {// 강철로 만들어진 벽
			return; // 포탄 소멸
		} else if (map[nr][nc] == '*') { // 벽돌로 만들어진 벽
			map[nr][nc] = '.'; // 부수고 평지로
			return; // 포탄 소멸
		}

		Shooting(nr, nc, d); // 앞에 장애물이 없으면 포탄은 계속 날아간다.
	}

	public static boolean Move(int r, int c, int d) {
		int nr = r + dr[d];
		int nc = c + dc[d];

		if (nr < 0 || nc < 0 || nr >= H || nc >= W)
			return false; // 맵 벗어남

		if (map[nr][nc] == '.') {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new char[H][W];
			visited = new boolean[H][W];

			int r = 0;
			int c = 0;
			int d = 0;

			for (int h = 0; h < H; h++) {
				String str = br.readLine();
				for (int w = 0; w < W; w++) {
					char ch = str.charAt(w);
					map[h][w] = ch;
					
					if(ch == '<') {
						d = 0;
					} else if(ch == '>') {
						d = 1;
					} else if(ch == '^') {
						d = 2;
					} else {
						d = 3;
					}// 순서대로 상하좌우 전차가 바라보는 방향
					
					r = h;
					c = w;
				}
			} // input data to array

			N = Integer.parseInt(br.readLine());
			input_str = br.readLine();
			command = input_str.toCharArray();
			// input done...

			Play(0, r, c, d);

			int tankDirection = tank.d;

			if (tankDirection == 0)
				map[tank.r][tank.c] = '^';
			else if (tankDirection == 1)
				map[tank.r][tank.c] = 'v';
			else if (tankDirection == 2)
				map[tank.r][tank.c] = '<';
			else
				map[tank.r][tank.c] = '>';

			System.out.print("#" + testcase + " ");

			for (int h = 0; h < H; h++) {
				for (int w = 0; w < W; w++) {
					System.out.print(map[h][w]);
				}
				System.out.println();
			} // input data to array
		}
	}
}