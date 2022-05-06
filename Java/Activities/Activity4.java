import java.util.*;
public class Activity4 {
    static void ascendingsort(int array[])
    {
        int size = array.length;
        int i;


        for(i=1;i<size;i++){
            int k=array[i];
            int j=i-1;

            while (j>=0 && k< array[j])
            {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = k;
        }
    }

    public static void main(String[] args) {
        int array1[]= {7,4,2,3,8,6,9,1,5};
        System.out.println("Original Array is:" + Arrays.toString(array1));
        ascendingsort(array1);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(array1));
    }
}
