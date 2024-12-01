public class LinkedListDeque<T> {
    private Node node;
    private int size;
    private Node dummyHead;
    private Node dummyTail;

    public class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public LinkedListDeque() {
        dummyHead = dummyTail = null;
        dummyHead.prev = dummyTail;
        dummyTail.next = dummyHead;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item, null, null);
        dummyHead.next = newNode;
        newNode.prev = dummyHead;
        size++;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, null, null);
        newNode.next = dummyTail;
        dummyTail.prev = newNode;
        size++;
    }

    public boolean isEmpty() {
        if (node.item == null) {
            return false;
        } else {
            return true;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (!isEmpty()) {
            System.out.println(node.item + " ");
            while (node.next != null) {
                System.out.println(node.next.item + " ");
            }
        }
    }

    public T removeFirst() {
        T item = dummyHead.next.item;
        dummyHead.next = dummyHead.next.next;
        dummyHead.next.next.prev = dummyHead;
        return item;
    }

    public T removeLast() {
        T item = dummyTail.prev.item;
        dummyTail.prev = dummyTail.prev.prev;
        dummyTail.prev.prev.next = dummyTail;
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
        if (index == 0) {
            return dummyHead.next.item;
        }
        return getRecursiveHelp(dummyHead.next, index - 1);
    }

    private T getRecursiveHelp(Node state, int index) {
        if (index == 0) {
            return state.item;
        } else {
            node = state.next;
            return getRecursiveHelp(node, index - 1);
        }
    }
}