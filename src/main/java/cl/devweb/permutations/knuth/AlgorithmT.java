package cl.devweb.permutations.knuth;


public class AlgorithmT {

       /*****
        * Algorithm T
        * From The Art of Computer Programming
        * p.6
        * 
        * A draft of Section 7.2.1.2
        *
        * 26.oct.2007
        */

       public static void main(String[] args) {

               /* Algorithm T (Plain changes transitions)
                * This algorithm computes a table[1],
                * t[2], ..., t[n!-1] such that the actions of Algorithm P are equivalent to the
                * successive interchanges at[k] <-> at[k]+1 for 1<=k<=n!. We assume that n>=2.
                *
                * for example, if n=4 we get the table (t[1], t[2],...,t[23]) = ( 3, 2, 1, 3, 1, 2, 3, 1,
                * 3, 2, 1, 3, 1, 2, 3, 1, 3, 2, 1, 3, 1, 2, 3 )
                */

               //let's insert a zero to let array from 1 to n. [1..n].

               structured(4);

       }


       public static int factorial(int n) {
               int r=1;
               for(int i=2; i<=n; i++){
                       r = r * i;
               }

               return r;
       }



       public static void structured(int n) {

               //final int n = 4;
               int[] t = new int[factorial(n)];
               int N, m, d, k, j;


               //T1. [Initialize.]
               N = factorial(n); // n!  (n factorial).
               d = N / 2;
               t[d] = 1;
               m = 2;


               //T2. [Loop on m.]
               while( m != n ) {

                       m = m + 1;
                       d = d / m;
                       k = 0;

                       //T3. [Hunt down.]
                       while ( k<N ) {
                               k = k + d;
                               j = m - 1;

                               while ( j>0 ) {
                                       t[k] = j;
                                       j = j - 1;
                                       k = k + d;
                               }

                               //T4. [Offset.]
                               t[k] = t[k] + 1;
                               k = k + d;

                               //T5. [Hunt up.]
                               while ( j < m - 1 ) {
                                       j = j + 1;
                                       t[k] = j;
                                       k = k + d;
                               }
                       }// goto T3, //(if(k<N){

               } //~ goto T2


               //Visit table:
               System.out.println();
               for(int i=1; i<factorial(n); i++) {
                       System.out.print( t[i] + ", " );
               }

               //solucion con n=4
               System.out.println( "\n3, 2, 1, 3, 1, 2, 3, 1, 3, 2, 1, 3, 1, 2, 3, 1, 3, 2, 1, 3, 1, 2, 3");


               System.out.println();
               for(int i=1; i<factorial(n); i++) {
                       System.out.println( "t["+i+"]="+t[i]+";" );
               }

       }


       /*devolvemos el arreglo de transiciones para el ejemplo de alphametics
        *
        */
       public static int[] funcionT(int n) {

               //final int n = 4;
               int[] t = new int[factorial(n)];
               int N, m, d, k, j;


               //T1. [Initialize.]
               N = factorial(n); // n!  (n factorial).
               d = N / 2;
               t[d] = 1;
               m = 2;


               //T2. [Loop on m.]
               while( m != n ) {

                       m = m + 1;
                       d = d / m;
                       k = 0;

                       //T3. [Hunt down.]
                       while ( k<N ) {
                               k = k + d;
                               j = m - 1;

                               while ( j>0 ) {
                                       t[k] = j;
                                       j = j - 1;
                                       k = k + d;
                               }

                               //T4. [Offset.]
                               t[k] = t[k] + 1;
                               k = k + d;

                               //T5. [Hunt up.]
                               while ( j < m - 1 ) {
                                       j = j + 1;
                                       t[k] = j;
                                       k = k + d;
                               }
                       }// goto T3, //(if(k<N){

               } //~ goto T2


               //Visit table:
               System.out.println("visit table");
               /*for(int i=1; i<factorial(n); i++) {
                       System.out.print( t[i] + ", " );
               }*/


               return t;
      }


}