package programmers_lv2;

public class n2_배열자르기 {
    int[][] map;

    public int[] solution(int n, long left, long right) {
        int[] arr = new int[(int)(right - left) + 1];
        long idx;

        for(int i = 0; i < (int)(right - left) + 1; i++){
            idx = left + (long)i;
            arr[i] = (int)(idx / n) + 1;

            if((int)(idx / n) < (int)(idx % n)){
                arr[i] += ((int)(idx % n) - (int)(idx / n));
            }
        }

        return arr;
    }
}
