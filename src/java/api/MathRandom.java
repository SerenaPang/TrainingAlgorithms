package java.api;

public class MathRandom {
    public static void main(String[] args) {
        //define the range
        int min = 1;
        int max = 10;

        int range = max - min + 1; //10
        //generate a number range from 1 to 10 including 10
        int rand = (int) (Math.random() * range) + min;
    }
}
