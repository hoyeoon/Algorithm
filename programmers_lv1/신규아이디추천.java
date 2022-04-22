package programmers_lv1;

public class 신규아이디추천 {
    public String solution(String new_id) {
        String answer = "";
        int length;

        new_id = new_id.toLowerCase();  // 1단계
        new_id = new_id.replaceAll("[^a-z0-9-_.]", ""); // 2단계
        System.out.println(new_id);
        new_id = new_id.replaceAll("\\.{2,}", "\\.");   // 3단계
        System.out.println(new_id);
        new_id = new_id.replaceAll("^\\.|\\.$", "");   // 4단계
        System.out.println(new_id);

        if(new_id.equals("")) new_id = "a"; // 5단계
        System.out.println(new_id);
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15); // 6-1 단계
            if(new_id.charAt(14) == '.') {
                new_id = new_id.substring(0, 14);   // 6-2 단계
            }
        }
        // 7단계
        length = new_id.length();
        if(length <= 2){
            String last = Character.toString(new_id.charAt(new_id.length() - 1));
            System.out.println("last = " + last);
            new_id += last.repeat(3 - length);
        }
        System.out.println(new_id);


        return new_id;
    }
}
