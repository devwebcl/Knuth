package cl.devweb.knuth.puzzles.romans;

/*
 * http://www-cs-faculty.stanford.edu/~knuth/programs.html
 *
 * http://www-cs-faculty.stanford.edu/~knuth/programs/tex.web
 * TeX version -0.25 as it existed when I gave twelve lectures on the internal details of TeX82 in July 1982
 *
 * 1972 = mcmlxxii
 *
 * Explanation:
 * http://www.hanshq.net/roman-numerals.html
 */


public class Romans {

	public static void main(String[] args) {

		print_roman_int(1972);

	}

	static void print_roman_int(int n) {

	    int j, k;         /* mysterious indices */
	    int u, v;   /* mysterious numbers */
	    char[] mystery = "m2d5c2l5x2v5i".toCharArray();
	    j = 0;
	    v = 1000;
	    while (true) {
	        while (n >= v) {
	            System.out.print(mystery[j]);
	            n = n - v;
	        }
	        if (n <= 0)
	            return;             /* nonpositive input produces no output */

	        k = j + 2;
	        u = v / (mystery[k - 1] - '0');
	        if (mystery[k - 1] == '2') {
	            k = k + 2;
	            u = u / (mystery[k - 1] - '0');
	        }
	        if (n + u >= v) {
	        		System.out.print(mystery[k]);
	            n = n + u;
	        } else {
	            j = j + 2;
	            v = v / (mystery[j - 1] - '0');
	        }
	    }
	}

}
