package ru.geekbrains.lesson7;

import java.util.*;

public class Graph<T> {

    private final Map<T, Map<T, Integer>> graph = new HashMap<>();

    public void addVertex(T label) {
        graph.put(label, new HashMap<>());
    }

    public boolean addEdge(T firstLabel, T secondLabel, int weight) {
        if (graph.containsKey(firstLabel) && graph.containsKey(secondLabel)) {
            graph.get(firstLabel).put(secondLabel, weight);
            graph.get(secondLabel).put(firstLabel, weight);
            return true;
        } else {
            return false;
        }
    }

    public List<T> adjacentVertexes(T label) {
        return new ArrayList<>(graph.getOrDefault(label, Collections.emptyMap()).keySet());
    }

    public Integer edgeWeight(T firstLabel, T secondLabel) {
        return graph.getOrDefault(firstLabel, Collections.emptyMap()).getOrDefault(secondLabel, Integer.MAX_VALUE);
    }
}
