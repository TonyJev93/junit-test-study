package com.tonyjev.study.junit.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringTest {

    @Nested
    @DisplayName("요구사항 1")
    class Require1 {
        @Test
        @DisplayName("\"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
        void require1_1() {
            // given
            var target = "1,2";

            // when
            var result = target.split(",");

            //then
            assertThat(result).contains("1", "2");
        }

        @Test
        @DisplayName("\"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
        void require1_2() {
            // given
            var target = "1";

            // when
            var result = target.split(",");

            //then
            assertThat(result).containsExactly("1");
        }
    }


}