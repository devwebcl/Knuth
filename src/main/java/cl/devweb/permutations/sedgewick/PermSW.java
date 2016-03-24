/**
 * Permutations de Sedgewick
 * sacado de Algorithms de Sedgewick p.513
 * 
 * @author ggonzalez
 *
 */
package cl.devweb.permutations.sedgewick;


public class PermSW {

	//size of array
	public static int V = 4;
	public static int[] val = new int[V+1];
	public static int now = 0;
	public static int index = 0;


	/*
	 * Escribimos el arreglo
	 */
	public static void writePerm() {

		System.out.print("sol #" + (++index) + ": " );

		for(int i=1; i<=V; i++){
			System.out.print(val[i] + " ");
		}

		System.out.println();
	}


	public static void visit(int k) {

		now = now + 1;
		val[k] = now;

		if (now == V) {
			PermSW.writePerm();
		}

		for(int t=1; t<=V; t++){
			if (val[t] == 0) {
				visit(t);
			}
		}

		now = now - 1;
		val[k] = 0;
	}


	public static void main(String[] args) {

		//initialize array
		for(int i=1; i<=V; i++){
			val[i] = 0;
		}

		for(int i=1; i<=V; i++){
			if (val[i]==0) PermSW.visit(i);
		}

	}

}


