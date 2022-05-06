import java.util.*;
public class Activity2 {
    public static void main(String[] args) {
        int[] numbers= {10, 77, 10, 54, -11, 10};
        System.out.println("Original Array: " + Arrays.toString(numbers));

        int searchNum = 10;
        int Sum = 30;
        System.out.println("Result: " + result(numbers, searchNum, Sum));
    }

    public static boolean result(int[] numbers, int searchNum, int Sum) {
        int tempsum = 0;
        for (int number : numbers) {
             if (number == searchNum) {
             tempsum += searchNum;
            }
            if (tempsum == 30){
                System.out.println("Sum is:" + tempsum);
            }
            if (tempsum > Sum) {
                break;
            }
        }

        return tempsum == Sum;
    }
}