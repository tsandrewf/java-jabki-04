public class Main {
    public static void main(String[] args) {
        int[] intArr = {40, 50, 60};
        printArr(intArr);

        System.out.printf("Сумма элементов этого массива: %s", findSum(intArr));
        System.out.println();

        try {
            System.out.printf("Минимальный элемент этого массива: %s", findMin(intArr));
        } catch (Exception e) {
            System.out.print(e.getMessage());
        } finally {
            System.out.println();
        }

        System.out.println();
        String[] months = months();
        System.out.println("Месяцы, начинающиеся с буквы \"М\":");
        linesBegM(months);

        System.out.println();
        System.out.println("Инвертируем");
        invertArr(intArr);
        printArr(intArr);

        {
            System.out.println();
            printArr(intArr);
            if (hasRepeatedElements(intArr)) {
                System.out.println("Содержит повторяющиеся элементы");
            } else {
                System.out.println("не содержит повторяющиеся элементы");
            }
        }

        {
            System.out.println();
            int[] arr = {6, 7, 6, 9, 0};
            printArr(arr);
            if (!hasRepeatedElements(arr)) {
                System.out.print("не ");
            }
            System.out.println("содержит повторяющиеся элементы");
        }

        {
            System.out.println();
            int[] arr = {-6, 7, -2, 9, -9};
            printArr(arr);
            System.out.println("Заменяем все отрицательные числа в массиве на их абсолютные значения");
            absArr(arr);
            printArr(arr);
        }

        System.out.println();
        System.out.println("Двумерный массив");
        printArr2D(arr2D());

        {
            int[][] arr = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
            System.out.println("Сумма элементов двумерного массива:");
            printArr2D(arr);
            System.out.printf("равна: %s", findSum2D(arr));
            System.out.println();
            System.out.println();
        }

        {
            int[][] arr = {{1, 3, 5}, {2, 4, 16}, {2, 8, 7}};
            System.out.println("Координаты максимального элемента двумерного массива");
            printArr2D(arr);
            System.out.print("равны: ");
            maxElementCoord(arr);
            System.out.println();
        }

        {
            int[][] matrix = {{1, 3, 5}, {2, 4, 16}, {2, 8, 7}};
            System.out.println("Матрица");
            printArr2D(matrix);
            if (!isSquare(matrix)) {
                System.out.print("не ");
            }
            System.out.println("является квадратной");
        }

        {
            int[][] matrix = {{1, 3, 5}, {2, 4, 16}, {2, 8, 7}, {8, 9, 0}};
            System.out.println("Матрица");
            printArr2D(matrix);
            if (isSquare(matrix)) {
                System.out.println("является квадратной");
            } else {
                System.out.println("не является квадратной");
            }
        }

        {
            int[][] matrix = {{1, 3, 5}, {2, 4, 16}, {2, 8, 7}, {8, 9, 0}};
            System.out.println("У матрицы");
            printArr2D(matrix);
            matrixProperties(matrix);
        }

        {
            System.out.println();
            System.out.println("Двумерный массив, у которого элементы на четных позициях были 0, на нечетных 1");
            printArr2D(arrEvenOdd(3, 4));
        }
    }

    // Метод, который выводит массив в консоль
    public static void printArr(int[] arr) {
        System.out.println("Массив целых чисел");
        for (int j: arr) {
            System.out.println(j);
        }
    }

    /*
        Метод, который принимает массив целых чисел
        и возвращает сумму всех его элементов
    */
    public static int findSum(int[] arr) {
        int retVal = 0;
        for (int j: arr) {
            retVal +=j;
        }

        return retVal;
    }

    // Метод для поиска минимального элемента в одномерном массиве
    public static int findMin(int[] intArray) throws Exception {
        if (0 == intArray.length) {
            throw new Exception("У пустого массива нет минимального значения");
        }

        int retVal = Integer.MAX_VALUE;

        for (int j : intArray) {
            if (j < retVal) {
                retVal = j;
            }
        }

        return retVal;
    }

    // Массив строк, инициализированный названиями месяцев года
    public static String[] months() {
        return new String[]{"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    }

    // Выведите все строки, начинающиеся на букву "М"
    public static void linesBegM(String[] lines) {
        for (String line: lines) {
            if (line.startsWith("М")) {
                System.out.println(line);
            }
        }
    }

    // Метод, который инвертирует порядок элементов в одномерном массиве
    public static void invertArr(int[] arr) {
        int[] arrTmp = new int[arr.length];
        System.arraycopy(arr, 0, arrTmp, 0, arr.length);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrTmp[arr.length - i - 1];
        }
    }

    // Метод, который проверяет, есть ли в массиве повторяющиеся элементы
    public static boolean hasRepeatedElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    // Метод, который заменяет все отрицательные числа в массиве на их абсолютные значения
    public static void absArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(arr[i]);
        }
    }

    /*
       Создаем двумерный массив 3x3, заполняем его единицами на главной диагонали
       и нулями в остальных ячейках
     */
    public static int[][] arr2D() {
        return new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
    }

    // Выводим массив
    public static void printArr2D(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    // Функция, вычисляющая сумму всех элементов в двумерном массиве
    public static int findSum2D(int[][] arr) {
        int retVal = 0;

        for (int[] ints : arr) {
            for (int anInt : ints) {
                retVal += anInt;
            }
        }

        return retVal;
    }

    // Реализуйте поиск максимального элемента в матрице
    // и вывод его координат (строка, столбец)
    public static void maxElementCoord(int[][] arr) {
        int maxElement = Integer.MIN_VALUE;
        int col = 0, row = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > maxElement) {
                    col = j;
                    row = i;
                    maxElement = arr[i][j];
                }
            }
        }
        System.out.printf("колонка %s, строка %s", col + 1, row + 1);
    }

    /*
       Функция, проверяющая, является ли двумерный массив квадратным
       (количество строк = количеству столбцов)
     */
    public static boolean isSquare(int[][] matrix) {
        if(matrix.length == 0) {
            return true;
        }

        return (matrix.length == matrix[0].length);
    }

    /*
       Метод, который находит сумму элементов каждой строки,
       минимальное и максимальное значение двумерного массива
       и выводит результаты
     */
    public static void matrixProperties(int[][] matrix) {
        int maxElement = Integer.MIN_VALUE, minElement = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;

            for (int j = 0; j < matrix[i].length; j++) {
                rowSum += matrix[i][j];

                if (matrix[i][j] > maxElement) {
                    maxElement = matrix[i][j];
                }

                if (matrix[i][j] < minElement) {
                    minElement = matrix[i][j];
                }
            }

            System.out.printf("сумма элементов %s строки: %s,", i + 1, rowSum);
            System.out.println();
        }
        System.out.printf("минимальный элемент: %s, максимальный элемент: %s", minElement, maxElement);
        System.out.println();
    }

    /*
       Создайте двумерный массив, заполните его так,
       чтобы элементы на четных позициях были 0, на нечетных — 1
     */
    public static int[][] arrEvenOdd(int cols, int rows) {
        int[][] retVal = new int[rows][cols];

        for (int i = 0; i < retVal.length; i++) {
            for (int j = 0; j < retVal[i].length; j++) {
                if (((i+ 1) % 2 == 0) && ((j + 1) % 2 == 0)) {
                    retVal[i][j] = 1;
                } else {
                    retVal[i][j] = 0;
                }
            }
        }

        return retVal;
    }
}