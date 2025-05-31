
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumberGenerator {


/**************************************************Attributes***************************************************************/

    private static int num1;
    private static int num2;
    private static int largestofboth;
    private static int smallestofboth;

    private static ArrayList<Integer> integerList = new ArrayList<>(Arrays.asList());
    private static ArrayList<Integer> primesList  = new ArrayList<>(Arrays.asList(2,3,5,7));

/******************************************************Constructors***********************************************************/

    public PrimeNumberGenerator(){

    }

    public PrimeNumberGenerator(int num1, int num2, int largestofboth, int smallestofboth, ArrayList<Integer> integerList, ArrayList<Integer> primesList) {
        PrimeNumberGenerator.num1 = num1;
        PrimeNumberGenerator.num2 = num2;
        PrimeNumberGenerator.largestofboth = largestofboth;
        PrimeNumberGenerator.smallestofboth  =smallestofboth;

        PrimeNumberGenerator.integerList = integerList;
        PrimeNumberGenerator.primesList = primesList;
    }

/*******************************************************Setters**********************************************************/

    public static void setNum1(int num1){
        PrimeNumberGenerator.num1 =num1;
    }
    public static void setNum2(int num2){
        PrimeNumberGenerator.num2 = num2;
    }
    public static void setLargestofBoth(int largestofboth){
        PrimeNumberGenerator.largestofboth = largestofboth;
    }
    public static void setSmallestofBoth(int smallestofboth){
        PrimeNumberGenerator.smallestofboth = smallestofboth;
    }
    public static void setIntegerList(ArrayList<Integer> integerList){
        PrimeNumberGenerator.integerList = integerList;
    }
    public static void setPrimesList(ArrayList<Integer> primesList){
        PrimeNumberGenerator.primesList = primesList;
    }

/*******************************************************Getters**********************************************************/

    public static int getNum1(){
        return num1;
    }
    public static int getNum2(){
        return num2;
    }
    public static int getLargestofBoth(){
        return largestofboth;
    }
    public static int getSmallestofBoth(){
        return smallestofboth;
    }
    public static ArrayList<Integer> getIntegerList(){
        return integerList;
    }
    public static ArrayList<Integer> getPrimesList(){
        return primesList;
    }

/*****************************************************************************************************************/

    public static void main(String[] args){

        int num1;
        int num2;
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter num1: ");
            num1 = input.nextInt();
            System.out.println("Enter num2: ");
            num2 = input.nextInt();
        }

        ArrayList<Integer> result = generatePrimesList(num1, num2);

        System.out.println(result);

        System.out.println("Primes total between "+num1+" and "+ num2+ ": "+result.size());
    }

/*****************************************************************************************************************/

    public static int findLargestofBoth(int a, int b) throws IllegalArgumentException {

        if(a>b){
            PrimeNumberGenerator.setLargestofBoth(a);
            PrimeNumberGenerator.setSmallestofBoth(b);
            return a;
        }
        else if(b>a){
            PrimeNumberGenerator.setLargestofBoth(b);
            PrimeNumberGenerator.setSmallestofBoth(a);
            return b; 
        }
        else{
            PrimeNumberGenerator.setLargestofBoth(0);
            return 0; 
        }
    }

/*****************************************************************************************************************/

    public static int findSmallestofBoth(int a, int b) throws IllegalArgumentException {

        if(a<b){
            PrimeNumberGenerator.setSmallestofBoth(a);
            PrimeNumberGenerator.setLargestofBoth(b);
            return a;
        }
        else if(b<a){
            PrimeNumberGenerator.setSmallestofBoth(b);
            PrimeNumberGenerator.setLargestofBoth(a);
            return b; 
        }
        else{
            PrimeNumberGenerator.setLargestofBoth(0);
            return 0; 
        }
    }

/*****************************************************************************************************************/

    public static ArrayList<Integer> arrayListGenerator(int largestNumber){

        ArrayList<Integer> listofIntegers = PrimeNumberGenerator.getIntegerList();

        for (int i = 1; i <= largestNumber; i++) {
            listofIntegers.add(i);
        }

        PrimeNumberGenerator.setIntegerList(listofIntegers);

        return listofIntegers;
    }

/*****************************************************************************************************************/

    public static boolean isPrime(int integertocheck, int primecheckedagainst, int forloopIteration){
       return integertocheck%primecheckedagainst != 0;
    }

/*****************************************************************************************************************/

    public static ArrayList<Integer> primenumberGenerator(ArrayList<Integer> listofIntegers){

        ArrayList<Integer> initialPrimes = PrimeNumberGenerator.getPrimesList();

        for (int i = 1; i < listofIntegers.size(); i++) {

            int integer = listofIntegers.get(i);

            // System.out.println("Checking for Integer: " + integer);

            int listcount = 0;

            for (int j = 0; j <= initialPrimes.size(); j++) {

                int prime = PrimeNumberGenerator.getPrimesList().get(j);

                if (isPrime(integer, prime, j) ) {

                    // System.out.println(integer + " checked against "+ prime +" is a prime.\n");
                    
                    listcount++;

                    if(listcount == PrimeNumberGenerator.primesList.size()){
                        primesList.add(integer);
                        break;
                    }
                }
                else{
                    // System.out.println(integer + " checked against " + prime +" is not a prime.\n");
                    break;
                }                
            }
        }

        PrimeNumberGenerator.setPrimesList(primesList);       

        return primesList;

    } 
/*****************************************************************************************************************/

    public static ArrayList<Integer> generatePrimesList(int a,int b){

        try {
            findLargestofBoth(a, b);
        } catch (IllegalArgumentException e) {
            System.err.println("Exception: " + e.getMessage());
        }

        ArrayList<Integer> primes = primenumberGenerator(arrayListGenerator(findLargestofBoth(a, b)));


        // List<Integer> rangeofprimes = primes.subList(a, b);

        // ArrayList<Integer> rangeOfprimesList = (ArrayList<Integer>) primes.subList(a, b);

        ArrayList<Integer> rangeOfprimesList = new ArrayList<>();

        for (int i = 0; i < primes.size(); i++) {
            int num = primes.get(i);
            if (num <= findLargestofBoth(a, b) && num >= findSmallestofBoth(a, b) ) {
                rangeOfprimesList.add(num);
            }
        }

        System.out.println("Primes Between "+a+" and "+b+": " + rangeOfprimesList.size());

        return rangeOfprimesList;
    }
    
    
}
