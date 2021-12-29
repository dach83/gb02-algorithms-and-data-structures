package ru.geekbrains.lesson7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Path<T> {
    private final List<T> path;
    private final int weight;

    public Path(Collection<T> path, int weight) {
        this.path = new ArrayList<>(path);
        this.weight = weight;
    }

    public void display() {
        System.out.println(this);
    }
    
    @Override
    public String toString() {
        return "weight: " + weight + " - " + path;
    }
}
