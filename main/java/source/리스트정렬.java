package source;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 리스트정렬 {
    public static void main(String[] args) {
        int[] intArray = {5,4,2,1,3};
        listSort(intArray);
    }

    private static void listSort(int[] intArray){
        List<Integer> integerList = Arrays.stream(intArray).boxed().collect(Collectors.toList());

        // 오름차순 정렬
        Collections.sort(integerList);
        System.out.println(integerList); // [1,2,3,4,5]

        // 내림차순 정렬
        // 방법1.
        List<Integer> integerList1 = Arrays.stream(intArray).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(integerList1); // [5,4,3,2,1]

        // 방법2.
        List<Integer> integerList2 = Arrays.stream(intArray).boxed().collect(Collectors.toList());
        Collections.sort(integerList2, Comparator.reverseOrder());
        System.out.println(integerList2); // [5,4,3,2,1]
    }
}
