package programmers_lv1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        int n = numbers.length;

        // TreeSet 사용시 add 하면 자동으로 오름차순 정렬이 된다고 함
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                list.add(numbers[i] + numbers[j]);
            }
        }

        List<Integer> duplicateRemoveList = new ArrayList<>(new HashSet<Integer>(list));
        System.out.println(duplicateRemoveList);
        duplicateRemoveList.sort(null); // null 대신 Comparator.naturalOrder() 가능
        return duplicateRemoveList.stream().mapToInt(Integer::intValue).toArray();
    }
}
