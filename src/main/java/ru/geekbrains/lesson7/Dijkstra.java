package ru.geekbrains.lesson7;

import java.util.*;

public class Dijkstra<T> {

    private final Map<T, Integer> distMap = new HashMap<>();
    private final Map<T, T> fromMap = new HashMap<>();

    private int distToVertex(T label) {
        return distMap.getOrDefault(label, Integer.MAX_VALUE);
    }

    public Path<T> findPath(Graph<T> graph, T first, T last) {
        distMap.clear();
        fromMap.clear();
        PriorityQueue<T> queue = new PriorityQueue<>(this::CompareVertexByDist);

        // поиск пути
        distMap.put(first, 0);
        queue.add(first);
        while (!queue.isEmpty()) {
            T nearestVertex = queue.poll();
            for (T adjacentVertex : graph.adjacentVertexes(nearestVertex)) {
                int newDistToVertex = distToVertex(nearestVertex) + graph.edgeWeight(nearestVertex, adjacentVertex);
                if (distToVertex(adjacentVertex) > newDistToVertex) {
                    queue.remove(adjacentVertex);
                    distMap.put(adjacentVertex, newDistToVertex);
                    fromMap.put(adjacentVertex, nearestVertex);
                    queue.add(adjacentVertex);
                }
            }
        }

        // восстанавливаю путь
        Deque<T> path = new LinkedList<>();
        T current = last;
        while (current != null) {
            path.addFirst(current);
            current = fromMap.get(current);
        }

        return new Path<>(path, distToVertex(last));
    }

    private int CompareVertexByDist(T first, T second) {
        return distToVertex(first) - distToVertex(second);
    }

}
