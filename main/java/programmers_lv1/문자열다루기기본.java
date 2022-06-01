package programmers_lv1;

public class 문자열다루기기본 {
    public boolean solution(String s) {
        if(s.length() != 4 && s.length() != 6) return false;

        char[] arr = s.toCharArray();
        for(char c : arr){
            if(c < '0' || c > '9') return false;
        }

        return true;
    }
}
