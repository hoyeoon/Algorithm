package programmers_lv1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 폰켓몬 {
    class Solution {
        public int solution(int[] nums) {
//            int answer = 0;
//            int R = nums.length / 2;
//            Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
//            // System.out.println(set);
//
//            if(set.size() > R) answer = R;
//            else answer = set.size();
//            return answer;

            return Arrays.stream(nums)
                    .boxed()
                    .collect(
                            Collectors.collectingAndThen(
                                    Collectors.toSet(),
                                    set -> Math.min(set.size(), nums.length / 2)
                            )
                    );
        }
    }
}
