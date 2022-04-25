package programmers_lv1;

import java.util.Arrays;

public class 없는숫자더하기 {
	public int solution(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }
}
