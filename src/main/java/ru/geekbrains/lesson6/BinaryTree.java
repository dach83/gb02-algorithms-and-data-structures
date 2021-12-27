package ru.geekbrains.lesson6;

import java.util.Stack;

public class BinaryTree<E extends Comparable<? super E>> {
    private final int maxDeepLevel;
    private Node<E> root = null;

    public BinaryTree(int maxDeepLevel) {
        this.maxDeepLevel = maxDeepLevel;
    }

    public boolean add(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        if (nodeAndParent.currentDeepLevel > maxDeepLevel) {
            return false;
        }

        if (nodeAndParent.current != null) {
            nodeAndParent.current.setValue(value);
            return true;
        }

        Node<E> parent = nodeAndParent.parent;
        Node<E> node = new Node<>(value);
        if (isEmpty()) {
            root = node;
        } else if (parent.isLeftChildValue(value)) {
            parent.setLeftChild(node);
        } else {
            parent.setRightChild(node);
        }
        return true;
    }

    private NodeAndParent doFind(E value) {
        int currentDeepLevel = 1;
        Node<E> current = root;
        Node<E> parent = null;
        while (current != null) {
            if (current.getValue().equals(value))
                return new NodeAndParent(current, parent, currentDeepLevel);

            currentDeepLevel++;
            parent = current;
            if (current.isLeftChildValue(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        return new NodeAndParent(null, parent, currentDeepLevel);
    }

    public boolean isEmpty() {
        return root == null;
    }

    private boolean isBalancedTree(Node<E> node, int currentLevel, MinAndMaxLeafLevel minAndMaxLeafLevel) {
        if (node == null) {
            return minAndMaxLeafLevel
                    .updateLevels(currentLevel)
                    .isBalancedTree();
        }

        currentLevel++;
        return isBalancedTree(node.getLeftChild(), currentLevel, minAndMaxLeafLevel) &&
                isBalancedTree(node.getRightChild(), currentLevel, minAndMaxLeafLevel);
    }

    public boolean isBalancedTree() {
        MinAndMaxLeafLevel minAndMaxLeafLevel = new MinAndMaxLeafLevel(maxDeepLevel, 0);
        return isBalancedTree(root, 0, minAndMaxLeafLevel);
    }

    public void display() {
        Stack<Node<E>> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node<E>> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node<E> tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }


    private static class Node<T extends Comparable<? super T>> {
        private T value;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }

        public boolean isLeaf() {
            return leftChild == null && rightChild == null;
        }

        public boolean isLeftChildValue(T value) {
            return getValue().compareTo(value) > 0;
        }
    }

    private static class MinAndMaxLeafLevel {
        private int minLevel;
        private int maxLevel;

        public MinAndMaxLeafLevel(int minDeepLevel, int maxDeepLevel) {
            this.minLevel = minDeepLevel;
            this.maxLevel = maxDeepLevel;
        }

        public MinAndMaxLeafLevel updateLevels(int currentLevel) {
            if (minLevel > currentLevel) {
                minLevel = currentLevel;
            }
            if (maxLevel < currentLevel) {
                maxLevel = currentLevel;
            }
            return this;
        }

        public boolean isBalancedTree() {
            return maxLevel - minLevel <= 1;
        }

        @Override
        public String toString() {
            return "MinAndMaxLeafLevel{" +
                    "minLevel=" + minLevel +
                    ", maxLevel=" + maxLevel +
                    ", isBalanced=" + isBalancedTree() +
                    "}";
        }
    }

    private class NodeAndParent {
        private final Node<E> current;
        private final Node<E> parent;
        private final int currentDeepLevel;

        public NodeAndParent(Node<E> current, Node<E> parent, int currentDeepLevel) {
            this.current = current;
            this.parent = parent;
            this.currentDeepLevel = currentDeepLevel;
        }
    }
}
