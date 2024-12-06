public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDequemy<String> deque = new ArrayDequemy<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        deque.addFirst("d");
        deque.addLast("e");
        deque.addLast("f");
        deque.addLast("g");
        deque.addLast("h");
        deque.addFirst("i");
        deque.printDeque();
    }
}
