package ru.geekbrains.lesson2;

public class SelectionSort {

    private static <T> void swap(T[] arr, int i, int j) {
        if (i == j) // перестановка не нужна
            return;

        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Сортировка выбором, с поиском максимального значения
    public static <T extends Comparable<T>> void optimizedSort(T[] arr) {
        int leftBound = 0;
        int rightBound = arr.length - 1;

        while (leftBound < rightBound) {
            int min = leftBound;
            int max = rightBound;
            if (arr[max].compareTo(arr[min]) < 0)
                swap(arr, min, max);

            for (int i = leftBound + 1; i <= rightBound - 1; i++) {
                if (arr[i].compareTo(arr[min]) < 0) {
                    min = i;
                }
                if (arr[i].compareTo(arr[max]) > 0) {
                    max = i;
                }
            }

            swap(arr, min, leftBound++);
            swap(arr, max, rightBound--);
        }
    }


}
