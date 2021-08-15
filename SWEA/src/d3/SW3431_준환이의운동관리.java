package d3;

import java.util.*;
import java.io.*;
 
public class SW3431_준환이의운동관리 {
 
    static int L, U, X;
     
    public static int Check(int l, int u, int x) {
         
        if(x > u) return -1;
        if(x >= l && x <= u) return 0;
         
        return l - x;       
    }
     
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
         
        for(int testcase = 1; testcase <= T; testcase++) {
            st = new StringTokenizer(br.readLine());
             
            L = Integer.parseInt(st.nextToken());
            U = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
             
            System.out.println("#"+testcase+" "+Check(L,U,X));
        }
    }
}