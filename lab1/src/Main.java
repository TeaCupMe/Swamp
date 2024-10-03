import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    /**
     * Main для бинарного поиска
     */
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите искомое значение: ");
        int requiredValue = in.nextInt();

        int[] array;
        array = getArray(in);
        Arrays.sort(array);

        // int resultIndex = binarySearch(array, requiredValue);
        int resultIndex = binarySearchRecursive(array, requiredValue, 0, array.length - 1);
        System.out.printf("Найденное значение — %d. Мы хотели получить %d.", array[resultIndex], requiredValue);
        in.close();
    }

    private static int[] getArray(Scanner in) {
        System.out.print("Введите количество элементов массива: ");
        int arrayLength = in.nextInt();
        int[] array = new int[arrayLength];
        System.out.print("Введите элементы массива: ");
        for (int i = 0; i < arrayLength; i++) {
            array[i] = in.nextInt();
        }
        return array;
    }

    /**
     * Нерекурсивный бинарный поиск
     */
    private static int binarySearch(int[] array, int requiredValue) {
        int leftBorder = 0, rightBorder = array.length - 1;
        int middle = (leftBorder + rightBorder) / 2;
        while (array[middle] != requiredValue) {
            if (requiredValue < middle) {
                rightBorder = middle;
            } else {
                leftBorder = middle;
            }
            middle = (leftBorder + rightBorder) / 2;
        }
        return middle;
    }

    /**
     * Рекурсивный бинарный поиск
     */
    public static int binarySearchRecursive(int[] array, int requiredValue, int leftBorder, int rightBorder) {
        if (leftBorder > rightBorder) {
            return -1;
        }
        int middle = (leftBorder + rightBorder) / 2;
        if (array[middle] == requiredValue) {
            return middle;
        } else if (array[middle] < requiredValue) {
            return binarySearchRecursive(array, requiredValue, middle + 1, rightBorder);
        } else {
            return binarySearchRecursive(array, requiredValue, leftBorder, middle - 1);
        }
    }

    /**
     * В-3. camelCase -> camel Case.
     */
    public static void v3(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String string = in.nextLine();
        System.out.println(replacement(string));
        in.close();
    }

    private static String replacement(String string) {
        int symbol = 65;
        for (int i = 0; i < 26; i++) {
            char c = (char) (symbol + i);
            string = string.replaceAll(Character.toString(c), " " + Character.toString(c));
        }
        return string;
    }

    /**
     * В-4. 1023464567 -> 1-02-3-464-5-6-7
     */
    public static void v4(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        String numberStr = in.nextLine();

        numberStr = getStringWithHyphen(numberStr);
        String result = catchExceptions(numberStr);

        System.out.println(replacement(result));
        in.close();
    }

    private static String catchExceptions(String numberStr) {
        int firstPosition = 0, lastPosition = numberStr.length();
        if (numberStr.charAt(0) % 2 != 0) {
            firstPosition = 1;
        }
        if (numberStr.charAt(numberStr.length() - 1) % 2 != 0) {
            lastPosition--;
        }
        return numberStr.substring(firstPosition, lastPosition);
    }

    private static String getStringWithHyphen(String numberStr) {
        for (int i = 49; i < 58; i += 2) {
            String digit = Character.toString((char) (i));
            numberStr = numberStr.replaceAll(digit, "-" + digit + "-");
        }
        return numberStr.replaceAll("--", "-");
    }

    /**
     * Б-14. Сумма двух минимальных положительных чисел
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = getArray(in);
        int min1 = -1, min2 = min1;
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                if (min1 == -1) {
                    min1 = array[i];
                }
                else {
                    if (min2 == -1) {
                        if (min1 < array[i]) {
                            min2 = array[i];
                        }
                        else {
                            if (min1 > array[i]) {
                                min2 = min1;
                                min1 = array[i];
                            }
                        }
                    }
                }
                if (min1 > array[i]) {
                    min2 = min1;
                    min1 = array[i];
                }
                else {
                    if (min2 > array[i]) {
                        min2 = array[i];
                    }
                }
            }
        }

        if ((min1 == min2) && (min1 == -1)) {
            System.out.println("Нет положительных чисел");
        }
        else {
            if ((min2 == -1)) {
                System.out.println("Только одно положительное число");
            }
            else {
                System.out.printf("Сумма наименьших положительных чисел %d + %d = %d", min1, min2, (min1 + min2));
            }
        }

        in.close();
    }

    private static int getLength(int number) {
        int length = 0;
        while (number != 0) {
            number /= 10;
            length++;
        }
        return length;
    }
}
