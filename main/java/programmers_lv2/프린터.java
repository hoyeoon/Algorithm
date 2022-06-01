package programmers_lv2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 프린터 {
    public int solution(int[] priorities, int location) {
        int N = priorities.length;
        Integer[] idxAnswer = new Integer[N];
        int i = 0;

        Deque<Integer> idxQueue = IntStream.range(0, N)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        outer : while(!idxQueue.isEmpty()){
            int targetIdx = idxQueue.pollFirst();

            for(int idx : idxQueue){
                if(priorities[targetIdx] < priorities[idx]){
                    idxQueue.offerLast(targetIdx);
                    continue outer;
                }
            }
            idxAnswer[i] = targetIdx;
            i++;
        }
        System.out.println(Arrays.toString(idxAnswer));
        return Arrays.asList(idxAnswer).indexOf(location) + 1;
    }
}
