package programmers_lv1;

public class 가운데글자가져오기 {
    public String solution(String s) {
        return s.substring(s.length() / 2 - 1 + s.length() % 2, s.length() / 2 + 1);
    }
}
