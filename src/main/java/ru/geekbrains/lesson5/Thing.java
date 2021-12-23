package ru.geekbrains.lesson5;

import java.util.Random;

public class Thing {

    private static int counter = 0;

    private final int id;
    private final int price;
    private final int weight;

    public Thing(int price, int weight) {
        this.id = ++counter;
        this.price = price;
        this.weight = weight;
    }

    public static Thing[] randomArray(int size) {
        Random random = new Random();
        Thing[] arr = new Thing[size];
        for (int i = 0; i < size; i++)
            arr[i] = new Thing(random.nextInt(100) + 1, random.nextInt(100) + 1);
        return arr;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
