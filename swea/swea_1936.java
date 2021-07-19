package swea;

import java.util.*;

public class swea_1936 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String strin = sc.nextLine();
		String[] arr = strin.split(" ");
		
		int A = Integer.parseInt(arr[0]);
		int B = Integer.parseInt(arr[1]);
		
		if(A > B)
			System.out.println("A");
		else
			System.out.println("B");
		sc.close();
	}
}
