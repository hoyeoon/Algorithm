package programmers_lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 모의고사 {
	 public int[] solution(int[] answers) {
	        int[] supo1 = {1, 2, 3, 4, 5};
	        int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
	        int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
	        int supo1_len = supo1.length;
	        int supo2_len = supo2.length;
	        int supo3_len = supo3.length;
	        Map<Integer, Integer> hm = new HashMap<>();
	        
	        for(int i = 0; i < answers.length; i++){
	            if(supo1[i % supo1_len] == answers[i]){
	                hm.put(1, hm.getOrDefault(1, 0) + 1);
	            }
	            if(supo2[i % supo2_len] == answers[i]){
	                hm.put(2, hm.getOrDefault(2, 0) + 1);
	            }
	            if(supo3[i % supo3_len] == answers[i]){
	                hm.put(3, hm.getOrDefault(3, 0) + 1);
	            }
	        }
	        System.out.println(hm);
	        
	        // HashMap 값 기준으로 정렬
//	         List<Integer> listKeySet = new ArrayList<>(hm.keySet());
	        
	        // 오름차순
//	          Collections.sort(listKeySet, (v1, v2) -> (hm.get(v1).compareTo(hm.get(v2))));
	        // 내림차순
//	          Collections.sort(listKeySet, (v1, v2) -> (hm.get(v2).compareTo(hm.get(v1))));
	        
//	          System.out.println(listKeySet);
//	          return listKeySet.stream().mapToInt(Integer::intValue).toArray();
	        
	        // Max Value
	        int maxValue = Collections.max(hm.values());
	        System.out.println(maxValue);
	        
	        // value로 Key 찾기
	        List<Integer> list = new ArrayList<>();
	        
	        for(Integer key : hm.keySet()){
	            if(hm.get(key) == maxValue){
	                list.add(key);
	            }
	        }
	        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
	        Arrays.sort(answer);
	        return answer;
	    }
}
