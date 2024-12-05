import java.util.Arrays;

public class ArrayDeque<T> {
    private T[] array;
    private int nextFirst;
    private int nextLast;
    private int size;
    private int length;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        nextFirst = 4;
        nextLast = 4;
        size = 0;
        length = 8;
    }

    private T[] expand(T[] a) {
        T[] newArray = Arrays.copyOf(array, length * 2);
        length *= 2;
        return newArray;
    }

    private T[] shrink(T[] a) {
        T[] newArray = Arrays.copyOf(array, length / 2);
        length /= 2;
        return newArray;
    }

    public void addFirst(T item) {
        if (size == length) {
            array = expand(array);
        }
        array[nextFirst] = item;
        size++;
        nextFirst = (nextFirst == 0) ? length - 1 : nextFirst - 1;
    }

    public void addLast(T item) {
        if (size == length) {
            expand(array);
        }
        array[nextLast] = item;
        nextLast = (nextLast + 1) % length;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (T item : array) {
            System.out.println(item + " ");
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = array[nextFirst];
        array[nextFirst] = null;
        size--;
        nextFirst = (nextFirst + 1) % length;
        if (size * 4 < length) {
            shrink(array);
        }
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T item = array[nextLast];
        array[nextLast] = null;
        size--;
        nextLast = (nextLast == 0) ? length - 1 : nextLast - 1;
        if (size * 4 < length) {
            shrink(array);
        }
        return item;
    }

    public T get(int index) {
        if (index < size && index >= 0) {
            return array[index];
        } else {
            return null;
        }
    }
}
