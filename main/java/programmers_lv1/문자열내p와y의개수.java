package programmers_lv1;

public class 문자열내p와y의개수 {
    boolean solution(String s) {
        int num_p = 0;
        int num_y = 0;
        s = s.toLowerCase();    // 소문자로 통일
        char[] arr = s.toCharArray();
        for(int c : arr){
            if(c == 'p') num_p++;
            else if(c == 'y') num_y++;
        }

        return num_p == num_y ? true : false;
    }
}
