
// 
// (write down your student ID number at the end of the previous line)

import java.util.Arrays;

public class Prva {

    public static void main(String[] args) {
        // code for manual testing (optional)
    }

    //=========================================================================
    // In all test cases, we have a > 0 and b > 0, and the result is less than
    // 1 000 000 000.
    //=========================================================================

    public static int stakni(int a, int b) {
       int p = b;
	   int br = 0;
	   while (p > 0) {
		   p /= 10;
		   br++;
	   }
	   int mn = 1;
	   for (int i = 0; i < br; i++) {
		   mn *= 10;
	   }
        return (a*mn + b);
    }

    //=========================================================================
    // In all test cases, t is a rectangular array, and the number of its rows
    // and columns is within the interval [1, 100].
    //
    // In test cases J6 and S26--S30, the array has 2 rows.
    // In test cases J7 and S31--S35, the array has 3 rows.
    //=========================================================================

    public static boolean vednoBoljRes(boolean[][] t) {
		int p = -1;
        for (int i = 0; i < t.length; i++) {
			int br = 0;
			for (int j = 0; j < t[i].length; j++) {
				if (t[i][j] == true) {
					br++;
				}
			}
			if (br > p)
				p = br;
			else
				return false;
		}
        return true;
    }
}
