package weeklyChallenge;



public class week1 {
	
	static class Solution {
	    public long solution(int price, int money, int count) {
	        long answer = -1;
	        long totalPrice = price;
	        
	        for(int i = 2; i <= count; i++) {
	            totalPrice += price * i;
	        }
	        
	        if(totalPrice < money) {
	            return 0;
	        } else {
	            return totalPrice - money;
	        }
	    }
	}
	

	public static void main(String[] args) {
		Solution sol = new Solution();
		
		System.out.println(sol.solution(3, 20, 4));
	}
}
