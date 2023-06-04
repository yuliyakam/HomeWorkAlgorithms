package org.example;

import java.util.*;

public class GenericTree<T extends Comparable<T>> {
    private Node<T> root;
    private class Node<T>{
        Node<T> left;
        Node<T> right;
        T value;

        public Node(T value) {
            this.value = value;
        }

    }
    public void add(T value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        add(root, value);
    }

    private void add(Node<T> current, T value) {
        if (value.compareTo(current.value) == 0) return;

        else if (value.compareTo(current.value) < 0) {
            if (current.left == null) current.left = new Node(value);
            else add(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            if (current.right == null) current.right = new Node(value);
            else add(current.right, value);
        }
    }
    public boolean contains(T value) {
        return findNode(root, value) != null;
    }
    private Node<T> findNode(Node<T> current, T value) {
        if (current == null) return null;
        if (current.value.compareTo(value) == 0) return current;
        else if (current.value.compareTo(value) > 0) return findNode(current.left, value);
        else return findNode(current.right, value);
    }
    public void remove(T value){
        removeNode(root, value);

    }
    private Node<T> removeNode(Node<T> current, T value){
        if (current == null) return null;
        if (current.value.compareTo(value) > 0){
            current.left = removeNode(current.left, value);
            return current;
        } else if (current.value.compareTo(value) < 0){
            current.right = removeNode(current.right, value);
            return current;
        }
        if (current.left == null && current.right == null) return null;
        if (current.left != null && current.right == null) return current.left;
        if (current.left == null && current.right != null) return current.right;

        Node<T> smallestOnTheRight = findFirst(current.right);
        T smallValueOnTheRight = smallestOnTheRight.value;
        current.value = smallValueOnTheRight;
        current.right = removeNode(current.right, smallValueOnTheRight);
        return current;
    }
    private Node<T> findFirst(Node<T> current){
        if (current.left != null) return findFirst(current.left);
        return current;
    }
    public T findFirst(){
        if (root == null) throw new NoSuchElementException();
        return findFirst(root).value;
    }
    public List<T> dfs(){
        if (root == null) return List.of();
        List<T> result = new ArrayList<>();
        dfs(root, result);
        return List.copyOf(result);
    }
    private void dfs(Node<T> current, List<T> result){
        if (current.left != null) dfs(current.left, result);
        result.add(current.value);
        if (current.right != null) dfs(current.right, result);
    }
    public List<T> bfs(){
        if (root == null) return List.of();
        List<T> result = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node<T> next = queue.poll();
            result.add(next.value);
            if (next.left != null) queue.add(next.left);
            if (next.right != null) queue.add(next.right);
        }
        return result;
    }

}
