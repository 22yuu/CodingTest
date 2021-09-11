package kakaoBlindTest2022;
import java.util.*;

public class q1 {


	class Solution {
	    public int[] solution(String[] id_list, String[] report, int k) {
	        int nPeople = id_list.length;
	        int[] answer = new int[nPeople];
	        List<String> isReported = new ArrayList<>();
	        int[][] log = new int[nPeople][nPeople];
	        
	        StringTokenizer st;
	        
	        HashMap<String, Integer> hm_reported = new HashMap<>();
	        
	        
	        for(int i = 0; i < nPeople; i++) {
	            hm_reported.put(id_list[i], 0);
	        }
	        
	        for(int i = 0; i < nPeople; i++) {
	           
	            if(!isReported.contains(isReported)) { // ����Ʈ �߰����� �ʾҴٸ� 
	                isReported.add(report[i]); // �߰�
	            } else {
	                continue; // ����Ʈ�� ���� ��� -> �̹� �Ű���
	            }
	            
	            st = new StringTokenizer(report[i]);
	            
	            String reporter = st.nextToken();
	            String reported = st.nextToken();
	            
	            hm_reported.put(reported, hm_reported.get(reported) + 1); // �Ű� ���� ī��Ʈ
	            //System.out.println("�Ű��� : " + reporter + ", " + Arrays.asList(id_list).indexOf(reporter));
	            int reporterIdx = Arrays.asList(id_list).indexOf(reporter);
	            int reportedIdx = Arrays.asList(id_list).indexOf(reported);
	            
	            log[reporterIdx][reportedIdx]++;
	        }
	        
	        for(int i = 0; i < nPeople; i++) {
	            int result = 0;
	            for(int j = 0; j < nPeople; j++) {
	                //System.out.print(log[i][j] + " ");
	                if(log[i][j] == 1) {
	                    result++;
	                }
	            }
	            //System.out.println();
	            answer[i] = result;
	        }
	        
	        
	        return answer;
	    }
	}
}
