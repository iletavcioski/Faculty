import java.util.*;

public class DN02_63180383 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int first , last, prev, s;
        first = sc.nextInt();
        prev = first;
        s = first;
        int counarr = 1;
        int diff = 1;
        int maxi = diff;
        int can = 1;
        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            prev = s;
            s = x;
            if (s >= prev) {
                if (can == 1) {
                counarr++;
                }
                if (s > prev) {
                    diff++;
                }
                if (maxi < diff) {
                    maxi = diff;
                }
            }
            else {
                diff = 1;
                can = 0;
            }
        }
        if (n == 1) {
            System.out.println(first);
        }
        else if (n == 2) {
            System.out.println(s);
        }
        else if (n == 3) {
            System.out.println(prev + s);
        }
        else if (n==4) {
            System.out.println(counarr);
        }
        else {
            System.out.println(maxi);
        }

    }
}