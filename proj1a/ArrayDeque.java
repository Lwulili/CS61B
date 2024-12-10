
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

    /*this is ugly, there is a smarter way
    private T[] expand(T[] a) {
        T[] newArray = Arrays.copyOf(array, length * 2);
        length *= 2;
        return newArray;
    }

    private T[] shrink(T[] a) {
        T[] newArray = Arrays.copyOf(array, length / 2);
        length /= 2;
        return newArray;
    }*/

    private void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        System.arraycopy(array, nextFirst, newArray, 0, size);
        array = newArray;
        nextFirst = 0;
        nextLast = size;
        length = newSize;
    }

    public void addFirst(T item) {
        if (size == length) {
            resize(length * 2);
        }
        /*first update the index, then update the data
        * the slow pointer
        * */
        nextFirst = (nextFirst == 0) ? length - 1 : nextFirst - 1;
        array[nextFirst] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == length) {
            resize(length * 2);
        }
        /*first update the data, then update the index
        * the fast pointer
        * */
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
        /*print from the data which index is 0
        for (T item : array) {
            System.out.print(item + " ");
        }*/

        //print from the first data
        for (int i = 0; i < size; i++) {
            System.out.print(array[nextFirst] + " ");
            nextFirst = (nextFirst + i) % length;
        }
        System.out.println();
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
            resize(length / 2);
        }
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        nextLast = (nextLast == 0) ? length - 1 : nextLast - 1;
        T item = array[nextLast];
        array[nextLast] = null;
        size--;
        if (size * 4 < length) {
            resize(length / 2);
        }
        return item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        index = (index + nextFirst) % length;
        return array[index];
    }
}
