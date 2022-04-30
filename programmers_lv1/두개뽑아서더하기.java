package programmers_lv1;

import java.util.*;

public class 두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();
        int n = numbers.length;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();

        /* 기존방식
        List<Integer> list = new ArrayList<>();
        int n = numbers.length;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                list.add(numbers[i] + numbers[j]);
            }
        }

        List<Integer> duplicateRemoveList = new ArrayList<>(new HashSet<Integer>(list));
        System.out.println(duplicateRemoveList);
        duplicateRemoveList.sort(null); // null 대신 Comparator.naturalOrder() 가능
        return duplicateRemoveList.stream().mapToInt(Integer::intValue).toArray();*/
    }
}
