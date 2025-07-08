import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

class MainTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void printArr() {
        Main.printArr(new int[]{1, 5, 10});

        Assertions.assertEquals("Массив целых чисел\r\n1\r\n5\r\n10", outputStreamCaptor.toString().trim());
    }

    @Test
    void findSum() {
        Assertions.assertEquals(1 + 5 + 10, Main.findSum(new int[]{1, 5, 10}));
    }

    @Test
    void findMin() throws Exception{
        Assertions.assertEquals(11, Main.findMin(new int[]{11, 51, 101}));

        Assertions.assertThrowsExactly(Exception.class, () -> { Main.findMin(new int[]{}); });
    }

    @Test
    void months() {
        Assertions.assertArrayEquals(new String[]{"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"}, Main.months());
    }

    @Test
    void linesBegM() {
        Main.linesBegM(new String[]{"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"});

        Assertions.assertEquals("Март\r\nМай", outputStreamCaptor.toString().trim());
    }

    @Test
    void invertArr() {
        int[] arr = {1, 2, 3, 4, 5};
        Main.invertArr(arr);
        Assertions.assertArrayEquals(new int[]{5, 4, 3, 2, 1}, arr);
    }

    @Test
    void hasRepeatedElements() {
        Assertions.assertEquals(false, Main.hasRepeatedElements(new int[]{1, 2, 3, 4, 5}));
        Assertions.assertEquals(true, Main.hasRepeatedElements(new int[]{1, 2, 3, 4, 2}));
    }

    @Test
    void absArr() {
        int[] arr = {1, -2, 3, -4, 5};
        Main.absArr(arr);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void arr2D() {
        Assertions.assertArrayEquals(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}, Main.arr2D());
    }

    @Test
    void printArr2D() {
        Main.printArr2D(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});

        Assertions.assertEquals("1 2 3 \r\n4 5 6 \r\n7 8 9", outputStreamCaptor.toString().trim());
    }

    @Test
    void findSum2D() {
        Assertions.assertEquals(45, Main.findSum2D(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    @Test
    void maxElementCoord() {
        Main.maxElementCoord(new int[][]{{1, 3, 5}, {17, 4, 16}, {2, 8, 7}});

        Assertions.assertEquals("колонка 1, строка 2", outputStreamCaptor.toString().trim());
    }

    @Test
    void isSquare() {
        Assertions.assertEquals(true, Main.isSquare(new int[][]{{1, 3, 5}, {17, 4, 16}, {2, 8, 7}}));
        Assertions.assertEquals(false, Main.isSquare(new int[][]{{1, 3, 5}, {17, 4, 16}}));
        Assertions.assertEquals(true, Main.isSquare(new int[0][0]));
    }

    @Test
    void matrixProperties() {
        Main.matrixProperties(new int[][]{{1, 3, 5}, {17, 4, 16}, {2, 8, 7}});

        Assertions.assertEquals("сумма элементов 1 строки: 9,\r\nсумма элементов 2 строки: 37,\r\nсумма элементов 3 строки: 17,\r\nминимальный элемент: 1, максимальный элемент: 17", outputStreamCaptor.toString().trim());
    }

    @Test
    void arrEvenOdd() {
        Assertions.assertArrayEquals(new int[][]{{0, 0, 0, 0}, {0, 1, 0, 1}, {0, 0, 0, 0}}, Main.arrEvenOdd(4, 3));
    }
}