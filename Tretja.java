
// 
// (write down your student ID number at the end of the previous line)

import java.awt.*;
import java.util.Arrays;

/*
 * TEST CASES:
 *
 * J1, S1--S5: calls of the method stranicaPolja
 *
 * J2, S6--S10: calls of the method zgornjiLeviKot
 *
 * J3--J5, S11--S25: square-shaped array this.polje, square-shaped canvas
 *
 * J6--J7, S26--S35: square-shaped array this.polje
 *
 * J3, S11--S15: no flagged cells, no mined cells
 *
 * J4, J6, J8, S16--S20, S26--S30, S36--S40: no flagged cells
 */

public class Tretja extends Platno {

    public static void main(String[] args) {
        Polje[][] polja = {
            { new Polje(false), new Polje(false), new Mina(true), new Polje(true) },
            { new Zastavica(), new Polje(true), new Zastavica(), new Mina(true) },
            { new Mina(false), new Polje(false), new Polje(true), new Polje(false) }
        };

        Tretja tretja = new Tretja(polja);
        tretja.sproziRisanje(args, "Minolovec");
    }

    //=========================================================================
    public static class Polje {    // a cell

        public static final Color BARVA_ODPRTO = new Color(194, 205, 227);
        public static final Color BARVA_ZAPRTO = new Color(66, 97, 211);

        private boolean odprto;   // true: this cell is open;  false: this cell is closed

        public Polje(boolean odprto) {
            this.odprto = odprto;
        }

        public boolean jeOdprto() {
            return this.odprto;
        }
		
        // add your own stuff if necessary ...
    }

    //=========================================================================
    public static class Mina extends Polje {   // a mined cell

        private boolean obstaja;   // true: the mine exists; the mine does not exist

        public Mina(boolean obstaja) {
            super(true);
            this.obstaja = obstaja;
        }

        public boolean aliObstaja() {
            return this.obstaja;
        }

        // add your own stuff if necessary ...
    }

    //=========================================================================
    public static class Zastavica extends Polje {   // a flagged cell
	
		
        public Zastavica() {
            super(true);
        }

        public boolean vratiz() {
			return true;
		}
    }

    //=========================================================================

    private Polje[][] polja;

    public Tretja(Polje[][] polja) {
        this.polja = polja;
    }

    protected void narisi(Graphics2D g, double wp, double hp) {
        int h = this.polja.length;
		int w = this.polja[0].length;
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (polja[i][j].jeOdprto() == true) {
					g.setColor(Color.BLUE);
					g.fillRect(ri(zgornjiLeviKot(wp,hp)[0] + j*stranicaPolja(wp,hp)), ri(zgornjiLeviKot(wp,hp)[1] + i*stranicaPolja(wp,hp)),ri(stranicaPolja(wp,hp)),ri(stranicaPolja(wp,hp)));
					g.setColor(Color.BLACK);
					g.drawRect(ri(zgornjiLeviKot(wp,hp)[0] + j*stranicaPolja(wp,hp)), ri(zgornjiLeviKot(wp,hp)[1] + i*stranicaPolja(wp,hp)),ri(stranicaPolja(wp,hp)),ri(stranicaPolja(wp,hp)));	
				}
				else {
					
					g.setColor(Color.BLUE);
					g.fillRect(ri(zgornjiLeviKot(wp,hp)[0] + j*stranicaPolja(wp,hp)), ri(zgornjiLeviKot(wp,hp)[1] + i*stranicaPolja(wp,hp)),ri(stranicaPolja(wp,hp)),ri(stranicaPolja(wp,hp)));
					g.setColor(Color.BLACK);
					g.drawRect(ri(zgornjiLeviKot(wp,hp)[0] + j*stranicaPolja(wp,hp)), ri(zgornjiLeviKot(wp,hp)[1] + i*stranicaPolja(wp,hp)),ri(stranicaPolja(wp,hp)),ri(stranicaPolja(wp,hp)));
					}				
				}
			}
		
    }

    public double stranicaPolja(double wp, double hp) {
        int h = this.polja.length;
		int w = this.polja[0].length;
		double a = (double)(hp/h);
		double b = (double)(wp/w);
		if (w*a <= wp)
			return a;
		else
			return b;
        
    }

    public double[] zgornjiLeviKot(double wp, double hp) {
		int h = this.polja.length;
		int w = this.polja[0].length;
		double x = (double)((wp - stranicaPolja(wp,hp)*w)/2);
		double y = (double)((hp - stranicaPolja(wp,hp)*h)/2);
        double[] ni = {x,y};
		return ni;
    }

    // add your own stuff if necessary ...
}
