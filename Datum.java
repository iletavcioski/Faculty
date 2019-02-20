// 63180383

public class Datum {

	private int dan;
	private int mesec;
	private int leto;

	public Datum(int dan, int mesec, int leto) {
		this.dan = dan;
		this.mesec = mesec;
		this.leto = leto;
	}

	public int vrniDan() {
		return this.dan;
	}

	public int vrniMesec() {
		return this.mesec;
	}

	public int vrniLeto() {
		return this.leto;
	}

	public String toString() {
		String s = "";
		if (this.dan <= 9)
			s += '0';
		s += this.dan;
		s += '.';
		if (this.mesec <= 9)
			s += '0';
		s += this.mesec;
		s += '.';
		s += this.leto;
		return s;
	}

	public boolean jeEnakKot(Datum datum) {
		if (datum == null)
			return false;
		if (this.dan == datum.dan && this.mesec == datum.mesec && this.leto == datum.leto) {
			return true;
		}
		return false;
	}

}