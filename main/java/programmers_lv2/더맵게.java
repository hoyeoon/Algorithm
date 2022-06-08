package programmers_lv2;

import java.util.PriorityQueue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        int answer = -1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int value : scoville){
            minHeap.add(value);
        }

        while(minHeap.size() >= 2){
            int scobill1 = minHeap.poll();
            int scobill2 = minHeap.poll();

            if(scobill1 >= K) {
                answer = cnt;
                break;
            }

            minHeap.add(scobill1 + scobill2 * 2);
            cnt++;
        }

        if(!minHeap.isEmpty() && minHeap.poll() >= K) {
            answer = cnt;
        }

        return answer;
    }
}
