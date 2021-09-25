package lv2;

import java.util.*;

//https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%94%84%EB%A0%8C%EC%A6%884%EB%B8%94%EB%A1%9D-Java

public class «¡∑ª¡Ó∫Ì∑œ2 {
	
	public static int solution(int m, int n, String[] board) {
		int answer = 0;
		char[][] map = new char[m][n];
		
		for(int i = 0; i < m; i++) {
			map[i] = board[i].toCharArray();
		}
		
		while(true) {
			int cnt = checkBlock(m, n, map);
			if(cnt == 0) break;
			answer += cnt;
			dropBlock(m, n, map);
			//print(m, n, map);
		}
		
		return answer;
	}
	
	private static void dropBlock(int m, int n, char[][] map) {
		for(int c = 0; c < n; c++) {
			for(int r = m - 1; r >= 0; r--) {
				if(map[r][c] == '.') {
					for(int nr = r - 1; nr >= 0; nr--) {
						if(map[nr][c] != '.') {
							map[r][c] = map[nr][c];
							map[nr][c] = '.';
							break;
						}
					}
				}
			}
		}
	}
	
	private static int checkBlock(int m, int n, char[][] map) {
		int cnt = 0;
		boolean[][] isChecked = new boolean[m][n];
		
		for(int i = 0; i < m - 1; i++) {
			for(int j = 0; j < n - 1; j++) {
				if(map[i][j] == '.') continue;
				checkFour(map, isChecked, i, j);
			}
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(isChecked[i][j]) {
					cnt++;
					map[i][j] = '.';
				}
			}
		}
		
		return cnt;
	}

	
	private static void checkFour(char[][] map, boolean[][] isChecked, int i, int j) {
		char block = map[i][j];
		
		for(int r = i; r < i + 2; r++) {
			for(int c = j; c < j + 2; c++) {
				if(map[r][c] != block) return;
			}
		}
		
		for(int r = i; r < i + 2; r++) {
			for(int c = j; c < j + 2; c++) {
				isChecked[r][c] = true;
			}
		}
	}
	
    public static void main(String[] args) {
    	String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
    	String[] board2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
    	
    	System.out.println(solution(4, 5, board));
    	System.out.println(solution(6, 6, board2));
	}
    
    public static void print(int m, int n, char[][] map) {
        for(int i = 0; i < m; i++) {    
            for(int j = 0; j < n; j++) {    
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
