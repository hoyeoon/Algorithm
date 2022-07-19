package programmers_lv2;
import java.util.*;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(String operation : operations){
            String[] str = operation.split(" ");
            String command = str[0];
            int num = Integer.parseInt(str[1]);

            if("I".equals(command)){
                minHeap.add(num);
                maxHeap.add(num);
                continue;
            }

            if(Objects.isNull(minHeap.peek())){
                continue;
            }

            int maxValue = maxHeap.peek();
            if(num == 1){
                minHeap.remove(maxValue);
                maxHeap.remove(maxValue);
                continue;
            }

            int minValue = minHeap.peek();
            minHeap.remove(minValue);
            maxHeap.remove(minValue);
        }

        if(maxHeap.isEmpty()){
            return new int[]{0, 0};
        }

        return new int[]{maxHeap.peek(), minHeap.peek()};
    }
}
