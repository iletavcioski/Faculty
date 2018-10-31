import java.util.*;


class Main {
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int counter = 0;
		int ncounter = 1;
		while (ncounter <= a) {
		    int num = in.nextInt();
		    if (counter + num <= b) {
		        counter += num;
		        System.out.println(num +" EP -> zagonetka "+ncounter+" (" + num+" EP)");
		    }
		    else {
		        counter = num;
		        ncounter++;
		        if (ncounter <= a) {
		            System.out.println(num +" EP -> zagonetka "+ncounter+" (" + num+" EP)");
		        }
		    }
		}
	}
}