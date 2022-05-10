package programmers_lv1;

import java.util.Arrays;

public class 이상한문자만들기 {
    public String solution(String s) {
        String[] arr = s.split("\\s", -1);  // 마지막 단어 뒤 공백도 가져오기 위해 -1 처리
        System.out.println(Arrays.toString(arr));
        StringBuilder sb = new StringBuilder();

        for(String str : arr){
            char[] cArr = str.toCharArray();

            for(int i = 0; i < cArr.length; i++){
                if(i % 2 == 0){
                    sb.append(Character.toUpperCase(cArr[i]));
                }else{
                    sb.append(Character.toLowerCase(cArr[i]));
                }
            }
            sb.append(" ");
        }
        sb.setLength(sb.length() - 1);

        return sb.toString();
    }
}
