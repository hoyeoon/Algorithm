package programmers_lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 신고결과받기 {
	public int[] solution(String[] id_list, String[] report, int k) {
        report = Arrays.stream(report).distinct().toArray(String[]::new);   // 중복제거
        int[] answer = new int[id_list.length];
        Map<String, Integer> cntId = new HashMap<>();
        Map<String, Integer> cntAns = new HashMap<>();
        
        // 신고당한 횟수 세기
        for(int i = 0; i < report.length; i++){
            String to = report[i].split(" ")[1];            
            cntId.put(to, cntId.getOrDefault(to, 0) + 1);
        }
        System.out.println(cntId);
        
        // 정지된 ID 세기
        for(int i = 0; i < report.length; i++){
            String[] temp = report[i].split(" ");
            String from = temp[0];
            String to = temp[1];
            
            if(cntId.get(to) >= k){
                cntAns.put(from, cntAns.getOrDefault(from, 0) + 1);
            }
        }
        System.out.println(cntAns);
        
        for(int i = 0; i < id_list.length; i++){
            if(cntAns.get(id_list[i]) != null)
                answer[i] = cntAns.get(id_list[i]);
        }        
        return answer;
    }
}
