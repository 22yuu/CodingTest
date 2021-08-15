package d3;

import java.util.*;
import java.io.*;

public class SW1216_회문2 {
	
	public static int size = 100;
	public static char map[][];
	public static int max;
	
	public static void Palindrome(int idx) {
		
		if(idx == size) return;
		
		for(int i = 0; i < size; i++) {
			SearchWidth(idx, i, "");
			SearchHeight(idx, i, "");
		}
		
		Palindrome(idx+1);
	}
	
	public static boolean isPalindrome(String str) {
		
		StringBuilder sb = new StringBuilder(str);
		String reverse = sb.reverse().toString();
		
		if(str.equals(reverse)) {
			return true;
		} else {
			return false;	
		}
	}
	
	public static void SearchWidth(int idx, int iter,  String str) {
		
		if(iter == size) return;
		
		str += Character.toString(map[idx][iter]);
		
		if(isPalindrome(str)) {
			if(str.length() > max) max = str.length();
		}
		SearchWidth(idx, iter+1, str);
	}
	
	public static void SearchHeight(int idx, int iter, String str) {
		
		if(iter == size) return;
		
		str += Character.toString(map[iter][idx]);
		
		if(isPalindrome(str)) {
			if(str.length() > max) max = str.length();
		}
		
		SearchHeight(idx, iter+1, str);
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[size][size];
		
		for(int testcase = 1; testcase <= 10; testcase++) {
			
			int T = Integer.parseInt(br.readLine());
			max = Integer.MIN_VALUE;
			
			for(int i = 0; i < size; i++) {
				String str = br.readLine();
				for(int j = 0; j < size; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			Palindrome(0);
			
			System.out.println("#" + testcase + " " + max);
		}
	}
}

// 다른 사람 풀이 강인혁님 코드
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
// 
//public class Solution {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        char arr[][] = new char [100][100];
//        for(int i =1; i<11; i++) {
//            br.readLine();
//            int max = 0;
//            int count = 0;
//            for(int j=0; j<100; j++) {
//                arr[j] = br.readLine().toCharArray();
//            }
//             
//            for(int j=0; j<100; j++) {
//                for(int k=0; k<99; k++) {
//                int left = k;
//                int right = k+1;
//                 
//                if(arr[j][left] == arr[j][right]) {
//                    count = 0;
//                    while(true) {
//                        if(left < 0 || right >= 100) {
//                            break;
//                        }
//                        else if(arr[j][left] == arr[j][right]) {
//                            count += 2;
//                            left--;
//                            right++;
//                        }
//                        else {
//                            break;
//                        }
//                    }
//                    max = Math.max(max, count);
//                }
//                 
//                else {
//                    count = 1;
//                    right++;
//                    while(true) {
//                        if(left < 0 || right >= 100) {
//                            break;
//                        }
//                        else if(arr[j][left] == arr[j][right]) {
//                            count += 2;
//                            left--;
//                            right++;
//                        }
//                        else {
//                            break;
//                        }
//                    }
//                    max = Math.max(max, count);
//                }
//                }
//            }
//             
//            for(int j=0; j<100; j++) {
//                for(int k=0; k<99; k++) {
//                int left = k;
//                int right = k+1;
//                 
//                if(arr[left][j] == arr[right][j]) {
//                    count = 0;
//                    while(true) {
//                        if(left < 0 || right >= 100) {
//                            break;
//                        }
//                        else if(arr[left][j] == arr[right][j]) {
//                            count += 2;
//                            left--;
//                            right++;
//                        }
//                        else {
//                            break;
//                        }
//                    }
//                    max = Math.max(max, count);
//                }
//                 
//                else {
//                    count = 1;
//                    right++;
//                    while(true) {
//                        if(left < 0 || right >= 100) {
//                            break;
//                        }
//                        else if(arr[left][j] == arr[right][j]) {
//                            count += 2;
//                            left--;
//                            right++;
//                        }
//                        else {
//                            break;
//                        }
//                    }
//                    max = Math.max(max, count);
//                }
//                }
//            }
//            System.out.println("#" + i + " " + max);
//        }
//    }
//}