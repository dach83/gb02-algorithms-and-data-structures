package ru.geekbrains.lesson5;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Bag {

    public static final Bag EMPTY = new Bag(0);

    private final Set<Thing> things;
    private final int maxWeight;
    private int weight;
    private int price;

    public Bag(int maxWeight) {
        this.maxWeight = 0;
        this.weight = 0;
        this.price = 0;
        this.things = new HashSet<>();
    }

    public Bag(Bag other) {
        this(other.maxWeight);
        this.weight = other.weight;
        this.price = other.price;
        this.things.addAll(other.things);
    }

    public boolean put(Thing thing) {
        if (weight + thing.getWeight() <= maxWeight && things.add(thing)) {
            price += thing.getPrice();
            weight += thing.getWeight();
            return true;
        }
        return false;
    }

    public boolean remove(Thing thing) {
        if (things.remove(thing)) {
            price -= thing.getPrice();
            weight -= thing.getWeight();
            return true;
        }
        return false;
    }

    public void printThings() {
        things.stream()
                .sorted()
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Bag{" +
                "things=" + things.size() +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bag bag = (Bag) o;
        return things.equals(bag.things);
    }

    @Override
    public int hashCode() {
        return Objects.hash(things);
    }
}
