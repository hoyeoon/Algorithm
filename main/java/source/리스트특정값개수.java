package source;

import java.util.*;

public class 리스트특정값개수 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 2, 2, 3));
        System.out.println(countValue(list));
    }
    private static int countValue(List<Integer> list){
        return Collections.frequency(list, 2);
    }
}
