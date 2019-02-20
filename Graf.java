
/**
 * NALOGA 1
 */

import java.util.*;

public class Graf {

    //-------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    //-------------------------------------------------------------------------
    public static boolean imaEulerjevObhod(boolean[][] m) {
        int n = m.length;
		int counter = 0;
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (m[i][j] == true)
					count++;
			}
			if (count%2 == 1)
				return false;
		}
		return true;
    }

    //-------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    //-------------------------------------------------------------------------
    public static boolean[][] vMatriko(int[][] s) {
        int n = s.length;
		boolean[][] b = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < s[i].length; j++) {
				b[i][s[i][j]] = true;
			}
		}
		return b;
    }

    //-------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    //-------------------------------------------------------------------------
    public static boolean istiGraf(boolean[][] m, int[][] s) {
        boolean[][] b = vMatriko(s);
		if (b.length != m.length)
			return false;
		int n = b.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0;j < n; j++) {
				if (m[i][j] != b[i][j])
					return false;
			}
		}
		return true;
    }
}
