package programmers_lv2;

public class 이진변환반복하기 {
    public int[] solution(String s) {
        int loopCount = 0;
        int zeroCount = 0;

        while(!s.equals("1")){
            zeroCount += countZero(s);
            s = makeBinary(s.length() - countZero(s));
            loopCount++;
        }

        return new int[]{loopCount, zeroCount};
    }

    private int countZero(String binary){

        int count = 0;

        for(int i = 0; i < binary.length(); i++){
            if(binary.charAt(i) == '0'){
                count++;
            }
        }

        return count;
    }

    private String makeBinary(int num){
        String binary = "";

        while(num > 0){
            binary = num % 2 + binary;
            num /= 2;
        }

        return binary;
    }
}
