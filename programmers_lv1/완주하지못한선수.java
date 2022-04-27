package programmers_lv1;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
	static String answer = "";
    
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> hm = new HashMap<>();
        
        for(String p : participant){
            hm.put(p, hm.getOrDefault(p, 0) + 1);
        }
        
        for(String c : completion){
            hm.put(c, hm.get(c) - 1);
        }

        hm.forEach((key, value) -> {
            if(value != 0) {
                answer = key;
            }
        });
        
        return answer;
    }
}
