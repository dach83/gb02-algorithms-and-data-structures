package ru.geekbrains.lesson4;

import java.util.Iterator;

public class LinkedList<E> implements Deque<E>, Iterable<E> {

    private Node<E> first = null;
    private Node<E> last = null;
    private int size = 0;

    @Override
    public void insertFirst(E value) {
        Node<E> f = first;
        first = new Node<>(value, null, f);
        if (f == null)
            last = first;
        else
            f.prev = first;

        size++;
    }

    @Override
    public void insertLast(E value) {
        Node<E> l = last;
        last = new Node<>(value, l, null);
        if (l == null)
            first = last;
        else
            l.next = last;

        size++;
    }

    @Override
    public void insert(E value, int index) {
        if (index <= 0) {
            insertFirst(value);
            return;
        } else if (index >= size) {
            insertLast(value);
            return;
        }

        Node<E> current;
        int currentIndex;
        if (index < size / 2) { // ищем сначала списка - если элемент в первой половине
            current = first;
            currentIndex = 0;
            while (index != currentIndex) {
                current = current.next;
                currentIndex++;
            }
        } else { // ищем с конца списка - если элемент во второй половине
            current = last;
            currentIndex = size - 1;
            while (index != currentIndex) {
                current = current.prev;
                currentIndex--;
            }
        }

        Node<E> node = new Node<>(value, current.prev, current);
        if (node.prev != null)
            node.prev.next = node;
        current.prev = node;
        size++;
    }

    @Override
    public E removeFirst() {
        if (size == 0)
            return null;

        Node<E> f = first;
        E value = f.value;

        first = f.next;
        f.next = null;
        f.value = null;
        if (first == null)
            last = null;
        else
            first.prev = null;

        size--;
        return value;
    }

    @Override
    public E removeLast() {
        if (size == 0)
            return null;

        Node<E> l = last;
        E value = l.value;

        last = l.prev;
        l.prev = null;
        l.value = null;
        if (last == null)
            first = null;
        else
            last.next = null;

        size--;
        return value;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = first;
        while (current != null) {
            if (current.value.equals(value)) {
                if (current.prev != null)
                    current.prev.next = current.next;
                if (current.next != null)
                    current.next.prev = current.prev;
                current.value = null;
                current.prev = null;
                current.next = null;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public E getFirst() {
        return (first != null) ? first.value : null;
    }

    @Override
    public E getLast() {
        return (last != null) ? last.value : null;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size - 1)
            return null;

        Node<E> current;
        int currentIndex;
        if (index < size / 2) { // ищем сначала списка - если элемент в первой половине
            current = first;
            currentIndex = 0;
            while (index != currentIndex) {
                current = current.next;
                currentIndex++;
            }
        } else { // ищем с конца списка - если элемент во второй половине
            current = last;
            currentIndex = size - 1;
            while (index != currentIndex) {
                current = current.prev;
                currentIndex--;
            }
        }
        return current.value;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = first;
        while (current != null) {
            if (current.value.equals(value))
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        boolean first = true;
        for (E e : this) {
            if (!first)
                sb.append("-");
            sb.append(e);
            first = false;
        }
        return sb.append("]").toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new NextIterator<>(first);
    }

    private static class Node<E> {
        E value;
        Node<E> prev;
        Node<E> next;

        public Node(E value, Node<E> prev, Node<E> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private static class NextIterator<E> implements Iterator<E> {

        private Node<E> current;

        public NextIterator(Node<E> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            Node<E> res = current;
            current = current.next;
            return res.value;
        }
    }

}
