package lesson2;

import java.util.Arrays;

public class main {

    private static void change(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == 1)
//                arr[i] = 0;
//            else
//                arr[i] = 1;
//            arr[i] = (arr[i] == 1) ? 0 : 1;
//            arr[i] = 1 - arr[i];
            arr[i] ^= 1;
        }
    }

    private static void arithmetic(int[] arr) {// arr = @123ffbaf12
        int n = -3;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = n += 3;
        }
    }

    private static void multiply(int[] arr, int multiplier, int condition) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < condition)
                arr[i] *= multiplier;
        }
    }

    private static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    private static int findMax(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[max])
                max = i;
        }
        return max;
    }

    private static void printSquare(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void diagonal(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - i - 1] = 1;
        }
    }

    private static boolean checkBalance(int[] arr) {
        int left = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int right = 0;
            left += arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                right += arr[j];
            }
            if (left == right) {
                return true;
            }
        }
        return false;
    }

    private static void shift(int[] arr, int value) {
        boolean dir = value < 0;
        if (dir) value = -value;

        value %= arr.length;
        int lastIndex = arr.length - 1;
        for (int i = 0; i < value; i++) {
            int temp = (dir) ? arr[0] : arr[lastIndex];
            if (dir) {
                System.arraycopy(arr, 1, arr, 0, lastIndex);
                arr[lastIndex] = temp;
            } else {
                System.arraycopy(arr, 0, arr, 1, lastIndex);
                arr[0] = temp;
            }
        }
    }

    private static void shifter(int[] arr, int value) {
        boolean dir = value < 0;
        if (dir) value = -value;

        value %= arr.length; // value = value % arr.length
//        value = 2 % 6;

        int lastIndex = arr.length - 1;
        for (int i = 0; i < value; i++) {
            int temp = (dir) ? arr[0] : arr[lastIndex];
            for (int j = 0; j < lastIndex; j++) {
                if (dir) {
                    arr[j] = arr[j + 1];
                } else {
                    arr[lastIndex - j] = arr[lastIndex - j - 1];
                }
            }
            if (dir) {
                arr[lastIndex] = temp;
            } else {
                arr[0] = temp;
            }
        }

    }

    public static void main(String[] args) {
        // 1 Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в
        // принятом массиве 0 на 1, 1 на 0;
        int[] ar0 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0}; // ar0 = @123ffbaf12
        System.out.println(Arrays.toString(ar0));
        change(ar0);
        System.out.println(Arrays.toString(ar0));

        // 2 Задать пустой целочисленный массив размером 8.
        // Написать метод, который помощью цикла заполнит его значениями
        // 0 3 6 9 12 15 18 21;
        int[] ar1 = new int[8];
        arithmetic(ar1);
        System.out.println(Arrays.toString(ar1));

        // 3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
        // написать метод, принимающий на вход массив и умножающий
        // числа меньше 6 на 2;
        int[] ar2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(ar2));
        multiply(ar2, 2, 6);
        System.out.println(Arrays.toString(ar2));

        //4 Задать одномерный массив. Написать методы поиска в нём
        // минимального и максимального элемента;
        System.out.println(findMax(ar2));
        System.out.println(findMin(ar2));

        //5 * Создать квадратный целочисленный массив
        // (количество строк и столбцов одинаковое), заполнить его
        // диагональные элементы единицами, используя цикл(ы);
        int[][] square = new int[10][10];
        diagonal(square);
        printSquare(square);

        //6 ** Написать метод, в который передается не пустой одномерный
        // целочисленный массив, метод должен вернуть true если в массиве
        // есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([1, 1, 1, || 2, 1]) → true,
        // checkBalance ([2, 1, 1, 2, 1]) → false,
        // checkBalance ([10, || 1, 2, 3, 4]) → true. Абстрактная граница показана
        // символами ||, эти символы в массив не входят.
        int[] ar3 = {10, 1, 2, 3, 4};
        System.out.println(checkBalance(ar3));

        // 7 *** Написать метод, которому на вход подаётся одномерный массив
        // и число n (может быть положительным, или отрицательным), при этом
        // метод должен циклически сместить все элементы массива на n позиций.
        // **** Не пользоваться вспомогательным массивом.
        int[] ar4 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(ar4));
        shift(ar4, 2);
        System.out.println(Arrays.toString(ar4));
        shift(ar4, -10);
        System.out.println(Arrays.toString(ar4));

    }
}

