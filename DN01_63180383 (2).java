import java.util.Scanner;
import java.lang.String;
import java.util.Arrays;
 
public class DN01_63180383 {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int period, valnadolzina, amplituda, faza;
        period = sc.nextInt();
        valnadolzina = sc.nextInt();
        amplituda = sc.nextInt();
        faza = sc.nextInt();
        String[] mat = new String[amplituda + 1];
        int povdolzina = (valnadolzina - 2) / 2;
        for (int i = 0; i <= amplituda; i++) {
            mat[i] = "";
        }
        for (int i = 0; i < period; i++) {
            for (int j = 0; j < povdolzina; j++) {
                mat[0] += '-';
            }
            mat[0] += '+';
            for (int j = 0; j < povdolzina; j++) {
                mat[0] += ' ';
            }
            mat[0] += '+';
 
        }
 
        for (int i = 1; i < amplituda; i++) {
            for (int j = 0; j < period; j++) {
                for (int k = 0; k < povdolzina; k++) {
                    mat[i] += ' ';
                }
                mat[i] += '|';
                for (int k = 0; k < povdolzina; k++) {
                    mat[i] += ' ';
                }
                mat[i] += '|';
            }
        }
 
        for (int i = 0; i < period; i++) {
            for (int k = 0; k < povdolzina; k++) {
                mat[amplituda] += ' ';
            }
            mat[amplituda] += '+';
            for (int k = 0; k < povdolzina; k++) {
                mat[amplituda] += '-';
            }
            mat[amplituda] += '+';
        }
 
        for (int i = 0; i <= amplituda; i++) {
            String s = "";
            for (int j = faza; j < period * valnadolzina; j++) {
                s += mat[i].charAt(j);
            }
            for (int j = 0; j < faza; j++) {
                s += mat[i].charAt(j);
            }
            System.out.println(s);
        }
    }
}