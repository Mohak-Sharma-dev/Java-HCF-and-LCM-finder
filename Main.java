
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main implements Runnable {

    private static int lowerbound;
    private static int upperbound;

    private static ArrayList<Integer> list = new ArrayList<>();
    private static ArrayList<Integer> listofPrimes = new ArrayList<>(Arrays.asList(2,3,5,7));
    private static ArrayList<Integer> rangeofPrimes = new ArrayList<>();

    public static Scanner input = new Scanner(System.in);

/*****************************************************************************************/

    public Main(){

    }

    public Main (int lowerbound,int upperbound, ArrayList<Integer> list, ArrayList<Integer> listofPrimes){
        Main.lowerbound = lowerbound;
        Main.upperbound = upperbound;
        Main.list = list;
        Main.listofPrimes = listofPrimes;
    }

    public static int getlowerbound(){
        return lowerbound;
    }
    public static void setlowerbound(int lowerbound){
        Main.lowerbound=lowerbound;
    }

    public static int getupperbound(){
        return upperbound;
    }
    public static void setupperbound(int upperbound){
        Main.upperbound = upperbound;
    }

    public static ArrayList<Integer> getList(){
        return list;
    }
    public static void setList(ArrayList<Integer> list){
        Main.list=list;
    }

    public static ArrayList<Integer> getListofPrimes(){
        return listofPrimes;
    }
    public static void setListofPrimes(ArrayList<Integer> listofPrimes){
        Main.listofPrimes = listofPrimes;
    }

    public static ArrayList<Integer> getRangeofPrimes(){
        return rangeofPrimes;
    }
    public static void setRangeofPrimes(ArrayList<Integer> rangeofPrimes){
        Main.rangeofPrimes = rangeofPrimes;
    }

/*****************************************************************************************/

    public static void main(String[] args) {
      
        Main t1 = new Main();

        Thread thread = new Thread(t1);

        Main.setlowerbound(1);

        System.out.println("Till what number do you want to generate primes to?  ");

        int upperlimit = input.nextInt();
        
        Main.setupperbound(upperlimit);

        ArrayList<Integer> listofIntegers = arrayListGenerator(Main.getlowerbound(), Main.getupperbound());
        
        arrayListPrinter(listofIntegers);
        
        thread.start();
    }

/*****************************************************************************************/

    public static ArrayList<Integer> arrayListGenerator(int lowerbound,int upperbound){

        ArrayList<Integer> listofIntegers = Main.getList();
        for (int i = lowerbound; i <= upperbound; i++) {
            listofIntegers.add(i);
        }

        Main.setList(listofIntegers);

        return listofIntegers;
    }

/*****************************************************************************************/

    public static ArrayList<Integer> arrayListGenerator(int upperbound){

        ArrayList<Integer> listofIntegers = Main.getList();

        for (int i = 10; i <= upperbound; i++) {
            listofIntegers.add(i);
        }

        Main.setList(listofIntegers);

        return listofIntegers;
    }

/*****************************************************************************************/

    public static void arrayListPrinter(ArrayList<Integer> listofIntegers){

        System.out.print("[");

        for (int i = 0; i < listofIntegers.size(); i++) {
            if (i == listofIntegers.size()-1) {
                
                System.out.print(listofIntegers.get(i)+"]");
            }
            else{
                System.out.print(listofIntegers.get(i)+", ");
            }
        }

    }

/*****************************************************************************************/

    public static boolean isPrime(int integertocheck, int primecheckedagainst, int forloopIteration){
       return integertocheck%primecheckedagainst != 0;
    }

/*****************************************************************************************/

    public static void rangeOfPrimes(ArrayList<Integer> listofPrimes){

        System.out.println("Enter your first number: ");
        int firstNum = input.nextInt();
        System.out.print("Enter your last number: ");
        int secondNum = input.nextInt();
        ArrayList<Integer> range = Main.getListofPrimes();

        for (int i = 0; i <= listofPrimes.size(); i++){
            // count++;
            int numberWithinRange = listofPrimes.get(i);
            // numberWithinRange = listofPrimes.get(i);
            if (numberWithinRange >= firstNum && numberWithinRange <= secondNum) {
                // System.out.println(numberWithinRange +" is the required number.");
                range.add(numberWithinRange);
            }
        }

        Main.setRangeofPrimes(range);

        System.out.println(Main.getRangeofPrimes());
        
    }

/*****************************************************************************************/

    @Override
    public void run(){

        Main.setListofPrimes(primenumberGenerator(Main.getList()));

        createAndSaveToFile(Main.getList(), Main.getListofPrimes());

    }

/*****************************************************************************************/

    public static ArrayList<Integer> primenumberGenerator(ArrayList<Integer> listofIntegers){

        ArrayList<Integer> initialPrimes = Main.getListofPrimes();

        for (int i = 10; i < listofIntegers.size(); i++) {

            int integer = listofIntegers.get(i);

            System.out.println("Checking for Integer: " + integer);

            int listcount = 0;

            for (int j = 0; j <= initialPrimes.size(); j++) {
                int prime = Main.getListofPrimes().get(j);

                if (isPrime(integer, prime, j) ) {

                    System.out.println(integer + " checked against "+ prime +" is a prime. \nChecking against the next.\n ");
                    
                    listcount++;

                    if(listcount == listofPrimes.size()){
                        listofPrimes.add(integer);
                        break;
                    }
                }
                else{
                    System.out.println(integer + " checked against " + prime +" is not a prime.\nSkipping\n");
                    break;
                }                
            }
        }

        Main.setListofPrimes(listofPrimes);

        System.out.println(Main.listofPrimes.size() + " Primes between " + Main.getList().getFirst() +" and " + Main.getList().getLast() );

        System.out.println(listofPrimes);        

        return listofPrimes;

    } 

/*****************************************************************************************/

    public static void createAndSaveToFile(ArrayList<Integer> listIntegers, ArrayList<Integer> listPrimes){
        try {
            BufferedWriter filewriter = new BufferedWriter(new FileWriter("lists.log",true));
            filewriter.write("\nArrayList of Integers:\n[");
            int rowcount = 0;
            for (int i = 0; i < listIntegers.size(); i++) {
                if (rowcount < 15) {
                    if (i == listIntegers.size()-1) {
                        filewriter.write(listIntegers.get(i)+"]");
                        // System.out.print(listIntegers.get(i)+"]");
                    }
                    else{
                        filewriter.write(listIntegers.get(i)+",");
                        // System.out.print(listIntegers.get(i)+", ");
                    }
                    rowcount++;
                }
                else{
                    filewriter.write("\n");
                    rowcount = 0;
                }
            }
            filewriter.write("\nArrayList of Primes:\n[");
            int rowcount2 = 0;
            for (int i = 0; i < listPrimes.size(); i++) {
                if (rowcount2 < 15) {
                    if (i == listPrimes.size()-1) {
                        filewriter.write(listPrimes.get(i)+"]");
                        // System.out.print(listIntegers.get(i)+"]");
                    }
                    else{
                        filewriter.write(listPrimes.get(i)+",");
                        // System.out.print(listIntegers.get(i)+", ");
                    }
                    rowcount2++;
                }
                else{
                    filewriter.write("\n");
                    rowcount2 = 0;
                }
            }
        filewriter.close();
        } catch (IOException ex) {
            System.out.println("IOException: "+ ex.getMessage());
        }
    }
}


