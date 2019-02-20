// 63180383

abstract class Izraz {
	public static Izraz zgradi(String niz) {
		int index = -1;
		boolean cc = true;
		int counter = 0;
		char momentalni = 'A';
		for (int i = 0; i < niz.length(); i++) {
			if (niz.charAt(i) == '(') {
				counter++;
			}
			if (counter != 0) {
				cc = false;
			}
			if (counter == 0) {
				if (niz.charAt(i) == '*' || niz.charAt(i) == '/' || niz.charAt(i) == '+' || niz.charAt(i) == '-') {
					if (momentalni == 'A') {
						index = i;
						momentalni = niz.charAt(i);
					}
					else if(momentalni == '*' || momentalni == '/') {
						if (niz.charAt(i) == '/' || niz.charAt(i) == '*') {
							index = i;
							momentalni = niz.charAt(i);
						}
						
						if (niz.charAt(i) == '+' || niz.charAt(i) == '-') {
							index = i;
							momentalni = niz.charAt(i);
						}
					}
					else if(momentalni == '+' || momentalni == '-') {
						if (niz.charAt(i) == '+' || niz.charAt(i) == '-') {
							index = i;
							momentalni = niz.charAt(i);
						}
					}
				}
			}
			
			if (niz.charAt(i) == ')') {
				counter--;
			}
		}
		if (index == -1) {
			if (cc == true) { 
				return new Stevilo(Integer.parseInt(niz));
			}
			else {
				return zgradi(niz.substring(1, niz.length() - 1));
			}
		}	
		return new SestavljeniIzraz(zgradi(niz.substring(0, index)), niz.charAt(index), zgradi(niz.substring(index + 1, niz.length())));
	}
	public int steviloOperatorjev() {
		if ((this instanceof Stevilo) == true) { 
			return 0;
		}
		else {
			return 1 + ((SestavljeniIzraz) this).left.steviloOperatorjev() + ((SestavljeniIzraz) this).right.steviloOperatorjev();
		}
	}
	public String postfiksno() {
		if ((this instanceof Stevilo) == true) {
			return Integer.toString(((Stevilo) this).number);
		}
		else {
			return ((SestavljeniIzraz) this).left.postfiksno() + ((SestavljeniIzraz) this).right.postfiksno() + Character.toString(((SestavljeniIzraz) this).operator);
		}
	}
	public int vrednost() {
		if ((this instanceof Stevilo) == true) {
			return ((Stevilo) this).number;
		}
		else if (((SestavljeniIzraz) this).operator == '-') {
			return (((SestavljeniIzraz) this).left.vrednost() - ((SestavljeniIzraz) this).right.vrednost());
		}
		else if (((SestavljeniIzraz) this).operator == '*') {
			return (((SestavljeniIzraz) this).left.vrednost() * ((SestavljeniIzraz) this).right.vrednost());
		}
		else if (((SestavljeniIzraz) this).operator == '+') {
			return (((SestavljeniIzraz) this).left.vrednost() + ((SestavljeniIzraz) this).right.vrednost());
		}
		else if (((SestavljeniIzraz) this).operator == '/') {
			return (((SestavljeniIzraz) this).left.vrednost() / ((SestavljeniIzraz) this).right.vrednost());
		}
		else {
			return 0;
		}
	}
}
class Stevilo extends Izraz {	
	int number;
	public Stevilo(int n) {
		this.number = n;
	}
}
class SestavljeniIzraz extends Izraz {
	Izraz left;
	Izraz right;
	char operator;
	public SestavljeniIzraz(Izraz levi, char operator, Izraz desni) {
		this.left = levi;
		this.right = desni;
		this.operator = operator;
	}
}
