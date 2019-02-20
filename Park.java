
/**
 * NALOGA 1
 */

public class Park {

    /**
     * Naloga (a) -- vrne "stevilo prostih parkirnih mest na parkiri"s"cu.
     */
    public static int steviloProstih(boolean[][] p) {
		int n = p.length;
		int brojac=0;
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < p[i].length; j++) {
				if (p[i][j] == true)
					brojac++;
			}
		}
		return brojac;
    }

    /**
     * Naloga (b) -- preveri, ali obstaja vrstica z vsaj k zaporednimi (!)
     * prostimi mesti.
     */
    public static boolean zaporedje(boolean[][] p, int k) {
		int maxi = 0;
		int br = 0 ;
        for (int i = 0; i < p.length; i++) 
		{
			br = 0;
			
			for (int j = 0 ; j < p[i].length; j++) {
				if (p[i][j] == true) {
					br++;
					if (maxi < br) {
						maxi = br;
					}
				}
				else
					br = 0;
			}
		}
        if (maxi >= k)
			return true;
		else 
			return false;
    }

    /**
     * Naloga (c) -- vrne "stevilo VSEH parkirnih mest v gara"zni hi"si.
     */
    public static int steviloMest(boolean[][][] g) {
		int brojac=0;
        for (int i = 0; i < g.length; i++) 
		{
			for (int j = 0; j < g[i].length; j++) {
				for (int k = 0; k < g[i][j].length; k++) {
					brojac++;
				}
			}
		}
		return brojac;
    }

    /**
     * Naloga (d) -- vrne indeks nadstropja z najve"c prostimi mesti.
     */
    public static int najboljProstoNadstropje(boolean[][][] g) {
        int inm = 0;
		int maxi = 0;
		int br = 0;
		for (int i = 0; i < g.length; i++) {
			if (maxi < steviloProstih(g[i])) {
				maxi = steviloProstih(g[i]);
				inm = i;
			}
		}
		return inm;
    }
}
