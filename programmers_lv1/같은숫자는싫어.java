package programmers_lv1;

import java.util.ArrayList;
import java.util.List;

public class 같은숫자는싫어 {
    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int temp = arr[0];
        answer.add(temp);

        for(int i = 1; i < arr.length; i++){
            if(arr[i] != temp){
                temp = arr[i];
                answer.add(temp);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
