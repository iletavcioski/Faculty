

import java.util.*;
import java.lang.*;

public class DN09_63180383 {

    static String[] v = new String[106];
    static char[] comand = new char[106];
    static String[] comandt = new String[106];
    static int[] comandn = new int[106];
    static int[] undon = new int[106];
    static String[] undot = new String[106];
    static char[] undod = new char[106]; 
    public static int add(int pos, String text) {
        for (int i = 100; i > pos; i--) {
            v[i] = v[i - 1];
        }
        v[pos] = text;
        int broj = 0;
        for (int i = 99; i >= 0; i--) {
            if (v[i] != "teletonche1804000440014") {
                broj = 2 * (i - pos);
                break;
            }
        }
        broj += text.length();
        return broj;
    }

    public static int brisi(int pos, String text) {
        int broj = 0;
        for (int i = 99; i >= 0; i--) {
            if (v[i] != "teletonche1804000440014") {
                broj = 3 * (i - pos);
                break;
            }
        }
        broj += (2 * text.length());
        for (int i = pos; i < 100; i++) {
            v[i] = v[i + 1];
        }
        return broj;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i <= 100; i++) {
            v[i] = "teletonche1804000440014";
        }
        int I = -1;
        int J = -1;
        int us = -1;
        int unn = -1;
        int dolzina = 0;
        int brojac = 0;
        while (1 == 1) {
            char a = sc.next().charAt(0);
            if (a == 'x')
                break;
            if (a == '#') {

                String text = sc.next();
                int n = dolzina;
                I++;
                comand[I] = '+';
                brojac += add(dolzina, text);
                dolzina++;
                comandt[I] = text;
                comandn[I] = n;
            }
            else if (a == '+') {
                int n = sc.nextInt();
                String text = sc.next();
                I++;
                comand[I] = '+';
                comandt[I] = text;
                comandn[I] = n;
                brojac += add(n, text);
                dolzina++;
            }
            else if (a == '-') {
                int n = sc.nextInt();
                I++;
                comand[I] = '-';
                comandt[I] = v[n];
                comandn[I] = n;
                brojac += brisi(n, v[n]);
                dolzina--;
                
            }
            else if (a == '>') {
            	I++;
            	comand[I] = undod[J];
            	comandt[I] = undot[J];
            	comandn[I] = undon[J];
                if (undod[J] == '-') {
                    brojac += brisi(undon[J], undot[J]);
                    dolzina--;
                }
                else {
                    brojac += add(undon[J], undot[J]);
                    dolzina++;
                }
                J--;
            }
            else if (a == '<') {
            	J++;
            	undod[J] = comand[I];
            	undot[J] = comandt[I];
            	undon[J] = comandn[I];
                if (comand[I] == '-') {
                    brojac += add(comandn[I], comandt[I]);
                    dolzina++;
                }
                else {
                    brojac += brisi(comandn[I], comandt[I]);
                    dolzina--;
                }
                I--;
            }
            System.out.print(brojac + " | ");

            if (v[0] != "teletonche1804000440014") {
                System.out.print(v[0]);
            }

            for (int i = 1; i < 100; i++) {
                if (v[i] != "teletonche1804000440014") {
                    System.out.print("/" + v[i]);
                }
                else {
                    break;
                }
            }
            System.out.println();
        }
    }
}