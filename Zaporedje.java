
/**
 * NALOGA 2
 */

import java.util.*;

public class Zaporedje {

    int k;
	int num;
	int poc;
    public Zaporedje(int k) {
		this.k = k;
		this.num = 0;
		this.poc = 1;
    }

    //-------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    //-------------------------------------------------------------------------
    public int naslednje() {
		
		if (this.num == 0) {
			this.num++;
			return this.poc;
		}
		else {
			this.poc += (this.num*this.k - (this.num*2 - 1));
		}
        this.num++;
		return this.poc;
    }

    //-------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    //-------------------------------------------------------------------------
    public int katero() {
        return this.num + 1;
    }

    //-------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    //-------------------------------------------------------------------------
    public void ponastavi(int n) {
		this.num = 0;
		this.poc = 1;
		while(this.num != (n-1)) {
			if (this.num == 0)
				this.num++;
			else {
			this.poc += (this.num*this.k - (this.num*2 - 1));
			this.num++;
			}
		}
    }
}
