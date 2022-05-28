package programmers_lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();;

        // 유저 아이디에 따른 최종 접속(변경) 닉네임 설정
        for(String r : record){
            String[] word = r.split(" ");

            if(word[0].equals("Enter") || word[0].equals("Change")){
                map.put(word[1], word[2]);
            }
        }
        // System.out.println(map);

        // 메시지 만들기
        for(String r : record){
            String[] word = r.split(" ");
            sb.setLength(0);

            if(word[0].equals("Enter")){
                sb.append(map.get(word[1])).append("님이 들어왔습니다.");
                list.add(sb.toString());
            } else if(word[0].equals("Leave")){
                sb.append(map.get(word[1])).append("님이 나갔습니다.");
                list.add(sb.toString());
            }
        }
        // System.out.println(list);
        return list.toArray(new String[0]);
    }
}
