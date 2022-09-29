package com.tonyjev.study.junit.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

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

    @Nested
    @DisplayName("요구사항 2")
    class Require2 {
        @Test
        @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환 하도록 구현한다.")
        void require2_1() {
            // given
            var target = "(1,2)";
            var expected = "1,2";

            // when
            var result = target.substring(1, target.length() - 1);


            //then
            assertThat(result).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("요구사항 3")
    class Require3 {
        @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
        @ParameterizedTest(name = "위치 {1} = {0}")
        @CsvSource({
                "a,0",
                "b,1",
                "c,2",
        })
        void require3_1(char expected, int charPosition) {
            // given
            var target = "abc";

            // when
            var result = target.charAt(charPosition);

            //then
            assertThat(result).isEqualTo(expected);
        }

        /**
         * 자주 발생하는 Exception 에 대한 별도 메서드
         * - assertThatIllegalArgumentException()
         * - assertThatIllegalStateException()
         * - assertThatIOException()
         * - assertThatNullPointerException()
         */
        @Test
        @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
        void require3_2() {
            // given
            var target = "abc";
            var minIndexMinusOne = 0 - 1;
            var maxIndexPlusOne = target.length() + 1;
            var expectedExceptionType = StringIndexOutOfBoundsException.class;

            // when & then
            assertThatThrownBy(() -> {
                target.charAt(minIndexMinusOne);
            }).as("최소 Index 보다 1 작은 경우")
                    .isInstanceOfAny(expectedExceptionType)
                    .hasMessageContaining(String.format("String index out of range: " + minIndexMinusOne));

            assertThatExceptionOfType(expectedExceptionType)
                    .isThrownBy(() -> {
                        target.charAt(minIndexMinusOne);
                    }).withMessageMatching("String index out of range: -\\d+");

            assertThatThrownBy(() -> {
                target.charAt(maxIndexPlusOne);
            }).as("최대 Index 보다 1 큰 경우")
                    .isInstanceOfAny(expectedExceptionType)
                    .hasMessageContaining("String index out of range: " + maxIndexPlusOne);

            assertThatExceptionOfType(expectedExceptionType)
                    .isThrownBy(() -> {
                        target.charAt(maxIndexPlusOne);
                    }).withMessageMatching("String index out of range: \\d+");
        }
    }
}
