package programmers_lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 문자열내마음대로정렬하기 {
    public String[] solution(String[] strings, int n) {
        List<String> list = Arrays.asList(strings);
        list.sort(Comparator.naturalOrder());

        String[] answer = list.stream()
                .sorted(Comparator.comparing(string -> string.charAt(n)))
                .toArray(String[]::new);

        //System.out.println(list);
        return answer;
    }
}
