package programmers_lv2;

import java.util.Arrays;

public class 큰수만들기 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int[] arr = Arrays.stream(number.split("")).mapToInt(Integer::parseInt).toArray();
        int startIdx = 0;
        int lastIdx = k;

        while(true){
            if(lastIdx == number.length()) break;

            int max_value = Integer.MIN_VALUE;
            int max_idx = 0;

            for(int i = startIdx; i <= lastIdx; i++){
                if(max_value == 9) break;

                if(max_value < arr[i]){
                    max_value = arr[i];
                    max_idx = i;
                }
            }
            sb.append(max_value);
            lastIdx++;
            startIdx = max_idx + 1;
        }

        return sb.toString();
    }
}
