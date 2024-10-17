import java.util.Deque;
import java.util.ArrayDeque;

public class B1 {

    public static class Tuple2<K, V> { // Generic, классы-обёртки

        private K last;
        private V current;

        public Tuple2(K first, V second) {
            this.last = first;
            this.current = second;
        }
    }

    static class Node {
        int data;
        Node next, child;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }
    }

    public static void addNode(Node head, Node node, boolean isChild) {
        Node next = head.next;
        Node child = head.child;
        if (isChild) {
            head.child = node;
            node.child = child;
        } else {
            head.next = node;
            node.next = next;
        }
    }

    public static Tuple2<Node, Node> search(Node node, int data, Node left) {
        Tuple2<Node, Node> res = new Tuple2<Node, Node>(null, null);
        if (node == null) {
            return res;
        }
        if (node.data == data) {
            res.last = left;
            res.current = node;
            return res;
        }

        if (node.next != null) {
            res = search(node.next, data, node);
        }
        if (res.current != null) {
            return res;
        }
        if (node.child != null) {
            res = search(node.child, data, node);
        }

        return res;
    }

    public static int removeNode(Node head, int data) {
        Tuple2<Node, Node> res = search(head, data, null);
        if (res.current == null) {
            return -1;
        }
        if (res.last != null) {
            if (res.last.child != null) {
                if (res.last.child.data == data) {
                    res.last.child = null;
                }
            }
            if (res.last.next != null) {
                if (res.last.next.data == data) {
                    res.last.next = res.last.next.next;
                }
            }
        }
        return 0;
    }

    public static void showListDirOrder(Node head) {
        Deque<Node> heads = new ArrayDeque<Node>();
        heads.add(head);
        while (!heads.isEmpty()) {
            Node curr_head = heads.poll();
            while (curr_head != null) {
                System.out.print(curr_head.data);
                if (curr_head.child != null) {
                    heads.add(curr_head.child);
                    System.out.print("(" + curr_head.child.data + ")");
                }
                System.out.print(" ");
                curr_head = curr_head.next;
            }
            System.out.println();
        }
    }

    public static void showListRevOrder(Node head) {
        if (head == null) {
            return;
        }

        showListRevOrder(head.next);
        showListRevOrder(head.child);
        System.out.print(head.data);

        if (head.child != null) {
            System.out.print("(" + head.child.data + ")");
        }
        System.out.print(" ");
    }

    public static int count(Node head, int data) {
        if (head == null) {
            return 0;
        }
        int count = 0;
        if (head.data == data) {
            count = 1;
        }
        return count(head.next, data) + count(head.child, data) + count;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        // Добавление
        Node tmp = new Node(42);
        Node three = new Node(3);
        addNode(head, three, false);
        addNode(head, new Node(123), false);
        addNode(three, new Node(123), true);
        addNode(head, tmp, false);
        addNode(tmp, new Node(100), true);
        addNode(tmp, new Node(60), true);


        System.out.println("---------------\nПоиск 123.");
        // Поиск элемента
        Tuple2<Node, Node> res = search(head, 123, null);
        if (res.current != null) {
            System.out.println("Найден: " + res.current.data);
        } else {
            System.out.println("Элемент не найден.");
        }

        System.out.println("---------------\nКоличество 123: " + count(head, 123));
        System.out.println("---------------");
        showListDirOrder(head);
        System.out.println("---------------\nУдаление 42.");

        // Удаление элемента
        int code = removeNode(head, 42);
        System.out.println("Code: " + code);
        showListDirOrder(head);
        System.out.println("---------------\nВывод в глубину (в обратном порядке).");
        showListRevOrder(head);
    }
}
