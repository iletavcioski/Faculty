import java.util.Scanner;

public class DN00_63180383 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int bonboni = sc.nextInt();
        int prijateljev = sc.nextInt();

        int bonboni_za_vsak_prijatelj;
        int ostatak_bonboni;
        bonboni_za_vsak_prijatelj = bonboni / prijateljev;
        ostatak_bonboni = bonboni % prijateljev;

        System.out.println(bonboni_za_vsak_prijatelj);
        System.out.println(ostatak_bonboni);
    }
}
