package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 조이스틱
public class Greedy_2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int answer = 0;
		
		answer += findMinDist(arr);
		for(int i = 0; i < arr.length; i++) {
			answer += moveAlphaCnt(arr[i]);
		}
		System.out.println(answer);
	}
	
	private static int moveAlphaCnt(char c) {
		int temp = c - 'A';
		return (temp <= 13) ? temp : 26 - temp;
	}
	
	private static int findMinDist(char[] arr) {
		int cnt1 = 0, cnt2 = 0, cnt3 = Integer.MAX_VALUE;
		int N = arr.length;
		
		// 시작위치에서 오른쪽으로 갔을 때 A가 아닌 곳까지의 cnt
		for(int i = N - 1; i >= 1; i--) {
			if(arr[i] != 'A') {
				cnt1 = i;
				break;
			}
		}
		
		// 시작위치에서 왼쪽으로 갔을 때 A가 아닌 곳까지의 cnt
		for(int i = 1; i < N; i++) {
			if(arr[i] != 'A') {
				cnt2 = N - i;
				break;
			}
		}
		
		// 시작위치에서 오른쪽으로 갔을 때 A가 아닌 곳을 찍고, 다시 왼쪽으로 가서 A가 아닌 곳까지의 cnt
		int tempCnt = 0;
		int[] idx = new int[2];
		for(int i = 1; i < N; i++) {
			if(arr[i] != 'A') {
				idx[tempCnt] = i;
				tempCnt++;
			}
			if(tempCnt == 2) {
				cnt3 = idx[0] * 2 + N - idx[1];
				break;
			}
		}
		return Math.min(cnt1, Math.min(cnt2,  cnt3));
	}
}
