package programmers_lv2;

import java.util.ArrayList;
import java.util.List;

public class 하노이의탑 {
    List<Integer> list = new ArrayList<>();

    public int[][] solution(int n) {
        Hanoi(n, 1, 2, 3);

        int[][] answer = new int[list.size() / 2][2];

        for(int i = 0; i < list.size() / 2; i++){
            answer[i][0] = list.get(i * 2);
            answer[i][1] = list.get(i * 2 + 1);
        }

        return answer;
    }

    private void Hanoi(int n, int start, int mid, int end){
        if(n == 1){
            list.add(start);
            list.add(end);
            return;
        }

        Hanoi(n - 1, start, end, mid);

        list.add(start);
        list.add(end);

        Hanoi(n - 1, mid, start, end);
    }
}
