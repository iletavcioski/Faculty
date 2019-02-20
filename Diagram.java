
/**
 * NALOGA 3
 *
 * Dopolnite/spremenite SAMO ozna"ceni del razreda!
 */

import java.awt.*;

public class Diagram extends Platno {

    //=========================================================================
    // Notranji razredi
    //=========================================================================

    public static class Skatla {
        private int stRazdelkov;
        private double x, y;

        public Skatla(int stRazdelkov, double x, double y) {
            this.stRazdelkov = stRazdelkov;
            this.x = x;
            this.y = y;
        }

        public int vrniStRazdelkov() {
            return this.stRazdelkov;
        }

        public double vrniX() {
            return this.x;
        }

        public double vrniY() {
            return this.y;
        }

        public String toString() {
            return String.format("[stRazdelkov = %d, x = %.1f, y = %.1f]", this.stRazdelkov, this.x, this.y);
        }
    }

    public static class Povezava {
        private Skatla prva, druga;

        public Povezava(Skatla prva, Skatla druga) {
            this.prva = prva;
            this.druga = druga;
        }

        public Skatla vrniPrvo() {
            return this.prva;
        }

        public Skatla vrniDrugo() {
            return this.druga;
        }
    }

    //=========================================================================
    // Primer
    //=========================================================================

    // POZOR!
    //
    // Uporabljajte atribute, ne konstante (torej this.skatle, ne SKATLE)!

    private static final Skatla[] SKATLE = {
        new Skatla(3, 2.0, 1.0),
        new Skatla(1, 0.0, 7.0),
        new Skatla(2, 7.0, 1.0),
        new Skatla(4, 6.0, 5.0),
    };

    private static final Povezava[] POVEZAVE = {
        new Povezava(SKATLE[0], SKATLE[1]),
        new Povezava(SKATLE[0], SKATLE[2]),
        new Povezava(SKATLE[0], SKATLE[3]),
        new Povezava(SKATLE[2], SKATLE[3]),
    };

    private static final double D_PAPIR = 10.0;
    private static final double W_SKATLA = 2.0;

    //=========================================================================
    // Metoda main
    //=========================================================================

    public static void main(String[] args) {
        Diagram diagram = new Diagram(SKATLE, POVEZAVE, D_PAPIR, W_SKATLA);
        diagram.sproziRisanje(args);
    }

    //=========================================================================
    // Atributi, konstruktor in nestati"cne metode
    //=========================================================================

    private Skatla[] skatle;      // "skatle
    private Povezava[] povezave;  // povezave med "skatlami
    private double dPapir;        // dol"zina stranice lista papirja (v cm)
    private double wSkatla;       // "sirina "skatle (v cm)

    public Diagram(Skatla[] skatle, Povezava[] povezave, double dPapir, double wSkatla) {
        this.skatle = skatle;
        this.povezave = povezave;
        this.dPapir = dPapir;
        this.wSkatla = wSkatla;
    }

    //=========================================================================
    // DOPOLNITE / SPREMENITE!
    //=========================================================================

    // wp: "sirina platna
    // hp: vi"sina platna

    protected void narisi(Graphics2D g, double wp, double hp) {
			g.setColor(Color.RED);
        for (int i = 0; i < this.povezave.length; i++) {
			int x1 = ri(sredisceSkatle(this.povezave[i].vrniPrvo(),wp,hp)[0]);
			int y1 = ri(sredisceSkatle(this.povezave[i].vrniPrvo(),wp,hp)[1]);
			int x2 = ri(sredisceSkatle(this.povezave[i].vrniDrugo(),wp,hp)[0]);
			int y2 = ri(sredisceSkatle(this.povezave[i].vrniDrugo(),wp,hp)[1]);

			g.drawLine(x1,y1,x2,y2);
			
			
		}
		for (int i = 0; i < this.skatle.length; i++) {
			int n = this.skatle[i].vrniStRazdelkov();
			int x = ri(this.skatle[i].vrniX() *(double)(Math.min(wp,hp)/this.dPapir));
			int y = ri(this.skatle[i].vrniY() *(double)(Math.min(wp,hp)/this.dPapir) );
			int cm = ri((Math.min(wp,hp)/this.dPapir));
			for (int j = 0; j < n; j++) {
				g.setColor(Color.YELLOW);
				g.fillArc(x, y + j*cm, ri(sirinaSkatle(wp,hp)), cm, 45,  360 - 90);
				g.setColor(Color.BLACK);
				g.drawArc(x, y + j*cm , ri(sirinaSkatle(wp,hp)), cm,45, 360 - 90);
			}
		}
    }

    /**
     * Vrne "sirino "skatle v pikslih.
     */
    public double sirinaSkatle(double wp, double hp) {
        return (double)((double)this.wSkatla * (double)(Math.min(wp,hp)/this.dPapir));
    }

    /**
     * Vrne koordinati sredi"s"ca podane "skatle v pikslih.
     */
    public double[] sredisceSkatle(Skatla sk, double wp, double hp) {
        // Dopolnite / spremenite ...
        double ySredisce = (double)(sk.y*(double)(Math.min(wp,hp)/this.dPapir)) + (double)(((double)sk.stRazdelkov * (double)(Math.min(wp,hp)/this.dPapir))/2.00);
        double xSredisce = (double)(sk.x*(double)(Math.min(wp,hp)/this.dPapir)) + (double)(sirinaSkatle(wp,hp)/2.00);
        return new double[]{xSredisce, ySredisce};
    }
}
