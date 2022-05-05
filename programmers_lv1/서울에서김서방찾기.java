package programmers_lv1;

import java.util.Arrays;

public class 서울에서김서방찾기 {
    public String solution(String[] seoul) {
        int index = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 " + index + "에 있다";
    }
}
