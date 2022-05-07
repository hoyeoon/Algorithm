package programmers_lv1;

import java.util.Scanner;
import java.util.stream.IntStream;

public class 직사각형별찍기 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        IntStream.range(0, a).forEach(i -> sb.append("*"));
        IntStream.range(0, b).forEach(j -> System.out.println(sb.toString()));
    }
}
