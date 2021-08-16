package d3;

import java.util.Scanner;

public class SW1289_�޸𸮺��� {
	static int cnt; // ���� Ƚ�� ī��Ʈ ����
	 
    public static void restore(String origin) {
         
        int buffer_size = origin.length();
        int[] buffer = new int[buffer_size]; // �ʱⰪ 0
        int temp = 0;
         
        String restore_result = "";
         
        for (int i = 0; i < origin.length(); i++) {
            char ch = origin.charAt(i);
            temp = ch - '0'; // ����ȭ
 
             
            if(buffer[i] != temp) {
                if(temp == 1) {
                    for(int j = i; j < buffer.length; j++) {
                         buffer[j] = 1;
                    }
                    cnt++;
                } 
                else { 
                    for(int j = i; j < buffer.length; j++) {
                        buffer[j] = 0;
                    }
                    cnt++;
                }
            }
        }
         
        // buffer �迭 -> String
        for (int k = 0; k < buffer.length; k++) {
            restore_result =  restore_result + Integer.toString(buffer[k]);
        }
         
        // ���� �޸� ���� ��
        if(origin.equals(restore_result)) {return; } else {restore(restore_result);}
    }
    public static void main(String args[]) throws Exception {
 
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            cnt = 0;
            String origin_memory = sc.next();
            restore(origin_memory);
            System.out.println("#" + test_case + " " + cnt);
        }
    }
}
