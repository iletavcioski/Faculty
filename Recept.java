
/**
 * NALOGA 2
 */

public class Recept {    // kuharski recept

    private Korak[] koraki;    // koraki recepta

    public Recept(Korak[] koraki) {
        this.koraki = koraki;
    }

    public Korak[] vrniKorake() {
        return this.koraki;
    }
	
	
    /**
     * Naloga (a) -- vrne trajanje recepta v minutah.
     */
	
    public int trajanje() {
        int brojac = 0;
		for (int i = 0; i < vrniKorake().length; i++)
			brojac += koraki[i].vrniTrajanje();
        return brojac;
    }

    /**
     * Naloga (b) -- vrne indeks prvega koraka s podano akcijo (-1, "ce te
     * akcije ni).
     */
    public int prviKorakZAkcijo(String akcija) {
        for (int i = 0; i < vrniKorake().length; i++) {
			if (koraki[i].vrniAkcijo() == akcija)
				return i;
		}
        return -1;
    }

    /**
     * Naloga (d) -- vrne "stevilo snovi, ki se pojavljajo SAMO na vhodih v
     * korake recepta.
     */
    public int steviloVstopnihSnovi() {
		int br = 0;
        for (int i = 0; i < this.vrniKorake().length; i++) {
			for (int j = 0; j < this.vrniKorake()[i].vrniVhode().length; j++) {
				boolean cc = true;
				for (int l = 0; l < this.vrniKorake().length; l++) {
				for (int k = 0; k < this.vrniKorake()[l].vrniIzhode().length; k++) {
					if(this.vrniKorake()[i].vrniVhode()[j].vrniNaziv() == this.vrniKorake()[l].vrniIzhode()[k].vrniNaziv()) {
						cc = false;
						
					}
				}
				 }
				if (cc == true)
					br++;
			}
		}
		return br;
    }
}
