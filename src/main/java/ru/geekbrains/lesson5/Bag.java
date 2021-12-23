package ru.geekbrains.lesson5;

import java.util.HashSet;
import java.util.Set;

public class Bag {

    private final Set<Thing> things;
    private int weight;
    private int price;

    public Bag() {
        this.weight = 0;
        this.price = 0;
        this.things = new HashSet<>();
    }

    public Bag(Bag other) {
        this();
        this.weight = other.weight;
        this.price = other.price;
        this.things.addAll(other.things);
    }

    public boolean put(Thing thing) {
        if (things.add(thing)) {
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

    @Override
    public String toString() {
        return String.format("%d - %d : %s", price, weight, things.toString());
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

}
