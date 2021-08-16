package lv2;

import java.util.*;

class Position {
	    int x, y;
	    
	    public Position(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	}

class Keypad {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        String finger = hand.equals("right")? "R" : "L";
        Position lf = new Position(3,0); // 왼쪽 엄지 손가락
        Position rf = new Position(3,2); // 오른쪽 엄지 손가락

        /*  0 1 2
          0 1 2 3
          1 4 5 6
          2 7 8 9
          3 * 0 #
        */

        for(int num: numbers) {

            // 1, 4, 7 왼쪽 엄지 손가락을 사용
            if(num == 1 || num == 4 || num == 7) {
                answer += "L";
                if( num == 1) {
                    lf.x = 0;
                    lf.y = 0;
                } else if (num == 4) {
                    lf.x = 1;
                    lf.y = 0;
                } else { // num 7
                    lf.x = 2;
                    lf.y = 0;
                }
            } else if(num == 3 || num == 6 || num == 9) {
                answer += "R";
                if(num == 3) {
                    rf.x = 0;
                    rf.y = 2;
                } else if(num == 6) {
                    rf.x= 1;
                    rf.y = 2;
                } else { // num 9
                    rf.x=2;
                    rf.y=2;
                }

            } else {

                int left_dist = 0;
                int right_dist = 0;
                int x = 0;
                int y = 0;

                // System.out.println("lf.x : " + lf.x + ", lf.y : " + lf.y);
                // System.out.println("rf.x : " + rf.x + ", rf.y : " + rf.y);

                if(num == 2) {
                    x = 0;
                    y = 1;

                    left_dist = Math.abs(lf.x - x) + Math.abs(lf.y - y);
                    right_dist = Math.abs(rf.x - x) + Math.abs(rf.y - y);

                    // System.out.println("l_dist : " + left_dist + ", r_dist : " +right_dist);

                    if(left_dist < right_dist) {
                        answer += "L";
                        lf.x = x;
                        lf.y = y;
                    } else if (left_dist == right_dist) {
                        answer += finger;

                        if(finger.equals("R")) {
                            rf.x=x;
                            rf.y=y;
                        } else {
                            lf.x=x;
                            lf.y=y;
                        }

                    } else {
                        answer += "R";
                        rf.x = x;
                        rf.y = y;
                    }

                } else if(num == 5) {
                    x = 1;
                    y = 1;

                    left_dist = Math.abs(lf.x - x) + Math.abs(lf.y - y);
                    right_dist = Math.abs(rf.x - x) + Math.abs(rf.y - y);
                    // System.out.println(num + "] l_dist : " + left_dist + ", r_dist : " +right_dist);

                    if(left_dist < right_dist) {
                        answer += "L";
                        lf.x = x;
                        lf.y = y;

                    } else if (left_dist == right_dist) {
                        answer += finger;

                        if(finger.equals("R")) {
                            rf.x=x;
                            rf.y=y;
                        } else {
                            lf.x=x;
                            lf.y=y;
                        }
                    } else {
                        answer += "R";
                        rf.x=x;
                        rf.y=y;
                    }

                } else if (num== 8) {
                    x = 2;
                    y = 1;


                    left_dist = Math.abs(lf.x - x) + Math.abs(lf.y - y);
                    right_dist = Math.abs(rf.x - x) + Math.abs(rf.y - y);

                    // System.out.println(num + "] l_dist : " + left_dist + ", r_dist : " +right_dist);

                    if(left_dist < right_dist) {
                        answer += "L";
                        lf.x=x;
                        lf.y=y;
                    } else if (left_dist == right_dist) {
                        answer += finger;

                        if(finger.equals("R")) {
                            rf.x=x;
                            rf.y=y;
                        } else {
                            lf.x=x;
                            lf.y=y;
                        }
                    } else {
                        answer += "R";
                        rf.x=x;
                        rf.y=y;
                    }

                } else { // num = 0
                    x = 3;
                    y = 1;

                    left_dist = Math.abs(lf.x - x) + Math.abs(lf.y - y);
                    right_dist = Math.abs(rf.x - x) + Math.abs(rf.y - y);

                    // System.out.println(num + "] l_dist : " + left_dist + ", r_dist : " +right_dist);

                    if(left_dist < right_dist) {
                        answer += "L";
                        lf.x=x;
                        lf.y=y;

                    } else if (left_dist == right_dist) {
                        answer += finger;

                        if(finger.equals("R")) {
                            rf.x=x;
                            rf.y=y;
                        } else {
                            lf.x=x;
                            lf.y=y;
                        }
                    } else {
                        answer += "R";

                        rf.x=x;
                        rf.y=y;
                    }
                }


            }
        }
        return answer;
    }
}

public class 키패드누르기 {
	
	
	public static void main(String[] args) {
		
	}

}
