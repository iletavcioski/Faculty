import java.lang.String;
public class Oseba {
	
	private String ime;
	private String priimek;
	private char spol;
	private int letoRojstva;
	private Oseba oce;
	private Oseba mati;
	static int counter = 0;
	
	public Oseba(String ime, String priimek, char spol, int letoRojstva) {
		this(ime,priimek,spol,letoRojstva,null,null);
	}
	
	public Oseba(String ime, String priimek, char spol, int letoRojstva, Oseba oce, Oseba mati) {
		this.ime=ime;
		this.priimek=priimek;
		this.spol=spol;
		this.letoRojstva=letoRojstva;
		this.oce = oce;
		this.mati=mati;
		counter++;
	}
	
	
	public String vrniIme() {
		return this.ime;
	}
	
	public void nastaviIme(String novoIme) {
		this.ime = novoIme;
	}
	
	public int starost(int leto) {
		return (leto - this.letoRojstva);
	}
	
	public boolean jeStarejsaOd(Oseba os) {
		return (this.letoRojstva < os.letoRojstva);
	}
	
	public String toString() {
		return String.format("%s %s (%c), %d",this.ime, this.priimek, this.spol, this.letoRojstva);
	}
	
	public String imeOceta() {
		if(this.oce == null)
			return null;
		return this.oce.ime;
	}
	
	public boolean jeBratAliSestraOd(Oseba os) {
		if(this.mati == null || this.oce == null || os.mati == null || os.oce==null)
			return false;
		return (this != os && this.oce == os.oce && this.mati == os.mati); 
	}
	
	public boolean jeSestraOd(Oseba os) {
		if(this.mati == null || this.oce == null || os.mati == null || os.oce==null)
			return false;
		if(this.spol == 'M')
			return false;
		return (this != os && this.oce == os.oce && this.mati == os.mati);
	}
	
	public boolean jeTetaOd(Oseba os) {
		if(os.oce == null || os.mati == null)
			return false;
		return (this.jeSestraOd(os.oce) || this.jeSestraOd(os.mati));
	}
	
	public boolean jeOcetovskiPrednikOd(Oseba os) {
		Oseba a = os;
		if (os == this)
			return false;
		while (a != null) {
			if (a == this)
				return true;
			a = a.oce;
		}
		return false;
	}
	
	public static int steviloUstvarjenih() {
		return counter;
	}
	
}