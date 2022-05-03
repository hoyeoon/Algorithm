package programmers_lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 타겟넘버 {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int size = numbers.length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while(!q.isEmpty()){
            int[] infos = q.poll();
            int value = infos[0];
            int count = infos[1];

            // System.out.println(value + ", " + count);

            if(count > size - 1) {
                if(value == target) answer++;
                continue;
            }

            q.offer(new int[]{value + numbers[count], count + 1});
            q.offer(new int[]{value - numbers[count], count + 1});
        }

        return answer;
    }
}
