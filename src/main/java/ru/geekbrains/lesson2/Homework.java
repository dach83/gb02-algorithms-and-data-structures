package ru.geekbrains.lesson2;

// 1. Отсортировать массив, состоящий из экземпляров класса Notebook в количестве 10000 штук.
//    Условия для сортировки:
//      1) по цене. От 500 до 2000 долларов с шагом в 50 если цена равная, то
//      2) по кол-ву оперативной памяти (от 4 до 24 с шагом 4)
//         если памяти тоже равное количество, то
//      3) по производителю: Lenuvo > Asos > MacNote > Eser > Xamiou
// 2. Оптимизировать сортировку выбором, добавив поиск максимального значения

import java.util.Arrays;

public class Homework {

    private static final int NOTEBOOK_COUNT = 10000;

    public static void main(String[] args) {
        Notebook[] notebooks1 = Notebook.randomArray(NOTEBOOK_COUNT);
        Notebook[] notebooks2 = notebooks1.clone();
        Arrays.sort(notebooks1);                 // эталонная сортировка
        SelectionSort.optimizedSort(notebooks2); // сортировка выбором
        System.out.println("Массивы совпадают? " + Arrays.equals(notebooks1, notebooks2));
    }

}
