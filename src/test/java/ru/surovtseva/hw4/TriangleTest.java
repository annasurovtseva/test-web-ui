package ru.surovtseva.hw4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.surovtseva.hw4.utils.TimingExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(TimingExtension.class)
public class TriangleTest {
    private static final Logger logger = LoggerFactory.getLogger(TriangleTest.class);
    private static final Triangle triangle = new Triangle();

    @BeforeAll
    static void setUp(){logger.info("Just a log message. Test suite started");
    }

    @DisplayName("Переданы корректные данные")
    @ParameterizedTest
    @MethodSource("correctValues")
    void whenPassedCorrectValuesTest(double expectedValues, double result){
        Assertions.assertEquals(expectedValues, result);
    }

    @DisplayName("TriangleException, при неверных сторонах")
    @Test
    void shouldThrowExceptionOnIncorrectSideTest(){
        assertThrows(
                TriangleException.class,
                () -> triangle.calcTriangleArea(3,6,3));
    }

    @DisplayName("TriangleException, при сторонах = 0")
    @Test
    void shouldThrowExceptionOnZeroSideTest(){
        assertThrows(
                TriangleException.class,
                () -> triangle.calcTriangleArea(0,7,5));
    }

    @DisplayName("TriangleException, при сторонах < 0")
    @Test
    void shouldThrowExceptionOnNegativeSideTest(){
        assertThrows(
                TriangleException.class,
                () -> triangle.calcTriangleArea(6,-2,5));
    }

    @DisplayName("Cообщение TriangleException, при сторонах треугольника <= 0")
    @Test
    void messageOnZeroOrNegativeSideTest() {

        String message = "Длина строны треугольника должна быть > 0";
        Throwable exceptionZero = assertThrows(
                TriangleException.class,
                () -> triangle.calcTriangleArea(0,2,3));
        Throwable exceptionNegative = assertThrows(
                TriangleException.class,
                () -> triangle.calcTriangleArea(-2,2,3));
        Assertions.assertAll(
                ()-> Assertions.assertEquals(message, exceptionZero.getMessage()),
                ()-> Assertions.assertEquals(message, exceptionNegative.getMessage())
        );
    }

    @DisplayName("Сообщение TriangleException, при неверных сторонах треугольника")
    @Test
    void messageOnIncorrectSideTest(){

        Throwable exception = assertThrows(
                        TriangleException.class,
                        () -> triangle.calcTriangleArea(1,2,3));

        Assertions.assertEquals("Треуголника с указанными сторонами не существует!", exception.getMessage());
    }

    @AfterAll
    static void tearDown(){logger.warn("Just another log message. Test suite is finished");
    }

    private static Stream<Arguments> correctValues() {
        return Stream.of(
                Arguments.of(6,triangle.calcTriangleArea(3,4,5)),
                Arguments.of(9.922, triangle.calcTriangleArea(4,5,6)),
                Arguments.of(14.697, triangle.calcTriangleArea(5,6,7))
        );
    }
}
