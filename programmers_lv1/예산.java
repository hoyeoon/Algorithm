package programmers_lv1;

import java.util.Arrays;

public class 예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int i = 0; i < d.length; i++){
            if(budget - d[i] < 0){
                break;
            }
            budget -= d[i];
            answer++;
        }
        System.out.println(Arrays.toString(d));
        return answer;
    }
}
