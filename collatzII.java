import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        int maxi = 0;
        int maxn = -1;
        for (int i = n; i <= m; i++)
        {
            int counter = 1;
            int x = i;
            while(x != 1) {
                if(x % 2 == 0) {
                    x /= 2;
                }
                else {
                    x *= 3;
                    x++;
                }
                counter++;
            }
            if(counter > maxi) {
                maxi = counter;
                maxn = x;
            }
        }
        System.out.println(maxn);
        System.out.println(maxi);
    }
}
