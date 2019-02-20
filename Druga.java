
// 
// (write down your student ID number at the end of the previous line)

import java.util.Arrays;

public class Druga {

    public static void main(String[] args) {
        // code for manual testing (optional)
    }

    //=========================================================================
    public static class Stih {
        private int zacetnik;
        private int[] karte;

        public Stih(int zacetnik, int[] karte) {
            this.zacetnik = zacetnik;
            this.karte = karte;
        }

        public int vrednost() {
			int br = 0;
            for (int i = 0; i < this.karte.length; i++) {
				br += karte[i];
			}
			return br;
        }

        public int dobitnik() {
            int i = this.zacetnik;
			int j = 0;
			int maxi = 0;
			int ig = -1;
			while (j < this.karte.length) {
				if (karte[j] > maxi) {
					maxi = karte[j];
					ig = i;
				}
				j++;
				i++;
				if (i == this.karte.length) {
					i = 0;
				}
			}
			return ig;
        }

        public int[] getkarta() {
			return this.karte;
		}
		
		public int getpoc() {
			return this.zacetnik;
		}
		
    }

    public static class Partija {
        private int stIgralcev;
        private Stih[] stihi;

        public Partija(int stIgralcev, Stih[] stihi) {
            this.stIgralcev = stIgralcev;
            this.stihi = stihi;
        }
		
        public int kdoJeVrgel(int karta) {
            for (int i = 0; i < this.stihi.length; i++) {
				int igr = this.stihi[i].getpoc();
				for (int j = 0; j < this.stihi[i].getkarta().length; j++) {
					if (this.stihi[i].getkarta()[j] == karta) {
						return igr;
					}
					igr++;
					if (igr == this.stIgralcev)
						igr = 0;
				}
			}
            return -1;
        }

        public int[] tocke() {
			int[] niz = new int[this.stIgralcev];
            for (int i = 0; i < this.stihi.length; i++) {
				int igr = this.stihi[i].dobitnik();
				for (int j = 0; j < this.stihi[i].getkarta().length; j++) {
					niz[igr] += this.stihi[i].getkarta()[j];
				}
			}
			return niz;
        }

        // add your own methods if necessary ...
    }
}
