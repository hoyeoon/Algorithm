package programmers_lv1;

import java.util.stream.IntStream;

public class 로또의최고순위와최저순위 {
	public int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int[] answer = new int[2];
        Long count_zero = IntStream.of(lottos).filter(x -> x == 0).count();
        int count = 0;
        
        for(int win_num : win_nums){
            if(IntStream.of(lottos).anyMatch(x -> x == win_num)) count++;
        }
        
        System.out.println(count);
        System.out.println(count_zero);
        answer[0] = rank[count + count_zero.intValue()];
        answer[1] = rank[count];          
        
        return answer;
    }
}
