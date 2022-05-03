package programmers_lv1;

import java.util.Arrays;

public class 시저암호 {
    public String solution(String s, int n) {
        String answer = "";
        char[] arr = s.toCharArray();
        System.out.println(Arrays.toString(arr));

        for(char c : arr){
            if(c >= 65 && c <= 90){
                answer += (char)(((c + n) - 65) % 26 + 65);
            } else if(c >= 97 && c <= 122) {
                answer += (char)(((c + n) - 97) % 26 + 97);
            } else {
                answer += c;
            }
        }

        return answer;
    }
}
