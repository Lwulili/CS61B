public class LinkedListDeque<T> {
    private Node node;
    private int size;
    private Node dummyHead;
    private Node dummyTail;

    public class Node {
        private Node prev;
        private T item;
        private Node next;

        private Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

    }

    public LinkedListDeque() {
        dummyHead = new Node(null, null, null);
        dummyTail = new Node(null, dummyHead, null);
        dummyHead.next = dummyTail;
        size = 0;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item, dummyHead, dummyHead.next);
        dummyHead.next.prev = newNode;
        dummyHead.next = newNode;
        size++;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, dummyTail.prev, dummyTail);
        dummyTail.prev.next = newNode;
        dummyTail.prev = newNode;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (!isEmpty()) {
            Node currentHead = dummyHead.next;
            while (currentHead != null) {
                System.out.println(currentHead.item + " ");
                currentHead = currentHead.next;
            }
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = dummyHead.next.item;
        dummyHead.next = dummyHead.next.next;
        dummyHead.next.prev = dummyHead;
        size--;
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T item = dummyTail.prev.item;
        dummyTail.prev = dummyTail.prev.prev;
        dummyTail.prev.next = dummyTail;
        size--;
        return item;
    }

    public T get(int index) {
        int count = 0;
        node = dummyHead.next;
        while (count != index) {
            count++;
            node = node.next;
        }
        return node.item;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursiveHelp(dummyHead.next, index);
    }

    private T getRecursiveHelp(Node state, int index) {
        if (index == 0) {
            return state.item;
        } else {
            return getRecursiveHelp(state.next, index - 1);
        }
    }
}