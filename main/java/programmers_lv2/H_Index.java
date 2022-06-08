package programmers_lv2;

import java.util.Arrays;
import java.util.Collections;

public class H_Index {
    public int solution(int[] citations) {
        int answer = citations.length;
        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());

        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= i){
                answer = i;
                break;
            }
        }

        return answer;
    }
}
