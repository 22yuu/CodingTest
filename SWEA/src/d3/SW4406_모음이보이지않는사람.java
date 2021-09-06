package d3;

import java.util.*;
import java.io.*;

public class SW4406_모음이보이지않는사람 {
	
	public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String input = sc.next();
             
            input = input.replaceAll("a", "");
            input = input.replaceAll("e", "");
            input = input.replaceAll("i", "");
            input = input.replaceAll("o", "");
            input = input.replaceAll("u", "");
             
            System.out.println("#" + test_case + " " + input);
        }
    }
}
