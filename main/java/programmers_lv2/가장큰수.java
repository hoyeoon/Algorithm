package programmers_lv2;

import java.math.BigDecimal;
import java.util.Arrays;

public class 가장큰수 {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        String str = String.join("", arr);
        BigDecimal num = new BigDecimal(str);   // ex. "0000"압축을 위함
        return num.toString();
    }
}
