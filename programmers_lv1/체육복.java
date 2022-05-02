package programmers_lv1;

import java.util.Arrays;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]) {
                    lost[i] = Integer.MAX_VALUE;
                    reserve[j] = Integer.MAX_VALUE;
                    answer++;
                }
            }
        }

        System.out.println(Arrays.toString(lost));
        System.out.println(Arrays.toString(reserve));

        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(Math.abs(lost[i] - reserve[j]) == 1){
                    System.out.print(reserve[j] + ", ");
                    answer++;
                    reserve[j] = Integer.MAX_VALUE;
                    break;
                }
            }
        }

        return answer;
    }
}
