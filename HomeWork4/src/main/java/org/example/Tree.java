package org.example;

import java.util.*;

public class Tree {
    private Node root;

    private class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        add(root, value);
    }

    private void add(Node current, int value) {
        if (value == current.value) return;

        else if (value < current.value) {
            if (current.left == null) current.left = new Node(value);
            else add(current.left, value);
        } else if (value > current.value) {
            if (current.right == null) current.right = new Node(value);
            else add(current.right, value);
        }
    }

    public boolean contains(int value) {
        return findNode(root, value) != null;
    }

    private Node findNode(Node current, int value) {
        if (current == null) return null;
        if (current.value == value) return current;
        else if (current.value > value) return findNode(current.left, value);
        else return findNode(current.right, value);
    }
    public void remove(int value){
        removeNode(root, value);

    }

    /**
     * Метод
     * @param current
     * @param value значение, которое нужно удалить
     * @return Node которая встанет на место удаленной
     */
    private Node removeNode(Node current, int value){
        if (current == null) return null;
        if (current.value > value){
            current.left = removeNode(current.left, value);
            return current;
        } else if (current.value < value){
            current.right = removeNode(current.right, value);
            return current;
        }
//если удаляемый узел лист(у него нет детей, то на его место поставим null)
        if (current.left == null && current.right == null) return null;
        if (current.left != null && current.right == null) return current.left;
        if (current.left == null && current.right != null) return current.right;
        //ищем мин эл-т в правом поддереве
        Node smallestOnTheRight = findFirst(current.right);
        int smallValueOnTheRight = smallestOnTheRight.value;
        current.value = smallValueOnTheRight;
        current.right = removeNode(current.right, smallValueOnTheRight);
        return current;
    }
    private Node findFirst(Node current){
        if (current.left != null) return findFirst(current.left);
        return current;
    }
    public int findFirst(){
        if (root == null) throw new NoSuchElementException();
        return findFirst(root).value;
    }

    /**
     * Метод обхода дерева вглубину
     * @return
     */
    public List<Integer> dfs(){
        if (root == null) return List.of();
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return List.copyOf(result);
    }
    private void dfs(Node current, List<Integer> result){
        //во время обхода начинаем с корня но не добавляем его, проходим левую часть до листа, поднимаемся до узла, добавляем
        //узел и проходим правую часть данный метод обхода называется in-order. В pre-order обход с узла и первым узел
        //добавляется потом левая и правя части, а в post-order левая, правая затем узел
        if (current.left != null) dfs(current.left, result);
        result.add(current.value);
        if (current.right != null) dfs(current.right, result);
    }
    public List<Integer> bfs(){
        if (root == null) return List.of();
        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node next = queue.poll();
            result.add(next.value);
            if (next.left != null) queue.add(next.left);
            if (next.right != null) queue.add(next.right);
        }
        return result;
    }
    }


