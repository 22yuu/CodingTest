package lv2;

import java.util.*;

public class 방금그곡 {
	
	/*
	 * 1차 시도 실수 answer 초기값 설정 안함 "(None)"
	 * 
	 * */
	
    private HashMap<String, String> hm = new HashMap<>();
    private StringBuilder sb;
    
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        // pattern 해시맵에 저장
        for(String str : musicinfos) {
           sb = new StringBuilder();
            String[] splited = str.split(",");
            
            String start = splited[0];
            String end = splited[1];
            String title = splited[2];
            String pattern = splited[3];
            
            // 총 플레이 타임을 구하기 위해 시, 분 나눔
            String[] splitedStartTime = start.split(":");
            int start_hh = Integer.parseInt(splitedStartTime[0]) * 60;
            int start_mm = Integer.parseInt(splitedStartTime[1]);
            int startTime = start_hh + start_mm;
            
            String[] splitedEndTime = end.split(":");
            int end_hh = Integer.parseInt(splitedEndTime[0]) * 60;
            int end_mm = Integer.parseInt(splitedEndTime[1]);
            int endTime = end_hh + end_mm;

            int totalPlayTime = endTime - startTime;
            
            for(int i = 0; i < totalPlayTime; i++) {
                sb.append(pattern);
            }
            
            hm.put(title, sb.toString());
        }
        
        for(String key : hm.keySet()) {
            // System.out.println()
            if(hm.get(key).contains(m)) answer = key;
        }
        
        return answer;
    }
}
