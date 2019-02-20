
public class Obrok {

    private Jed[] jedi;   // jedi, ki sestavljajo obrok

    public Obrok(Jed[] jedi) {
        this.jedi = jedi;
    }

    public Jed[] vrniJedi() {
        return this.jedi;
    }

    /**
     * Vrne indeks najbolj kalori"cne beljakovinske jedi v tabeli jedi obroka
     * this.  "Ce je takih jedi ve"c, vrne indeks prve med njimi, "ce pa obrok
     * this ne vsebuje beljakovinskih jedi, vrne -1.
     */
    public int indeksNajboljKaloricneBeljakovinske() {
		int ind = -1;
		double maxi = 0.0;
        for(int i = 0; i < this.jedi.length; i++) {
			if (this.jedi[i].jeBeljakovinska() == true) {
				if (this.jedi[i].kalorije() > maxi) {
					maxi = this.jedi[i].kalorije();
					ind = i;
				}
			}
		}
        return ind;   // Spremenite!
    }

    /**
     * Vrne skupno maso sestavine (ne jedi!) s podanim nazivom v obroku this.
     */
    public double masaSestavine(String nazivSestavine) {
        double br = 0;
		for (int i = 0; i < this.jedi.length; i++) {
			for (int j = 0; j < this.jedi[i].vrniMase().length; j++) {
				if (this.jedi[i].vrniSestavine()[j].vrniNaziv() == nazivSestavine) {
					br += this.jedi[i].vrniMase()[j];
				}
			}
		}
		return br;
    }

    /**
     * Stabilno uredi tabelo this.jedi glede na podani primerjalnik.
     *
     * Ne spreminjajte!
     */
    public void urediJedi(Primerjalnik primerjalnik) {
        for (int i = 1;  i < this.jedi.length;  i++) {
            Jed trenutni = this.jedi[i];
            int j = i;
            while (j > 0 && primerjalnik.jePred(trenutni, this.jedi[j - 1])) {
                this.jedi[j] = this.jedi[j - 1];
                j--;
            }
            this.jedi[j] = trenutni;
        }
    }

}
