package data.structures.stack;

public class BoundStack {
    int[] array;
    int head;
    public BoundStack(int capacity) {
        array = new int[capacity];
        head = -1;
    }

    public boolean push(int element) {
        if (head == array.length - 1) {
            return false;
        }
        array[++head] = element;
        return true;
    }

    public Integer pop() {
        if (head == -1) {

        }
        return -1;
    }
}
