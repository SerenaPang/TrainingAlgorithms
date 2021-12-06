package data.structures.queue;
/**
 * Implement a circular array: connect the start and end of the array, so that it's a circle
 * which means index of array length is at index 0
 *  method 1: record size, when size is 0 means empty, when size equals to the array length means it's full
 *  method 2: head is next to tail, next of head pointer points to the head of the queue
 *  when head + 1 is tail, it's empty(no elements in between)
 *  when head is tail, it's full
 * */
public class BoundedQueue {
    int head;
    int tail;
    int size;
    Integer[] array;
    public BoundedQueue(int capacity) {
        array = new Integer[capacity];
        head = tail = 0;
        size = 0;
    }

    public boolean offer(Integer element) {
        if (size == array.length) {
            return false;
        }
        array[tail] = element;
        if (tail + 1 == array.length) {
            tail = 0;
        } else {
            tail = tail + 1;
        }
        size++;
        return true;
    }


    public boolean offerII(Integer element) {

    }
}
