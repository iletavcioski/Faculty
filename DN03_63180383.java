

import java.util.*;
public class DN03_63180383 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int My = sc.nextInt();
        int Dm = sc.nextInt();
        int Dw = sc.nextInt();
        int f = sc.nextInt();
        int h = sc.nextInt();
        int mb = sc.nextInt();
        int yb = sc.nextInt();
        int me = sc.nextInt();
        int ye = sc.nextInt();

        int d = 1;
        int m = 1;
        int dn = 1;
        int y = 1;
        int hc = 1;
        while (1 == 1) {
            if (m == mb && y == yb)
                break;
            d++;
            dn++;
            if (dn > Dw)
                dn = 1;
            if (d > Dm) {
                d = 1;
                m++;
            }
            if (m > My) {
                m = 1;
                y++;
            }
            hc++;
            if (hc > h)
                hc = 1;
        }
        while (1 == 1) {
            if (d == 1)
                System.out.println(m + "/" + y );
            String sk = "";
            for (int i = 0; i < dn - 1; i++)
                sk += "     ";
            for (int i = 0; i < Dw; i++){
                char a;

                if(dn % f == 0 && h == hc) {
                    hc = 1;
                    a = '*';
                }
                else if (dn % f == 0) {
                    hc++;
                    a = 'x';
                }
                else if (hc == h) {
                    hc = 1;
                    a = '+';
                }
                else {
                    hc++;
                    a = '_';
                }
                int br = 1;
                if (d > 9 && d < 100)
                    br = 2;
                else if (d > 99)
                    br = 3;
                String ss = "";
                for (int kk = 0; kk < (5 - br - 1); kk++)
                    ss+=" ";

                sk+=(ss+d+a);
                dn++;
                d++;
                if (d > Dm) {
                    m++;
                    d= 1;
                    if (m > My){
                        y++;

                        m=1;}
                    if (dn > Dw)
                        dn = 1;
                    break;
                }
                if (dn > Dw)
                {
                    dn = 1;
                    break;
                }
            }
            System.out.println(sk);
            if (m > me&&y==ye)
                break;
            if (y > ye)
                break;

        }
    }
}