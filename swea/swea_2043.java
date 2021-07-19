package swea;

import java.util.*;

public class swea_2043 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String strin = sc.nextLine();
		String[] arr = strin.split(" ");
		sc.close();
		
		int P = Integer.parseInt(arr[0]);
		int K = Integer.parseInt(arr[1]);
		System.out.println(P - K + 1);
	}
}
