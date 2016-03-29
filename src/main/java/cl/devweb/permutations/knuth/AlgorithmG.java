package cl.devweb.permutations.knuth;


public class AlgorithmG {

       /*****
        * Algorithm G
        * From The Art of Computer Programming
        * p.11
        * 
        * A draft of Section 7.2.1.2
        * 
        * 30.Oct.2007
        * 
        */

       public static void main(String[] args) {

               /* Algorithm G (General permutation generator)
                *
                * Given a Sims table (S1, S2,
                * ..., Sn-1) where each Sk has k + 1 elements o(k,j) as just described, this
                * algorithm generates all permutations a0a1...an-1 of {0 ,1, ..., n -1, using
                * an auxiliary control table cn ...c2c1.
                * 
                *  
                */


               structured();

       }




       public static void structured() {

               final int n = 4;
               int[] c = new int[n+1];
               int[] a = new int[n+1];
               int j, k;
               boolean g2 = true;


               //G1. [Initialize.]
               for(int i=0; i<n; i++) {
                       a[i] = i;
                       c[i+1] = 0;
               }

               
               //G2.[Visit.]
               while(g2) {
	               for(int i=0; i<n; i++) {
	                   System.out.print( a[i] + " " );
	               }
	               
	               
	               //G3.[Add 1 to cn...c2c1]
	               k = 1;
	               
	               while (c[k] >= k){
	            	   
	            	   if(c[k]==k) {
	            		   c[k] = 0;
	            	   }
	            	   k = k + 1;
	               }
	               
	               if(k==n){
	            	   //TERMINATE!
	            	   System.out.println("Terminate.");
	            	   g2 = false;
	            	   break;
	               }
	               
	               c[k] = c[k] + 1;
	               
	               
	               //G4.[Permute.]
	               
	               
               
               }
               
               

       }

}
