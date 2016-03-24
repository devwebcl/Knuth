package cl.devweb.permutations.knuth;


public class AlgorithmL {

       /**
        * Algorithm L
        * From The Art of Computer Programming
        * p.1-2
        * 
        * A draft of Section 7.2.1.2
        * 
        * 24.Oct.2007
        * 
        */


       public static void main(String[] args) {

               /* Algorithm L (Lexicographic permutation generation)
                *
                * Given a sequence of n elements a1a2...an, initially sorted so that
                * a1 <= a2 <= ... <= an ,
                *
                * { 1,2,2,3 }
                *
                * 1223, 1232, 1322, 2123, 2132, 2213, 2231, 2312, 2321, 3122, 3212, 3221
                * ordered lexicographically.
                *
                * an auxiliary element a0 is assumed to be present for convenience; a0 must be strictly less
                * than the largest elemnt an.
                */

               int[] a = { 0, 1, 2, 2, 3 };

               //structured(a);
               withBreak(a);
       }




       /*Este metodo quedo con solucion mas elegante con el break.
        *
        */
       public static void withBreak(int[] a) {

               int j, n, l, k, foo, perms=1;

               n = a.length - 1;
               System.out.println( "n="+ n);

               do {
                       //L1. [Visit.]
                       System.out.println();
                       System.out.print( (perms++) + ". " );
                       for(int i=1; i<a.length; i++) {
                               System.out.print( a[i] + " " );
                       }


                       //L2. [Find j.]
                       j = n - 1;
                       while (a[j] >= a[j+1]) {
                               j = j - 1;
                       }

                       if (j==0) {
                               //Terminate Algorithm!
                               break;
                       }


                       //L3. [Increase aj.]
                       l = n;
                       while (a[j] >= a[l]) {
                               l = l - 1;
                       }
                       foo = a[j];
                       a[j] = a[l];
                       a[l] = foo;


                       //L4.[Reverse aj+1...an]
                       k = j + 1;
                       l = n;
                       while (k<l) {
                               foo = a[k];
                               a[k] = a[l];
                               a[l] = foo;

                               k = k + 1;
                               l = l - 1;
                       }

               } while (j>0);

       }




       public static void structured(int[] a) {

               int j, n, l, k, foo, perms=1;

               n = a.length - 1;
               System.out.println( "n="+ n);

               do {
                       //L1. [Visit.]
                       System.out.println();
                       System.out.print( (perms++) + ". " );
                       for(int i=1; i<a.length; i++) {
                               System.out.print( a[i] + " " );
                       }


                       //L2. [Find j.]
                       j = n - 1;
                       while (a[j] >= a[j+1]) {
                               j = j - 1;
                       }
                       //if (j==0) { //original condition from Knuth
                       if (j>0) {
                               //Terminate Algorithm!


                               //L3. [Increase aj.]
                               l = n;
                               while (a[j] >= a[l]) {
                                       l = l - 1;
                               }
                               foo = a[j];
                               a[j] = a[l];
                               a[l] = foo;


                               //L4.[Reverse aj+1...an]
                               k = j + 1;
                               l = n;
                               while (k<l) {
                                       foo = a[k];
                                       a[k] = a[l];
                                       a[l] = foo;

                                       k = k + 1;
                                       l = l - 1;
                               }
                       }

               } while (j>0);
       }


}

