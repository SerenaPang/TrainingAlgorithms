package problems.binary.search;

import java.util.Dictionary;
import java.util.Hashtable;
/**
 *  find the target in the unknown size sorted array, return the index of the target
 *  TC: O(logn + n)
 *  SC: O(1)
 * */
public class SearchInUnknownSizedSortedArray {
    /**
     *  if dictionary out of bound, it will return null, so we know if right returns null, we reach the end of the dictionary(or out of bound)
     *  target: 2
     *  0 1 2 3
     *  1,2,5,9......
     *
     *  left is the first element, right will be the element next to left
     *  we keep expand right boundary, until it's bigger than target(must be within the boundary)
     *  so that the target it's in the range of left and right
     *  and then we do binary search within the left and right bound
     * */
    public int search(Dictionary dict, int target) {
        //find the boundary that include the target within the range of left and right
        int left = 0;
        int right = left + 1;
        while (dict.get(right) != null && (int)dict.get(right) < target) {
            left = right;
            right = right * 2;
        }
        System.out.println("left: " + left + " right: " + right);
        //since we expand the right bound by 2 each time, it might go over the bound so the value is null
        //start binary search with the boundary
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dict.get(mid) == null || (int)dict.get(right) > target) {
                right = mid - 1;
            } else if ((int)dict.get(mid) < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Hashtable();
        //key: index value: values in the dictionary
        dictionary.put(0,1);
        dictionary.put(1,2);
        dictionary.put(2,5);
        dictionary.put(3,9);
        dictionary.put(4,12);

        int target = 5;//should return 2
        SearchInUnknownSizedSortedArray s = new SearchInUnknownSizedSortedArray();
        int result = s.search(dictionary, target);
        System.out.println(target + " appears at index " + result);
    }
}
