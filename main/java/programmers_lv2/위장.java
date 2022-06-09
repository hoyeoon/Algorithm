package programmers_lv2;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for(String[] cloth : clothes){
            map.put(cloth[1], map.containsKey(cloth[1]) ? map.get(cloth[1]) + 1 : 1);
        }
        //System.out.println(map);

        for(String key : map.keySet()){
            answer *= map.get(key) + 1;
        }
        answer--;

        return answer;
    }
}
