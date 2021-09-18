package weeklyChallenge;

/*
 * ���α׷��ӽ� ��Ŭ�� ç���� 6���� ���� �����ϱ�
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/85002
 * 
 */
public class week6 {
	
	public Boxer boxers[]; // �������� ������ ������ ��ü �迭
    public double[] nBoxersWinRate; // �������� �·��� ������ �迭
    public int[] winHeavier;
    public int nBoxers; // �� �������� ��
    
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
                // 1. ��ü �·��� ���� ������ ��ȣ�� ��������
                if(boxers[j].winRate < boxers[j+1].winRate) {
                    
                    Swap(j, j+1);
                    
                } else if( boxers[j].winRate == boxers[j+1].winRate) { // �·��� ������ ���
                    // �ڽź��� �����԰� ���ſ� ������ �̱� Ƚ���� ���� ������ ��ȣ�� ��������
                    if(boxers[j].heavier < boxers[j+1].heavier) {
                        Swap(j, j+1);
                    } else if( boxers[j].heavier == boxers[j+1].heavier) { 
                        // �ڽź��� �����԰� ���ſ� ������ �̱� Ƚ���� ������ ���
                        // �ڱ� �����԰� ���ſ� ������ �������� ����.
                        if(boxers[j].weight < boxers[j+1].weight) {
                            Swap(j, j+1);
                        } else if(boxers[j].weight == boxers[j+1].weight ) {
                            // �ڱ� �����Ա��� ������ ��� ��ȣ���߿��� ���� ��ȣ�� ������ ����.
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
        
        
//         System.out.print("\n�ڽź��� ���ſ� ������ �̱� Ƚ�� : ");
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
        
        // �������� �·��� ����ϰ�, �ڱ� �ڽź��� ���ſ� ��븦 �̱� Ƚ���� ���� ī����
        
        
        for(int i = 0; i < head2head.length; i++) {
            String str = head2head[i];
            
            int totalGames = 0;
            int win = 0;
            int lose = 0;
            
            for(int j = 0; j < str.length(); j++) {
                
                if(str.charAt(j) == 'N') continue;
                
                if(str.charAt(j) == 'W') {
                    win++;
                    if(weights[i] < weights[j]) winHeavier[i]++; // �ڽź��� ���ſ� ������ �̱� Ƚ��
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
