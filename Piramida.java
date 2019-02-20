
/**
 * NALOGA 3
 */

import java.awt.*;
import java.util.*;

public class Piramida extends Platno {

    public static void main(String[] args) {
        Piramida piramida = new Piramida(4);
        piramida.sproziRisanje(args);
    }

    private int visina;   // vi"sina piramide

    public Piramida(int visina) {
        this.visina = visina;
    }

    //-------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    //
    // Za zaokro"zevanje double -> int uporabite metodo ri, npr. ri(2.7) = 3.
    //-------------------------------------------------------------------------
    protected void narisi(Graphics2D g, double wp, double hp) {
		for (int k = 1; k <= this.visina; k++) {
			for (int k1 = 0; k1 < k; k1++) {
				g.setColor(Color.BLACK);
				g.drawRect( (this.visina - k) * ri(sirinaBloka(wp, hp)/2.00) + k1*ri(sirinaBloka(wp,hp)),(k-1)*ri(visinaBloka(wp, hp)), ri(sirinaBloka(wp,hp)), ri(visinaBloka(wp,hp)));
				g.setColor(Color.YELLOW);
				g.fillRect( (this.visina - k) * ri(sirinaBloka(wp, hp)/2.00) + k1*ri(sirinaBloka(wp,hp)) + 1,(k-1)*ri(visinaBloka(wp, hp))+1, ri(sirinaBloka(wp,hp)) - 1, ri(visinaBloka(wp,hp))-1);
			}
		}
    }

    //-------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    //-------------------------------------------------------------------------
    public double sirinaBloka(double wp, double hp) {
        return (double)wp/(this.visina);
    }

    //-------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    //-------------------------------------------------------------------------
    public double visinaBloka(double wp, double hp) {
        return (double)hp/(this.visina);
    }
}
