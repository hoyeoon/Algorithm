package programmers_lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class 기능개발Test {
    기능개발 functionDevelopment;

    @BeforeEach
    public void setUp(){
        // given
        functionDevelopment = new 기능개발();
    }

    @Test
    public void 값비교(){
        // when
        final int[] result1 = {2, 1};
        final int[] result2 = {1, 3, 2};

        // then
        assertThat(result1).containsExactly(functionDevelopment.solution(new int[]{93, 30, 55}, new int[] {1, 30, 5}));
        assertThat(result2).containsExactly(functionDevelopment.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1}));
    }

    @ParameterizedTest
    @MethodSource("checkWorkDay")
    public void 작업일수(int progress, int speed, int result){
        assertThat(result).isEqualTo(functionDevelopment.getWorkDay(progress, speed));
    }

    private static Stream<Arguments> checkWorkDay(){
        return Stream.of(
                Arguments.arguments(93, 1, 7),
                Arguments.arguments(30, 30, 3),
                Arguments.arguments(55, 5, 9)
        );
    }

    @Test
    public void 기능배포수체크() {
        // given
        List<Integer> sample = Arrays.asList(5, 10, 1, 1, 20, 1);
        List<Integer> sample2 = Arrays.asList(7, 3, 9);

        // then
        assertThat(functionDevelopment.getResult(sample)).containsExactly(new int[]{1, 3, 2});
        assertThat(functionDevelopment.getResult(sample2)).containsExactly(new int[]{2, 1});
    }
}