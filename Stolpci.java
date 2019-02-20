
import java.awt.*;

/**
 * Stolpci s povezovalno "crto in napisi.
 */
public class Stolpci extends Platno {

    public static void main(String[] args) {
        // V odvisnosti od argumentov ukazne vrstice bodisi ustvari okno in
        // plo"s"co ali pa pripravi sliko v pomnilniku, na katero je mo"zno
        // risati.  S stali"s"ca izdelave na"sega programa je to popolnoma
        // vseeno.

        int[] podatki = {150, 70, 120, 190, 60, 130, 40, 100, 80, 60};
        //int[] podatki = {5};
        //int[] podatki = {1, 1, 1};
        Stolpci stolpci = new Stolpci(podatki);
        stolpci.sproziRisanje(args);
    }

    // podatki, ki dolo"cajo vi"sine stolpcev
    private int[] podatki;

    public Stolpci(int[] podatki) {
        this.podatki = podatki;
    }

    /**
     * Nari"se sliko na platno (zaslon ali slikovno datoteko).  To metodo
     * pokli"ce ogrodje, ko je "cas zanjo.
     * @param g objekt, ki nam omogo"ca risanje
     * @param wp "sirina platna
     * @param hp vi"sina platna
     */
    protected void narisi(Graphics2D g, double wp, double hp) {
        FontMetrics fm = g.getFontMetrics();
        for (int i = 0; i < this.podatki.length; i++) {
            g.setColor(Color.RED);
            g.drawRect(i * (int)sirinaStolpca(wp, hp), (int)hp - (int)visinaStolpca(i, wp, hp), (int)sirinaStolpca(wp, hp), (int)visinaStolpca(i, wp, hp));

            g.setColor(Color.ORANGE);
            g.fillRect(i * (int)sirinaStolpca(wp, hp)+1, (int)hp - (int)visinaStolpca(i, wp, hp)+1, (int)sirinaStolpca(wp, hp)-1, (int)visinaStolpca(i, wp, hp)-1);
            g.setColor(Color.BLACK);
            String reverse = Integer.toString(i + 1);

            g.drawString(reverse,(i * (int)sirinaStolpca(wp, hp) + ((int)sirinaStolpca(wp, hp) - fm.stringWidth(reverse)) / 2), (int)hp - fm.getAscent());
            if (i > 0) {
                double n1[] = sredinaVrha(i - 1, wp, hp);
                double n2[] = sredinaVrha(i, wp, hp);
                g.setColor(Color.BLUE);
                g.drawLine((int)n1[0], (int)n1[1], (int)n2[0], (int)n2[1]);
            }
        }

        
        
    }

    /**
     * Vrne "sirino (v pikslih) posameznega stolpca.
     */
    public double sirinaStolpca(double wp, double hp) {
        double n = this.podatki.length;
        return ((wp / n));
    }

    /**
     * Vrne vi"sino (v pikslih) stolpca s podanim indeksom.
     */
    public double visinaStolpca(int ixStolpec, double wp, double hp) {
        
        double enota = visinaEnote(hp);

        return ((double)this.podatki[ixStolpec] * enota);
    }

    /**
     * Vrne koordinati (v pikslih) sredine zgornjega roba stolpca s podanim indeksom.
     * @return tabela z dvema elementoma ({x, y}).
     */
    public double[] sredinaVrha(int ixStolpec, double wp, double hp) {
        
        double[] niz = new double[2];
        niz[0] = (sirinaStolpca(wp, hp) * (double)ixStolpec) + (sirinaStolpca(wp, hp) / 2.0);
        niz[1] = hp - visinaStolpca(ixStolpec, wp, hp);
        return niz;
    }

    public double visinaEnote(double hp) {
        double maxi = 0;
        for (int i = 0; i < this.podatki.length; i++) {
            if (this.podatki[i] > maxi) {
                maxi = this.podatki[i];
            }
        }

        double res = hp / maxi;
        return res;
    }

   
}
