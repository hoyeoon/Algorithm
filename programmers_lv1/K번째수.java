package programmers_lv1;

import java.util.Arrays;

public class K번째수 {
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        
        for(int[] command : commands){
            int i = command[0];
            int j = command[1];
            int k = command[2];
            
            int[] arr = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(arr);
            answer[idx++] = arr[k - 1];
        }
        
        return answer;
    }
}
