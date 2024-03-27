package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class StringChallengeTest {

    @ParameterizedTest
    @MethodSource("inputAndOutputProvider")
    void extractMinutesDiff(String input, String expected) {
        String result = StringChallenge.extractMinutesDiff(input);

        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> inputAndOutputProvider() {
        return Stream.of(
                Arguments.arguments("8:30am-10:00am", "90"),
                Arguments.arguments("8:30pm-10:00pm", "90"),
                Arguments.arguments("10:00am-8:30am", "1350"),
                Arguments.arguments("10:00pm-8:30pm", "1350"),
                Arguments.arguments("10:00pm-8:30am", "630"),
                Arguments.arguments("8:00am-2:30pm", "390")
        );
    }
}
