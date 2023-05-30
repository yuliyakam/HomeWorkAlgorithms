package org.example;

public class LinkedListJeneric<T> {
    Node<T> head;

        private class Node<T> {
            T value;
           Node<T> next;

            public Node(T value) {
                this.value = value;
            }

        }

        /**
         * Метод проверки списка на пустоту
         *
         * @return true если список пустой
         */
        public boolean isEmpty() {
            return head == null;
        }

        /**
         * Метод поиска последнего элемента
         *
         * @return последний элемент последовательности
         */
        private Node<T> findLast() {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            return current;
        }

        /**
         * Метод добавления нового элемента в конец списка
         *
         * @param value значение элемента для вставки
         */
        public void add(T value) {
            if (head == null) {
                head = new Node<>(value);
            } else {
                Node<T> last = findLast();
                last.next = new Node<>(value);
            }
        }

        /**
         * Метод определения длины списка
         *
         * @return кол-во элементов
         */
        public int size() {
            Node<T> current = head;
            int count = 0;
            if (head == null) return 0;
            else {
                while (current != null) {
                    count++;
                    current = current.next;
                }
                return count;
            }
        }

        /**
         * Метод поиска эелемента по значению
         *
         * @param value значение искомого элемента
         * @return true если елемент есть
         */
        public boolean contains(T value) {
            Node<T> current = head;
            while (current != null) {
                if (current.value == value) return true;
                current = current.next;
            }
            return false;
        }

        /**
         * Метод разворота списка
         *
         * @return новый развернутый список
         */
        public LinkedListJeneric<T> reversed() {
            LinkedListJeneric<T> reverseadList = new LinkedListJeneric<>();
            addRecursiv(head, reverseadList);
            reverseadList.add(head.value);
            return reverseadList;
        }

        private void addRecursiv(Node<T> node, LinkedListJeneric<T> list) {
            if (node.next != null) {
                addRecursiv(node.next, list);
                list.add(node.next.value);
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Node<T> current = head;
            while (current != null) {
                sb.append(current.value).append(" -> ");
                current = current.next;
            }
            int length = sb.length();
            if (length > 4) sb.delete(length - 4, length);
            sb.append("]");
            return sb.toString();
        }
}
