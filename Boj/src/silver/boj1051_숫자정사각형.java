package silver;

import java.util.*;
import java.io.*;

public class boj1051_�������簢�� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N, M;
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] board = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}
	    // 1. ��� ��(i), ��(j)�� �������� ���� ����(k+1)��ŭ ������ 3��ǥ���� ���Ͽ�, ��� ���� ���̸� �ִ� ���� ���� ��������.
		int answer = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 1; i + k < N && j + k < M; k++) { 
	                if (board[i][j] == board[i + k][j] && board[i][j] == board[i][j + k]  && board[i][j] == board[i + k][j + k]) {
	                    if ( (k + 1) * (k + 1) > answer) {
	                        answer = (k + 1) * (k + 1) ;	                    	
	                    }
	                }
				}
			}
		}
			    
	    System.out.println(answer);		

	}

}
