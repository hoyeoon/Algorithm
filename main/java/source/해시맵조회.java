package source;

import java.util.HashMap;
import java.util.Map;

public class 해시맵조회 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        for(String key : map.keySet()){
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }
}
