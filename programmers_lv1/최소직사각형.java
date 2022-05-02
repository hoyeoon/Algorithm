package programmers_lv1;

import java.util.Arrays;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int answer = 0;
        int i = 0;
        int[] max_arr = new int[sizes.length];
        int[] min_arr = new int[sizes.length];

        for(int[] size : sizes){
            if(size[0] > size[1]){
                max_arr[i] = size[0];
                min_arr[i] = size[1];
            } else{
                max_arr[i] = size[1];
                min_arr[i] = size[0];
            }
            i++;
        }
        System.out.println(Arrays.toString(min_arr));
        System.out.println(Arrays.toString(max_arr));
        answer = Arrays.stream(min_arr).max().getAsInt() * Arrays.stream(max_arr).max().getAsInt();

        return answer;
    }
}
