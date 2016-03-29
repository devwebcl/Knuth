package cl.devweb.permutations.knuth;


public class AlgorithmX {

      /*****
       * Algorithm X
       * From The Art of Computer Programming
       * p.16
       *
       * A draft of Section 7.2.1.2
       *
       * 31.oct.2007 - 2016
       */

      public static void main(String[] args) {

              /* Algorithm X (Lexicographic permutations with restricted prefixes). This al-
               * gorithm generates all permutations a1a2 ...an if {1,2, ...,n} that pass a given
               * sequence of tests
               *
               *      t1(a1), t2(a1,a2), ..., tn(a1,a2,...,an),
               *
               * visiting them in lexicographic order. it uses an auxiliary table of links l0, l1,
               * ..., ln to maintain a cyclic list of unused elemnts, so that if the currently
               * available elements are
               *
               *    {1,...,n} \ {a1,...,ak} = {b1,...,bn-k},   where b1 < ... < bn-k,   (29)
               *
               * then we have
               *
               *    l0 = b1, lbj = bj+1   for 1 <= j < n-k  and lbn-k = 0.   (30)
               *
               * It also uses an auxiliary table u1...un to undo operations that have been
               * performed on the l array.
               *
               */


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

              int[] l = new int[n];
              int k, p, q;


              //X1. [Initialize.]
              for(int i=0; i<n; i++){
                  l[i] = i + 1;
              }
              l[n] = 0;
              k = 1;


              //X2. [Enter level k.]
              p = 0;
              q = l[0];


              //X3. [Test a1...ak.]
              a[k] = q;

              if

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



}
