package ru.geekbrains.lesson5;

import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public class Thing implements Comparable<Thing> {

    private final String name;
    private final int price;
    private final int weight;

    public Thing(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public static Thing[] randomArray(int size) {
        Random random = new Random();
        Thing[] arr = new Thing[size];
        for (int i = 0; i < size; i++)
            arr[i] = new Thing(String.format("Thing #%d", i + 1), random.nextInt(100) + 1, random.nextInt(100) + 1);
        return arr;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Thing o) {
        return Comparator
                .comparing(Thing::getPrice)
                .thenComparing(Thing::getWeight)
                .thenComparing(Thing::getName)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thing thing = (Thing) o;
        return price == thing.price && weight == thing.weight && name.equals(thing.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, weight);
    }

    @Override
    public String toString() {
        return name + " price=" + price + " weight=" + weight;
    }
}
