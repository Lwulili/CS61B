import java.util.Arrays;

public class ArrayDeque<T> {
    private T[] array;
    private int nextFirst;
    private int nextlLast;
    private int size;
    private int length;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        nextFirst = 4;
        nextlLast = 4;
        size = 0;
        length = 8;
    }

    public T[] expand(T[] array) {
        T[] newArray = Arrays.copyOf(array, length * 2);
        length *= 2;
        return newArray;
    }

    public T[] shrink(T[] array) {
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
        nextFirst--;
        if (nextFirst == 0) nextFirst = length - 1;
    }

    public void addLast(T item) {
        if (size == length) {
            expand(array);
        }
        array[nextlLast] = item;
        nextlLast++;
        size++;
        if (nextlLast == length - 1) nextlLast = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (T item : array) {
            System.out.println(item);
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = array[nextFirst];
        array[nextFirst] = null;
        size--;
        if (nextFirst == length - 1) {
            nextFirst = 0;
        } else {
            nextFirst++;
        }
        if (size * 4 < length) {
            shrink(array);
        }
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T item = array[nextlLast];
        array[nextlLast] = null;
        size--;
        nextlLast--;
        if (nextlLast == 0) {
            nextlLast = array.length - 1;
        } else {
            nextlLast--;
        }
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
