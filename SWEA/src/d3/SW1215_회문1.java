package d3;

import java.util.*;
import java.io.*;;
 
public class SW1215_회문1 {
 
    static int mapSize = 8;
    static char map[][];
    static int wordLength;
    static List<Character> list;
    static List<Character> reverseList;
    static int answer;
 
    public static void Palindrome() {
 
        // 가로 먼저 검사
        for (int h = 0; h < mapSize; h++) {
            for (int i = 0; i <= (mapSize - wordLength); i++) {
                for (int j = i; j < (i + wordLength); j++) {
                    list.add(map[h][j]);
                    reverseList.add(map[h][j]);
                }
                Collections.reverse(reverseList);
 
                if (isAccord())
                    answer++;
                list.clear();
                reverseList.clear();
            }
        }
 
        // 세로 검사
        for (int w = 0; w < mapSize; w++) {
            for (int i = 0; i <= (mapSize - wordLength); i++) {
                for (int j = i; j < (i + wordLength); j++) {
                    list.add(map[j][w]);
                    reverseList.add(map[j][w]);
                }
                Collections.reverse(reverseList);
 
                if (isAccord())
                    answer++;
                list.clear();
                reverseList.clear();
            }
        }
    }
 
    public static boolean isAccord() {
 
        int len = list.size();
        int count = 0;
 
        for (int i = 0; i < len; i++) {
            if (list.get(i) == reverseList.get(i))
                count++;
        }
 
        return count == len ? true : false;
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = 10;
 
        for (int testcase = 1; testcase <= T; testcase++) {
 
            list = new ArrayList<>();
            reverseList = new ArrayList<>();
            answer = 0;
 
            wordLength = Integer.parseInt(br.readLine());
            map = new char[mapSize][mapSize];
 
            for (int i = 0; i < mapSize; i++) {
                String str = br.readLine();
                for (int j = 0; j < mapSize; j++) {
                    map[i][j] = str.charAt(j);
                }
            } // input for
 
            Palindrome();
 
            System.out.println("#" + testcase + " " + answer);
 
        } // testcase end
    } // main
} // main class