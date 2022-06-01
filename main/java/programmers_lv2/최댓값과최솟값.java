package programmers_lv2;

import java.util.Arrays;

public class 최댓값과최솟값 {
    public String solution(String s) {
        String answer = "";
        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        answer = min + " " + max;

        return answer;
    }
}
