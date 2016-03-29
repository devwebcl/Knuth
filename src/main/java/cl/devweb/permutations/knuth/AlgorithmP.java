package cl.devweb.permutations.knuth;


public class AlgorithmP {

       /*****
        * Algorithm P
        * From The Art of Computer Programming
        * p.4
        * 
        * A draft of Section 7.2.1.2
        * 
        * 25.Oct.2007
        * 
        */

       public static void main(String[] args) {

               /* Algorithm P (Plain changes)
                *
                * Given a sequence of n elements a1a2...an of n distinct elements,
                * this algorithm generates all of their permutations by repeatedly
                * interchanging adjacent pairs. It uses an auxiliary array c1c2...cn,
                * which represents inversions as described above, running through all
                * sequences of integers such that
                *
                *   0 <= cj <= j   for 1 <= j <= n
                *
                *   another array o1o2...on governs the directions bu which the entries cj change.
                */

               /*
                * Este es un buen ejemplo al ver el paper de knuth sobre quitar gotos es una aplicacion
                */

               //let's insert a zero to let array from 1 to n. [1..n].
               int[] a = { 0, 1, 2, 3, 4};

               structured(a);
               //withBreak(a);

       }




       public static void structured(int[] a) {

               final int n = 4;
               int[] c = new int[n+1];
               int[] o = new int[n+1];
               int j, s, q, foo, perms=1;
               boolean p4=true, p2=true;


               //P1. [Initialize.]
               for(int i=1; i<=n; i++) {
                       c[i] = 0;
                       o[i] = 1;
               }


               while(p2) {
                       //P2. [Visit.]
                       System.out.println();
                       System.out.print( (perms++) + ". " );
                       for(int i=1; i<=n; i++) {
                               System.out.print( a[i] + " " );
                       }

                       //P3. [Prepare for change.]
                       j = n;
                       s = 0;


                       //P4. [Ready to change?]
                       while(p4) {
                               q = c[j] + o[j];

                               if(q>=0) { // ~ goto P7

                                       if(q!=j) {  // ~goto P6

                                               //P5. [Change.]
                                               foo = a[j-c[j]+s];
                                               a[j-c[j]+s] = a[j-q+s];
                                               a[j-q+s] = foo;
                                               c[j] = q;
                                               break; // ~goto P2 !!!!
                                       }

                                       //P6. [Increase s.]
                                       if(j==1){
                                               //Terminate !!!! GOTO EXIT!
                                               System.out.println("\nTERMINATE!");
                                               p2=false;
                                               p4=false;
                                               break;

                                       }else{
                                               s = s + 1;
                                       }
                               }

                               //P7. [Switch direction.]
                               o[j] = -o[j];
                               j = j - 1;

                       } //end-while   //~goto p4

               } //end-while p2


       }



       /* TODO:
        * este metodo es con break o gotos para simular mas parecido el codigo de Knuth
        *
        */
       public static void withBreak(int[] a) {

               final int n = 4;
               int[] c = new int[n];
               int[] o = new int[n];
               int j, s, q, foo;

               //P1. [Initialize.]
               for(int i=0; i<n; i++) {
                       c[i] = 0;
                       o[i] = 1;
               }


               //P2. [Visit.]
               L2: System.out.println();
               for(int i=1; i<n; i++) {
                       System.out.print( a[i] + " " );
               }

               //P3. [Prepare for change.]
               j = n;
               s = 0;


               //P4. [Ready to change?]
               q = c[j] + o[j];

               if(q>=0) { // ~ goto P7

                       if(q!=j) {  // ~goto P6

                               //P5. [Change.]
                               foo = a[j-c[j]+s];
                               a[j-c[j]+s] = a[j-q+s];
                               a[j-q+s] = foo;
                               c[j] = q;
                               //GOTO P2 !!!!
                               //break L2;
                       }

                       //P6. [Increase s.]
                       if(j==1){
                               //Terminate !!!! GOTO EXIT!

                       }else{
                               s = s + 1;
                       }
               }

               //P7. [Switch direction.]
               o[j] = -o[j];
               j = j - 1;
               //GOTO p4

               System.out.println();

       }

}