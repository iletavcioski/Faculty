import java.util.Scanner;

class IzpisStevk
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		if(n==0)
			System.out.println(n);
		while(n>0)
		{
			System.out.println(n%10);
			n/=10;
		}
	}
}