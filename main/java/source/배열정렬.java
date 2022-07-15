package source;

import java.util.Arrays;
import java.util.Collections;

public class 배열정렬 {
    public static void main(String[] args) {
        int[] intArray = {5,4,2,1,3};
        arraySort(intArray);
    }

    private static void arraySort(int[] intArray){
        // 오름차순 정렬
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray)); // [1,2,3,4,5]

        // 내림차순 정렬
        // Arrays.sort(intArray, Collections.reverseOrder()); //컴파일 에러
        Integer[] integerArray = Arrays.stream(intArray).boxed().toArray(Integer[]::new);

        Arrays.sort(integerArray, Collections.reverseOrder());
        System.out.println(Arrays.toString(integerArray)); // [5,4,3,2,1]
    }
}
