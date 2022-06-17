package programmers_lv2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int t = 0;
        Deque<Integer> waiting = new ArrayDeque<>(Arrays.stream(truck_weights).boxed().collect(Collectors.toList()));
        Deque<Integer> ing = new ArrayDeque<>();

        while(!waiting.isEmpty()){
            //System.out.println(t + ", " + ing + ", " + waiting);

            if(ing.size() >= bridge_length){
                ing.poll();
            }

            if(sum(ing) + waiting.peek() <= weight){
                ing.add(waiting.poll());
            } else{
                ing.add(0);
            }
            t++;
        }
        return t + bridge_length;
    }

    private int sum(Deque<Integer> deque){
        return deque.stream().mapToInt(Integer::intValue).sum();
    }
}
