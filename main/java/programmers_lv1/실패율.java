package programmers_lv1;

import java.util.*;
import java.util.stream.Collectors;

public class 실패율 {
    public int[] solution(int N, int[] stages) {
        int stage_length = stages.length;
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Double> map = new HashMap<>();
        List<Integer> stage_list = Arrays
                .stream(stages)
                .boxed()
                .collect(Collectors.toList());

        //System.out.println(stage_list);

        for(int n = 1; n <= N; n++){
            int frequency = Collections.frequency(stage_list, n);
            //System.out.print((double)frequency / stage_length + ", ");
            if(stage_length != 0){
                map.put(n, (double)frequency / stage_length);
            }else {
                map.put(n, (double)0);
            }
            stage_length -= frequency;
        }
        //System.out.println(map);

        map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> {
                    answer.add(entry.getKey());
                });

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
