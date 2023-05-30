package org.example;

public class Main {
    public static void main(String[] args) {
//        MyLinkedList myList = new MyLinkedList();
//        boolean empty = myList.isEmpty();
//        if(empty) System.out.println("Список пуст! Длина списка: " + myList.size());
//        myList.add(1);
//        myList.add(2);
//        myList.add(3);
//        myList.add(4);
//        System.out.println(myList);
//        System.out.println("Длина списка: " + myList.size());
//        boolean hasElement = myList.contains(5);
//        if (hasElement) System.out.println("Элемент есть");
//        else System.out.println("Элемента нет");
//        MyLinkedList newList = new MyLinkedList();
//        newList = myList.reversed();
//        System.out.println(newList);
        LinkedListJeneric<String> list = new LinkedListJeneric<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        LinkedListJeneric<String> listRevers = new LinkedListJeneric<>();
        listRevers = list.reversed();
        System.out.println(listRevers);

    }
}