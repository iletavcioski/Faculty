
public class Jed {

    private String naziv;            // naziv, npr. "prekmurska gibanica"
    private Sestavina[] sestavine;   // sestavine jedi
    private double[] mase;           // mase posameznih sestavin v gramih
    private String vrsta;            // npr. "glavna jed", "sladica"

    public Jed(String naziv, Sestavina[] sestavine, double[] mase, String vrsta) {
        this.naziv = naziv;
        this.sestavine = sestavine;
        this.mase = mase;
        this.vrsta = vrsta;
    }

    public String vrniNaziv() {
        return this.naziv;
    }

    public Sestavina[] vrniSestavine() {
        return this.sestavine;
    }

    public double[] vrniMase() {
        return this.mase;
    }

    public String vrniVrsto() {
        return this.vrsta;
    }

    /**
     * Vrne true natanko v primeru, "ce jed vsebuje vsaj eno sestavino z
     * najmanj 10% beljakovin.
     */
    public boolean jeBeljakovinska() {
       for (int i = 0; i < this.sestavine.length; i++) {
		   if (this.sestavine[i].vrniBeljakovine() > (double)10.00)
			   return true;
	   }
        return false;   // Spremenite!
    }

    /**
     * Vrne skupno "stevilo kalorij (kcal) jedi this.
     */
    public double kalorije() {
		double bro = 0;
        for (int i = 0; i < this.sestavine.length; i++) {
			bro += (this.sestavine[i].vrniKalorije()/(double)(100) * this.mase[i]);
		}
        return bro;   // Spremenite!
    }
}
