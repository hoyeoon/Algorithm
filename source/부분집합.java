package source;

public class 부분집합 {
	static int[] arr = {1, 2, 3};
	
	static void subset(int n) {
		for(int i = 0; i < (1 << n); i++){
			for(int j = 0; j < n; j++) {
				if((i & (1 << j)) != 0) {
					System.out.print(arr[j]);
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		subset(3);
	}
}
