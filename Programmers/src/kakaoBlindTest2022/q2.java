package kakaoBlindTest2022;

public class q2 {
	class Solution {
	    
	    public String trans(int n, int k) {
	        
	        String num = "";
	        int temp = n;
	        
	        while(n > 1) {
	            
	            num = "" + (temp%k);
	            temp = temp / k;
	            System.out.println(temp);
	        }

	        return num;
	    }
	    
	    public int solution(int n, int k) {
	        int answer = -1;
	        
	        System.out.println(trans(n,k));
	        
	        return answer;
	    }
	}
	
}
