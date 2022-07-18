package programmers_lv2;
import java.util.*;

public class 메뉴리뉴얼 {
    boolean[] visited;
    Map<String, Integer> map = new HashMap<>();
    List<String> answer = new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {
        int max_length = 0;

        for(String order : orders){
            int n = order.length();

            for(int r = 2; r <= n; r++){
                visited = new boolean[n];
                comb(0, n, r, order);
            }

            max_length = Math.max(max_length, n);
        }

        List<String> list;

        for(int i : course){
            int max_course = 2;
            list = new ArrayList<>();

            for(String key : map.keySet()){
                if(i == key.length()){
                    if(max_course < map.get(key)){
                        max_course = map.get(key);
                        list = new ArrayList<>();
                        list.add(key);
                        continue;
                    }
                    if(max_course == map.get(key)){
                        list.add(key);
                    }
                }
            }
            //System.out.println(list);

            for(int j = 0; j < list.size(); j++){
                answer.add(list.get(j));
            }
        }

        Collections.sort(answer);
        //System.out.println(answer);

        return answer.toArray(new String[0]);
    }

    void comb(int start, int n, int r, String order) {
        if(r == 0) {
            String str = "";

            for(int i = 0; i < n; i++){
                if(visited[i]){
                    str += order.charAt(i);
                }
            }
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            str = new String(ch);

            if(Objects.isNull(map.get(str))){
                map.put(str, 1);
                return;
            }
            map.put(str, map.get(str) + 1);
            return;
        }

        for(int i = start; i < n; i++) {
            visited[i] = true;
            comb(i + 1, n, r - 1, order);
            visited[i] = false;
        }
    }
}
