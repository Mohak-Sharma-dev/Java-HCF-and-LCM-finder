
import java.util.Arrays;


public class CompareArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[10];


        for (int i = 1; i < arr1.length; i++) {
            arr1[i] = i;
        }

        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[10];

        for(int j = 1; j < arr2.length ; j++){

            if (arr1[j]%2!=0) {

            }
            else{
                arr2[j] = arr1[j];
            }

        }

        System.out.println(Arrays.toString(arr2));
        
    }
}
