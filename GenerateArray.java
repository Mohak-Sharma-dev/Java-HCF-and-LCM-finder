
import java.util.ArrayList;
import java.util.Scanner;



public class GenerateArray {
    
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Lower and upper bounds of the Arraylist:\nLower Bound: ");
        int lowerbound = input.nextInt();
        System.out.println("Upper Bound: ");
        int upperbound = input.nextInt();

        for (int i = lowerbound; i <= upperbound; i++) {
            list.add(i);
        }

        System.out.println(list);

        System.out.println("Enter A certain range of numbers to print: ");
        System.out.println("First Number: ");
        int firstNumber = input.nextInt();
        System.out.println("Last Number: ");
        int lastNumber = input.nextInt();

        // int difference = lastNumber - firstNumber;


        // int count = 0;
        ArrayList<Integer> rangeofIntegers = new ArrayList<>();

        for (int i = 0; i <= list.size(); i++){
            // count++;
            int numbertocheck = 0;
            numbertocheck = list.get(i);
            if (numbertocheck < firstNumber) {
                System.out.println(numbertocheck + " is less than required range");
            } 
            else if (numbertocheck >= firstNumber && numbertocheck <= lastNumber) {
                // System.out.println(numbertocheck +" is the required number.");
                rangeofIntegers.add(numbertocheck);
            }
            else if(numbertocheck>lastNumber){
                System.out.println(numbertocheck+" is more than the required number.");
                break;
            }
            // try {
            //     numbertocheck = list.get(i);
            //     if (numbertocheck < firstNumber) {
            //         System.out.println(numbertocheck + " is less than required range");
            //     } else if (numbertocheck >= firstNumber && numbertocheck <= lastNumber) {
            //         System.out.println(numbertocheck +" is the the required number.");
            //     }
            // } catch (ArrayIndexOutOfBoundsException e) {
            //     System.err.println("Caught Exception: "+ e.getMessage());
            // }
            // finally{
            //     break;
            // }

            // else if (condition) {
                
            // }


            // if (firstNumber <= list.get(i) && lastNumber >= list.get(i)) {
                
            //     rangeofIntegers.add(i);

            // }
            // else if(lastNumber < list.get(i)){
            //     // rangeofIntegers.add(i);
            //     break;
            // }
        }

        System.out.println(rangeofIntegers);


        // for (Integer i : list) {
        //     if (firstNumber >= list.get(i) && lastNumber <= list.get(i)) {
        //         System.out.println(1);
        //     }
        //     i++;
        //     // System.out.println(i);
        // }



        
    }
}
