package ObjectOrientedDesign;

public class PrimeNumber {

    public static boolean isPrime(int n) throws IllegalArgumentException{
        if(n < 0){
           throw new IllegalArgumentException("Negative Number Inputed");
        }
        /*
        Returns true if n is prime, false if it is not, throws an exception if n is less than 0. Note that 1 is
    not a prime number, by definition.
            b) Contains any other private functions that you deem necessary
         */
   //     primeFactorization(n);

        return trialDivision(n);

    }
    public static boolean isPrime2(int n) throws IllegalArgumentException{
        if(n < 0){
            throw new IllegalArgumentException("Negative Number Inputed");
        }
        /*
        Returns true if n is prime, false if it is not, throws an exception if n is less than 0. Note that 1 is
    not a prime number, by definition.
            b) Contains any other private functions that you deem necessary
         */

        return trialDivision(n);

    }
    public static void primeFactorization(int n) throws IllegalArgumentException {
        if(PrimeNumber.isPrime(n) || n==1) /*Special Case not Prime nor composite*/{

        }else {
            System.out.print("The prime factors of " + n + " are: ");
            for (int i = 2; i < (n); i++) {
                if (n % i == 0) {
                    PrimeNumber.primeFactorization2(i);
                    PrimeNumber.primeFactorization2(n / i);
                    break;
                }
            }
        }

    }
    public static void primeFactorization2(int n) throws IllegalArgumentException {
        if(PrimeNumber.isPrime(n)){
            System.out.print(n +" ");

        }else {
            for (int i = 2; i < (n); i++) {
                if (n % i == 0) {
                    PrimeNumber.primeFactorization2(i);
                    PrimeNumber.primeFactorization2(n / i);
                    break;
                }
            }
        }

    }





        /*int[] factorList = new int[n[0]];
        boolean primeTime = true;
        int counter = 0;

        while (primeTime)
        for(int x : n) {
            if (isPrime(x)) {

            } else {
                primeTime = false;
                for (int i = 2; i <= (x / 2); i++) {
                    if (PrimeNumber.isPrime2(x)) {

                    } else {
                        if (x % i == 0) {
                            factorList[counter] = i;
                            counter++;
                            //take first and last numbers
                            //countiue breaking it up
                            //add to list
                        }
                        //              }


                    }

                }
        *//*if(n < 0){
            throw new IllegalArgumentException("Negative Number Inputed");
        }*//*
         *//*
        Returns true if n is prime, false if it is not, throws an exception if n is less than 0. Note that 1 is
    not a prime number, by definition.
            b) Contains any other private functions that you deem necessary
         *//*


            }
        }
        return factorList;
    }*/


//g outside






    private static boolean trialDivision(int n) {
        if((n == 1)||(n == 0)){
            return false;
        }
        for(int i = 2; i<= (n/2); i++ ){
            if (n % i == 0) {
                return false;
            }

        }
        return true;
    }
  /*  private class compositePrime{

    }*/
}
//camera attached to computer


//find all factors figure if it is prime