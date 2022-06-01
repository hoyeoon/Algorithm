package programmers_lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> workDay = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++){
            workDay.add(getWorkDay(progresses[i], speeds[i]));
        }

        return getResult(workDay);
    }

    int getWorkDay(int progress, int speed) {
        int remainder = (100 - progress) % speed != 0 ? 1 : 0;
        return ((100 - progress) / speed) + remainder;
    }

    int[] getResult(List<Integer> sample) {
        List<Integer> result = new ArrayList<>();
        int max_day = sample.get(0);
        int count = 1;

        for(int i = 1; i < sample.size(); i++){
            if(sample.get(i) > max_day){
                max_day = sample.get(i);
                result.add(count);
                count = 0;
            }
            count++;
        }
        if(count != 0) result.add(count);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}