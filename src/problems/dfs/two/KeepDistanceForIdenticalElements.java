package problems.dfs.two;

public class KeepDistanceForIdenticalElements {
       public static int[] keepDistance(int k) {
           int[] array = new int[2 * k];
           for (int i = 0; i < k; i++) {
               array[i * 2] = i + 1; //1 0 2 0
               array[i * 2 + 1] = i + 1; //1 1 2 2
           }
           boolean[] used= new boolean[k + 1];
           print(array);
           return helper(array, 0, used) ? array : null;
       }

        public static boolean helper(int[] array, int index, boolean[] used) {
           if (index == array.length) {
               return true;
           }
           for (int i = index; i < array.length; i++) {
               int cur = array[i];
               //if we found the same number in the right distance, do dfs
               if (!used[cur] || (index > cur && array[index - cur - 1] == cur)) {
                   swap(array, index, i);
                   used[cur] = !used[cur];
                   if (helper(array, index + 1, used)) {
                       return true;
                   }
                   swap(array, index, i);
                   used[cur] = !used[cur];
               }
           }
           return false;
        }

        public static void swap(int[] array, int x, int y) {
           int tmp = array[x];
           array[x] = array[y];
           array[y] = tmp;
        }
       public static void print(int[] array) {
           for (int i = 0; i < array.length; i++) {
               System.out.print(array[i] + " ");
           }
       }
    public static void main(String[] args) {
        keepDistance(2);
    }
}
