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
    //remember the head and tail is at the same position
    public BoundedQueue(int capacity) {
        array = new Integer[capacity];
        head = tail = 0;
        size = 0;
    }
    /**
     * when adding a new element to a circular queue,
     * case 1: if the size is full, we are not allow to add more elements
     * case 2:if the queue is not full
     * case 2.1: if the position to add element is the tail, tail index has to set to 0
     * case 2.2: if the position to add is not the tail, then increment the index
     * */
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
    //check the first element of the queue
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[head];
    }
    /**
     * poll the last element of the queue out
     * if we are polling the only element in the array, we need to set the head to be at position 0
     * */
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        Integer result = array[head];
        head = head + 1 == array.length ? 0 : head + 1;
        size--;
        return result;
    }

    public int size() {
        return  size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return  size == array.length;
    }
}
