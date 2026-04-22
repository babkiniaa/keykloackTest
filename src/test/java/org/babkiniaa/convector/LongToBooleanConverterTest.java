package org.babkiniaa.convector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class LongToBooleanConverterTest {

    LongToBooleanConverter longToBooleanConverter = new LongToBooleanConverter();

    @ParameterizedTest
    @MethodSource("convertToDatabaseSource")
    void convertToDatabaseColumn(Long expectedValue,
                                 Boolean valueInput) {
        Assertions.assertEquals(expectedValue, longToBooleanConverter.convertToDatabaseColumn(valueInput));
    }

    static Stream<Arguments> convertToDatabaseSource() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(1L, true),
                Arguments.of(0L, false)
        );
    }

    @ParameterizedTest
    @MethodSource("convertAttributeSource")
    void convertToEntityAttribute(Boolean expectedValue,
                                  Long inputValue) {
        Assertions.assertEquals(expectedValue, longToBooleanConverter.convertToEntityAttribute(inputValue));
    }

    public static Stream<Arguments> convertAttributeSource() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(true, 1L),
                Arguments.of(false, 0L)
        );
    }
}