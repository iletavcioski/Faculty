import java.lang.String;
public class Oseba {
	
	private String ime;
	private String priimek;
	private char spol;
	private int letoRojstva;
	
	public Oseba(String ime, String priimek, char spol, int letoRojstva) {
		this.ime=ime;
		this.priimek=priimek;
		this.spol=spol;
		this.letoRojstva=letoRojstva;
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
	
}