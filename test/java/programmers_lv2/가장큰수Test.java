package programmers_lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class 가장큰수Test {
    @Test
    public void compareTo_테스트(){
        assertThat("343".compareTo("334")).isGreaterThan(0);
        assertThat("334".compareTo("343")).isLessThan(0);
        assertThat("330".compareTo("303")).isGreaterThan(0);
        assertThat("303".compareTo("330")).isLessThan(0);
    }
}