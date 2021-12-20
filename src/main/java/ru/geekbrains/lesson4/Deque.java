package ru.geekbrains.lesson4;

public interface Deque<E> {

    void insertFirst(E value);
    void insertLast(E value);
    void insert(E value, int index);

    E removeFirst();
    E removeLast();
    boolean remove(E value);

    E getFirst();
    E getLast();
    E get(int index);

    boolean contains(E value);

    int size();

    boolean isEmpty();
}
