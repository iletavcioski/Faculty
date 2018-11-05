import java.util.Scanner;

class SteviloStevk
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int counter=0;
		if(n==0)
			counter=1;
		while(n>0)
		{
			n/=10;
			counter++;
		}
		System.out.println(counter);
	}
}