package weeklyChallenge;

/*
 * 프로그래머스 위클리 챌린지 6주차 복서 정렬하기
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/85002
 * 
 */
public class week6 {
	
	public Boxer boxers[]; // 복서들의 정보를 저장할 객체 배열
    public double[] nBoxersWinRate; // 복서들의 승률을 저장할 배열
    public int[] winHeavier;
    public int nBoxers; // 총 복서들의 수
    
    public class Boxer{
        int number, weight, heavier;
        double winRate;
        
        public Boxer(int number, int weight, double winRate, int heavier) {
            this.number = number;
            this.weight = weight;
            this.winRate = winRate;
            this.heavier = heavier;
        }
    }
    
    public int[] solution(int[] weights, String[] head2head) {
        
        
        nBoxers = weights.length;
        boxers = new Boxer[nBoxers];
        nBoxersWinRate = new double[nBoxers];
        winHeavier = new int[nBoxers];
        
        int[] answer = new int[nBoxers];
        
        calcWinRate(weights, head2head);
        
        for(int i = 0; i < nBoxers; i++) {
            boxers[i] = new Boxer(i+1, weights[i], nBoxersWinRate[i], winHeavier[i]);
        }
        
        
        for(int i = 0; i < nBoxers; i++) {
            for(int j = 0; j < nBoxers - i - 1; j++) {
                // 1. 전체 승률이 높은 복서의 번호가 앞쪽으로
                if(boxers[j].winRate < boxers[j+1].winRate) {
                    
                    Swap(j, j+1);
                    
                } else if( boxers[j].winRate == boxers[j+1].winRate) { // 승률이 동일할 경우
                    // 자신보다 몸무게가 무거운 복서를 이긴 횟수가 많은 복서의 번호가 앞쪽으로
                    if(boxers[j].heavier < boxers[j+1].heavier) {
                        Swap(j, j+1);
                    } else if( boxers[j].heavier == boxers[j+1].heavier) { 
                        // 자신보다 몸무게가 무거운 복서를 이긴 횟수가 동일할 경우
                        // 자기 몸무게가 무거운 복서가 앞쪽으로 간다.
                        if(boxers[j].weight < boxers[j+1].weight) {
                            Swap(j, j+1);
                        } else if(boxers[j].weight == boxers[j+1].weight ) {
                            // 자기 몸무게까지 동일할 경우 번호들중에서 작은 번호가 앞으로 간다.
                            if(boxers[j].number > boxers[j+1].number) {
                                Swap(j, j+1);
                            }
                        }
                        
                    }
                }
            }
        }
        for(int i =0; i < nBoxers; i++) {
            answer[i] = boxers[i].number;
        }
        
        
//         System.out.print("\n자신보다 무거운 복서를 이긴 횟수 : ");
//         for(int i =0; i < nBoxers; i++) {
//             System.out.print(winHeavier[i] + " ");
//         }

        
        return answer;
    }
    
    public void Swap(int i, int j) {
        Boxer temp = boxers[j];
        boxers[j] = boxers[i];
        boxers[i] = temp;
    }
    
    public void calcWinRate(int[] weights, String[] head2head) {
        
        // 복서들의 승률을 계산하고, 자기 자신보다 무거운 상대를 이긴 횟수도 같이 카운팅
        
        
        for(int i = 0; i < head2head.length; i++) {
            String str = head2head[i];
            
            int totalGames = 0;
            int win = 0;
            int lose = 0;
            
            for(int j = 0; j < str.length(); j++) {
                
                if(str.charAt(j) == 'N') continue;
                
                if(str.charAt(j) == 'W') {
                    win++;
                    if(weights[i] < weights[j]) winHeavier[i]++; // 자신보다 무거운 복서를 이긴 횟수
                } else if(str.charAt(j) == 'L') {
                    lose++;
                }
                
                totalGames++;
                
            } // inner for end
            
            double winRate = ( (double)win / totalGames) * 100;
            nBoxersWinRate[i] = winRate > 0 ? winRate : 0;
        }
    }
}
