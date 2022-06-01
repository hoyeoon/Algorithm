package programmers_lv2;

public class JadenCase문자열만들기 {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        String[] arr = s.split("\\s", -1);  // 마지막 뒤 공백도 가져오기 위해 -1
        StringBuilder sb = new StringBuilder();

        System.out.println(arr[0]);
        for(String str : arr){
            if(str.equals("")){
                sb.append(" ");
            } else{
                sb.append(str.substring(0, 1).toUpperCase())
                        .append(str.substring(1))
                        .append(" ");
            }
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}
