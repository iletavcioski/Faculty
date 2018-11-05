import java.util.Scanner;

class Collatz
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int counter = 1;
		while(n!=1)
		{
			if(n%2==1)
			{
				n*=3;
				n++;
			}
			else
				n/=2;
			counter++;
		}
		System.out.println(counter);
	}
}