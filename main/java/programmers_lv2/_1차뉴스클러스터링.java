package programmers_lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1차뉴스클러스터링 {
    public int solution(String str1, String str2) {
        final int NUMBER = 65536;
        List<String> list1 = makeList(str1.toUpperCase());
        List<String> list2 = makeList(str2.toUpperCase());

        System.out.println(list1);
        System.out.println(list2);

        List<String> intersectionList = intersection(list1, list2);
        List<String> unionList = union(list1, list2, intersectionList);

        System.out.println(intersectionList);
        System.out.println(unionList);

        System.out.println(list1);
        System.out.println(list2);


        return !unionList.isEmpty() ? NUMBER * intersectionList.size() / unionList.size() : NUMBER;
    }

    private boolean isAlpha(String s) {
        return s != null && s.matches("^[a-zA-Z]*$");
    }

    private List<String> makeList(String s) {
        List<String> list = new ArrayList<>();

        for(int i = 0; i < s.length() - 1; i++){
            if(isAlpha(s.substring(i, i + 2))){
                list.add(s.substring(i, i + 2));
            }
        }
        return list;
    }

    private List<String> intersection(List<String> list1, List<String> list2){
        List<String> result = new ArrayList<>();

        for(String str : list1){
            if(result.contains(str)) continue;

            int count1 = Collections.frequency(list1, str);
            int count2 = Collections.frequency(list2, str);

            if(count1 == 0 || count2 == 0) continue;

            if(count1 < count2){
                for(int i = 0; i < count1; i++){
                    result.add(str);
                }
            }else{
                for(int i = 0; i < count2; i++){
                    result.add(str);
                }
            }
        }
        return result;
    }

    private List<String> union(List<String> list1, List<String> list2, List<String> intersectionList){
        List<String> result = new ArrayList<>();
        result.addAll(list1);
        result.addAll(list2);

        for(String str : intersectionList){
            result.remove(str);
        }

        return result;
    }
}
