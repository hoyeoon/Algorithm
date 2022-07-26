package programmers_lv2;

import java.util.ArrayList;
import java.util.List;

public class 줄서는방법 {

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> input = new ArrayList<>();

        for(int i = 0; i < n; i++){
            input.add(i + 1);
        }

        int val, idx;
        long loc, locCnt, length;

        for(int i = 0; i < n; i++){
            length = getFactorialCount(n - i);
            loc = (k - 1) % length;
            locCnt = length / (n - i);
            idx = (int)(loc / locCnt);
            val = input.get(idx);
            answer[i] = val;
            input.remove(idx);
        }

        return answer;
    }

    private long getFactorialCount(int n){
        long cnt = 1;

        for(int i = 2; i <= n; i++){
            cnt *= i;
        }
        return cnt;
    }
}
