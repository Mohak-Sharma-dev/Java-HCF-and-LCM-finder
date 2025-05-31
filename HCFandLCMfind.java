
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class HCFandLCMfind extends PrimeNumberGenerator {
    
    private static double  hcf;
    private static double  lcm;

    private static double  getHCF(){ return hcf;}
    private static double  getLCM(){ return lcm;}

    private static void setHCF(double hcf){HCFandLCMfind.hcf = hcf;}
    private static void setLCM(double lcm){HCFandLCMfind.lcm = lcm;}

    public HCFandLCMfind(int hcf, int lcm) {
        super(getNum1(), getNum2(), getLargestofBoth(),getSmallestofBoth(), getIntegerList(), getPrimesList());
        HCFandLCMfind.hcf = hcf;
        HCFandLCMfind.lcm = lcm;   
    }

    public static void main(String[] args) {

        int num1;
        int num2;
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter your two numbers: ");

            System.out.print("Num 1: ");
            num1 = input.nextInt();
            PrimeNumberGenerator.setNum1(num1);

            System.out.print("\nNum 2: ");
            num2 = input.nextInt();
            PrimeNumberGenerator.setNum2(num2);
        }

        // System.out.println(findLargestofBoth(PrimeNumberGenerator.getNum1(), PrimeNumberGenerator.getNum2())+"\ngetLargestofBoth(): "+ PrimeNumberGenerator.getLargestofBoth()+"\ngetSmallestofBoth(): "+PrimeNumberGenerator.getSmallestofBoth());
        
        // System.out.println(findSmallestofBoth(PrimeNumberGenerator.getNum1(), PrimeNumberGenerator.getNum2())+"\ngetSmallestofBoth(): "+ PrimeNumberGenerator.getSmallestofBoth()+"\ngetLargestofBoth(): "+PrimeNumberGenerator.getLargestofBoth());

        hcf(PrimeNumberGenerator.getNum1(), PrimeNumberGenerator.getNum2());

        lcm(PrimeNumberGenerator.getNum1(), PrimeNumberGenerator.getNum2());

        System.out.println("\nHCF of "+PrimeNumberGenerator.getNum1()+" and "+PrimeNumberGenerator.getNum2()+" is "+getHCF()+"\n");

        System.out.println("LCM of "+PrimeNumberGenerator.getNum1()+" and "+PrimeNumberGenerator.getNum2()+" is "+getLCM());

    }

/*************************************************************************************************/

    public static boolean  isFactor(ArrayList<Integer> integers, int numbertocheck, int forloopinteration){
        return numbertocheck%integers.get(forloopinteration)==0;
    }

/*************************************************************************************************/

    public static void hcf(int a, int b){
        // System.out.println("In HCF:");

        ArrayList<Integer> integers = PrimeNumberGenerator.arrayListGenerator(PrimeNumberGenerator.findLargestofBoth(a, b));

        PrimeNumberGenerator.setIntegerList(integers);

        // System.out.println(integers);
        
        ArrayList<Integer> factorsforA = new ArrayList<>();

        try{
            for (int i = 0; i < a; i++) {             
                if (isFactor(integers, a, i)) {
                    factorsforA.add(integers.get(i));
                }

            }
        }
        catch(IndexOutOfBoundsException e){
            e.getMessage();
        }

        // System.out.println("Factors for "+a+": " + factorsforA);

        ArrayList<Integer> factorsforB = new ArrayList<>();

        try{
            for (int i = 0; i < b; i++) {
                if (isFactor(integers, b, i)) {
                    factorsforB.add(integers.get(i));
                }
            }
        }
        catch(IndexOutOfBoundsException e){
            e.getMessage();
        }

        // System.out.println("Factors for "+ b +": " + factorsforB);

        ArrayList<Integer> largest = new ArrayList<>();
        ArrayList<Integer> smallest = new ArrayList<>();

        if (factorsforA.size() < factorsforB.size()) {
            largest = factorsforB;
            smallest = factorsforA;
            
        }
        else if (factorsforA.size() > factorsforB.size()) {
            largest = factorsforA;
            smallest = factorsforB;
        }
        else{
            largest = factorsforA;
            smallest = factorsforB;
        }
        
        ArrayList<Integer> factorsforBoth = new ArrayList<>();

        try{
            for(int i = 0; i < smallest.size() ; i++ ){
                for (int j = 0; j < largest.size(); j++) {

                    // System.out.println("Comparing: "+smallest.get(i)+" with: "+largest.get(j));
                    // System.out.println("Result: ");

                    if (Objects.equals(largest.get(j), smallest.get(i))){
                        // System.out.println("Added: "+largest.get(j)+" Or "+smallest.get(i));
                        factorsforBoth.add(largest.get(j));
                    }
                    else{
                        // System.out.println("Skipped: "+largest.get(j)+" Or "+ smallest.get(i));
                    }
                }
            }
        }
        catch(IndexOutOfBoundsException e){
            e.getMessage();
        }
        // System.out.println("Factors for "+ a +": " + factorsforA);

        // System.out.println("Factors for "+ b +": " + factorsforB);

        // System.out.println(factorsforBoth);

        // int hcf = factorsforBoth.getLast();

        HCFandLCMfind.setHCF(factorsforBoth.getLast());
    }

/*************************************************************************************************/

    /*
     * Take the smallest of the two numbers.
     * Factorize it with the the primes.
     * See if any of the factors also apply to the second number.
     * If they do store in an LCM ArrayList.
     */
    public static void lcm(double  a, double  b) {

        double productofAandB = a*b;

        HCFandLCMfind.setLCM(productofAandB/HCFandLCMfind.getHCF());

        double productOfHandL = HCFandLCMfind.getHCF()*HCFandLCMfind.getLCM();

        // System.out.println("Product of A and B: "+ productofAandB + "\nProduct of H and L: " + productOfHandL);

        HCFandLCMfind.setLCM(lcm);
    }

}
