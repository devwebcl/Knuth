package cl.devweb.permutations.knuth;


public class SampleAlphametics {

       /*****
        * Sample Alphametics brute-force
        * From The Art of Computer Programming
        * p.7
        * 
        * A draft of Section 7.2.1.2
        *
        * 29.oct.2007
        */

       public static void main(String[] args) {

               /* Sample Alphametics brute-force
                * one way to tackle a family of additive alphametics is to start by using
                * Algorithm T to prepare a table of 10!-1 transitions t[k]. Then, for each problem
                * defined by a signature sequence (s1,...,s10) and a first-letter set F, we can
                * exhaustively look for solutions as follows:
                *
                */

               structured();

       }


       public static int factorial(int n) {
               int r=1;
               for(int i=2; i<=n; i++){
                       r = r * i;
               }

               return r;
       }



       public static void structured() {

               //final int n = 4;
               int[] a = new int[11];
               int[] s = new int[11];
               int[] d = new int[11];
               int v, k, j, foo;

               int n10 = factorial(10);
               int[] t = new int[n10];

               /* se assume algun alphametic con asignacion de letras
                * 1 2 3 4 5 6 7 8 9 10
                * V I O L N A T R S X
                *
                * 2(VIOLIN) + VIOLA - TRIO - SONATA = 0     (7)
                *
                * ...Each letter
                * in such a problem has a "signature" obtained by substituting 1 for that letter
                * and 0 for the others; for example, the signature for I in (7) is
                *
                * 2(010010) + 01000 - 0010 - 000000,
                *
                * namely 21010.
                *
                * ...the respective signatures corresponding to (7) are
                *
                * s[1] = 210000; s[2] = 21010; s[3] = -7901; s[4] = 210; s[5] = -998;
                * s[6] = -100; s[7] = -1010; s[8] = -100; s[9] = -100000; s[10] = 0;
                *
                */

               //TODO: esta asignacion de firma:
               for(int i=1; i<=10; i++) {
                       s[i] = i;
               }

               s[1] = 210000;
               s[2] = 21010;
               s[3] = -7901;
               s[4] = 210;
               s[5] = -998;
               s[6] = -100;
               s[7] = -1010;
               s[8] = -100;
               s[9] = -100000;
               s[10] = 0;


               t = AlgorithmT.funcionT(10);


               //A1. [Initialize.]
               for(int i=0; i<10; i++) {
                       a[i+1] = i;
               }

               v = 0;
               for(int i=1; i<=10; i++) {
                       v = v + (i-1)*s[i];
               }

               k = 1;
               for(int i=1; i<10; i++) {
                       d[i] = s[i+1] - s[i];
               }


               //A2. [Test.]
               while(k<=n10){

                       //System.out.println(k);

                       if ( (v==0) && (a[1]!=0) && (a[7]!=0) && (a[9]!=0) ) //V T S != 0. //aca van los constraints de
                       {
                               //output the solution a1...a10.
                               System.out.println("\nSolution:");
                               for(int i=1; i<=10; i++) {
                                       System.out.print(a[i] + " ");
                               }
                       }

                       //A3. [Swap.]
                       if (k==n10){
                               //STOP!
                               System.out.println("\nStop. ");
                               break;
                       }

                       j = t[k];
                       v = v - ( a[j+1] - a[j] ) * d[j];
                       foo = a[j+1];
                       a[j+1] = a[j];
                       a[j] = foo;
                       k = k + 1;
               } // ~goto A2

       }

}
