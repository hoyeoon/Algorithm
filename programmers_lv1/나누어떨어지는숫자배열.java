package programmers_lv1;

import java.util.Arrays;

public class 나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        // 정렬 안하고 싶어서 사용한 TreeSet 방식(조건2: 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다. <- 중복이 없기 때문에 사용 가능)
        // Set<Integer> set = new TreeSet<>();
        // for(int v : arr){
        //     if(v % divisor == 0) set.add(v);
        // }
        // if(set.isEmpty()){
        //     return new int[]{-1};
        // }
        // return set.stream().mapToInt(Integer::intValue).toArray();

        int[] answer = Arrays.stream(arr).filter(v -> v % divisor == 0).toArray();
        if(answer.length == 0) return new int[]{-1};

        Arrays.sort(answer);
        return answer;
    }
}
