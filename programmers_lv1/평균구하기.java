package programmers_lv1;

import java.util.Arrays;

public class 평균구하기 {
    public double solution(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }
}
