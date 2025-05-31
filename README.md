### Java HCF & LCM Finder ###
**(Documentation)**

## Context/Background ##
_(Skip this if you're here just to see how the code works)_

>Think about how we normally find HCFs and LCMs.

>Take two numbers, x and y. (I'm also not a fan of algebra, but bear with me here.)

>For these two numbers there must a least common multiple 'l' that is divisible by both.

>_ie. for 40 and 35 is 280, as 280/35 = 7 and 280/40 = 8_

> Similarly, there must be  Highest common factor 'h' , which can Is a divisor of both these numbers.

>_For 40 and 35, HCF is 5_.

>Another interesting thing to note, is that product of LCM and HCF is equal to the product of the two numbers, ie:

**(x)(y) = p = (l)(h)**

>Easy, Right? Using a simple example we could under stand how LCMs and HCFs work.

>_(If you don't get it I would recommend to watch and practice some yourself)_

>But what if we take bigger numbers? Let's say 467 and 399?

>_It becomes harder for bigger numbers, as they are more likely to have more combinations of Factors and multiples._

>Even for a computer to do that, we need to define proper, foul-proof logic. So what is that logic?

>It's simple. First we need to check wether the numbers themselves are primes or not.

>For that, we need a list of primes. And for that, we need to generate primes from scratch.

## Prime Number Generator ##

This section describes how to generate a list of primes, without any limits.

But **First**, An Honest Word:

>Before we begin, I want you to visualize how you would have generated a list of primes and write it down somewhere. It is important, if you're reading this, you just begun programming. But it is important we define your logic first then refine it.Jumping to solutions is fruitless (Saying this from personal experience).

This sections provides the documentation for The prime number generator,
Which is essenciall for Finding HCF and LCM.

# Here are the Methods Described below: #
_(Apart from the basic setters/getter and constructors I'm assuming you already know)_


**Overloaded functions**(I'll explain later):

```
1. arrayListGenerator(int lowerbound,int upperbound)
2. arrayListGenerator(int upperbound)

```

**Non-Overloaded Functions:**
```
3. isPrime(int integertocheck, int primecheckedagainst, int forloopIteration)
4. run()
5. primenumberGenerator(ArrayList<Integer> listofIntegers)

```

Let's Answer the question: 

**Why have I overloaded the ```arraylistGenerator()``` method?**

Consider the function: 

```
    public static ArrayList<Integer> arrayListGenerator(int upperbound){

        ArrayList<Integer> listofIntegers = Main.getList();
        for (int i = 10; i <= upperbound; i++) {
            listofIntegers.add(i);
        }
        return listofIntegers;
    }

```
This is overloaded function form:

```
    public static ArrayList<Integer> arrayListGenerator(int lowerbound,int upperbound){

        ArrayList<Integer> listofIntegers = Main.getList();
        for (int i = lowerbound; i <= upperbound; i++) {
            listofIntegers.add(i);
        }
        return listofIntegers;
    }
```

This serves to count the number of primes generated. The former allows this, while the latter does not. 

To generate primes, we need to compare it with the primes that came before it.

If we try to do this within a range of let's say 100 to 200. That's like trying to build a bridge across a river while destroying the section of the bridge previously built.

**Purpose of  ```isPrime(int integertocheck, int primecheckedagainst, int forloopIteration)``` method:**

As the name implies, this method 
-Takes the number passed from the listofIntegers as a parameter.
-Takes the prime it's to be checked against.
-For the For-loop iteration it was placed in.
-Determines wether or not the given number is divisible or not

Pair this method in a for loop and it will check each integer and return a boolean value. 

If it returns true, the integer is checked for the next prime.

If it returns false, the integer is skipped and next integer is checked. 

```
In isPrime():

    public static boolean isPrime(int integertocheck, int primecheckedagainst, int forloopIteration){
       return integertocheck%primecheckedagainst != 0;//
    }

    //This checks for each integer that is passed, ie wether or not it is divisible by the primes generated thus far.
    //For this reason, we need to initialize an "listofPrimes" with [2,3,5,7] so that this method has something to compare the numbers with.
```

**Why ```primenumberGenerator()``` is used in tandem with ```run()```?**

Run the program ```PrimeNumberGenerator()```. What do you see?

Are you asked to type in a number (upperbound)?

That's what the Thread is for.

It not needed for small numbers like 100 or 1000. But if you want to generate primes till one 