// 63180383
// V prej"snji vrstici navedite svojo vpisno "stevilko.

public class Naloga {

    public static class Predmet {
        private int sifra;
        private String naziv;
        private int kt;
        private int tip;
        private Modul modul;
        private Izvajalec[] izvajalci;

        public Predmet(int sifra, String naziv, int kt, int tip, Modul modul, Izvajalec[] izvajalci) {
            this.sifra = sifra;
            this.naziv = naziv;
            this.kt = kt;
            this.tip = tip;
            this.modul = modul;
            this.izvajalci = izvajalci;
        }
		
		public int getKT() {
			return this.kt;
		}
		
		public int gettip() {
			return this.tip;
		}
		
		public int getst() {
			return this.izvajalci.length;
		}
		
		public Modul getmodul() {
			return this.modul;
		}
		
		public int getsif() {
			return this.sifra;
		}
		
		public String getnaziv() {
			return this.naziv;
		}
		
		public Izvajalec[] getizvaj() {
			return this.izvajalci;
		}
		
        @Override
        public String toString() {
            return String.format("%d (%s)", this.sifra, this.naziv);
        }
    }

    public static class Modul {
        private int sifra;
        private String naziv;

        public Modul(int sifra, String naziv) {
            this.sifra = sifra;
            this.naziv = naziv;
        }
		
		public int getsif() {
			return this.sifra;
		}

        @Override
        public String toString() {
            return String.format("%d (%s)", this.sifra, this.naziv);
        }
    }

    public static class Izvajalec {
        private int sifra;
        private String ip;

        public Izvajalec(int sifra, String ip) {
            this.sifra = sifra;
            this.ip = ip;
        }
		
		public int getsif() {
			return this.sifra;
		}
        @Override
        public String toString() {
            return String.format("%d (%s)", this.sifra, this.ip);
        }
    }

    public static class Predmetnik {
        private Predmet[] predmeti;

        public Predmetnik(Predmet[] predmeti) {
            this.predmeti = predmeti;
        }
		
		public Predmet[] getpredmet() {
			return this.predmeti;
		}
        public int steviloKT() {
			int stevilo = 0;
            for (int i = 0; i < predmeti.length;i++) {
				stevilo += predmeti[i].getKT();
			}
            return stevilo;
        }

        public int[] tipiPredmetov() {
            
            int[] arr = new int[3];
			for (int i = 0; i < predmeti.length; i++) {
				arr[predmeti[i].gettip()]++;
			}
			return arr;
        }
		
		public int min(int a, int b) {
			return a > b ? b : a;
		}

        public Predmet predmetZNajvecIzvajalci() {
			int in = -1;
			int mini = 1000000;
			int maxi = 0;
			for (int i = 0; i < predmeti.length; i++) {
				if (predmeti[i].getst() > maxi) {
					maxi = predmeti[i].getst();
					mini = predmeti[i].getsif();
					in = i;
				}
				else if(predmeti[i].getst() == maxi) {
					if (mini > predmeti[i].getsif()) {
						in = i;
						mini = predmeti[i].getsif();
					}
				}
			}
			if (in == -1)
				return null;
			else
				return predmeti[in];
        }

        public int predmetiModula(int sifra, String[] nazivi) {
            int it = 0;
			for (int i = 0; i < predmeti.length; i++) {
				Modul x = predmeti[i].getmodul();
				if (x != null && x.getsif() == sifra) {
					nazivi[it++] = predmeti[i].getnaziv();
				}
			}
            return it;
        }

        public int steviloIzvajalcev() {
            int[] ar = new int[100001];
			for (int i = 0 ; i < predmeti.length; i++) {
				for (int j = 0; j < predmeti[i].getizvaj().length; j++) {
					ar[predmeti[i].getizvaj()[j].getsif()]++;
				}
			}
			
			int count = 0;
			
			for (int i = 0; i < 100001; i++) {
				if (ar[i] > 0) {
					count++;
				}
			}
            return count;
        }

        public int steviloEnakoMocnihModulov(Predmetnik drugi) {
			int[] cc = new int[100001];
			boolean[] xx = new boolean[100001];
			for (int i = 0; i < predmeti.length; i++) {
				if (predmeti[i].getmodul() != null) {
					cc[predmeti[i].getmodul().getsif()]++;
				}
				if (predmeti[i].getmodul() != null) {
					xx[predmeti[i].getmodul().getsif()] = true;
				}
			}
			
			for (int i = 0; i < drugi.getpredmet().length; i++) {
				if (drugi.getpredmet()[i].getmodul() != null) {
					cc[drugi.getpredmet()[i].getmodul().getsif()]--;
				}
				if (drugi.getpredmet()[i].getmodul() != null) {
					xx[drugi.getpredmet()[i].getmodul().getsif()] = true;
				}
			}
			
			int mewi = 0;
			for (int i = 0; i < 100001; i++) {
				if (cc[i] == 0 && xx[i]) {
					mewi++;
				}
			}
			return mewi;
			
        }
    }
}
