// 63180383

public class Bankomat {

	private int n5;
	private int n2;
	private int n1;
	private int maxi;
	private Datum maxd1;
	private Datum maxd2;
	private int maxi1;
	private int counter;
	public Bankomat() {
		this.n5 = 0;
		this.n2 = 0;
		this.n1 = 0;
		maxi1 = 0;
		counter = 0;
		maxd1 = null;
		maxd2 = null;
		maxi = 0;
	}

	public int vrniN5() {
		return this.n5;
	}

	public int vrniN2() {
		return this.n2;
	}

	public int vrniN1() {
		return this.n1;
	}

	public void nalozi(int k5, int k2, int k1) {
		this.n5 += k5;
		this.n2 += k2;
		this.n1 += k1;
	}

	public void izpisi() {
		System.out.printf("%d | %d | %d%n", this.n5, this.n2, this.n1);
	}

	public int kolicinaDenarja() {
		return (5 * this.n5 + 2 * this.n2 + this.n1);
	}

	public boolean dvigni(int dvig, Datum datum) {
		int k5 = this.n5;
		int k2 = this.n2;
		int k1 = this.n1;
		int pd = dvig;
		if (k1 == 0 && dvig % 2 == 0 && k5 > 0 && k2 > 0) {
			if (dvig >= 5) {
				int a = dvig/5;
				if (a % 2 == 1)
					a--;
					if (a <= k5) {
						k5 -= a;
						dvig -= a * 5;
					}
					else {
						if (k5 == 0) {
						dvig -= k5 * 5;
						k5 = 0; 
						}
						else {
							dvig -= (k5-1) * 5;
							k5 = 1;
						}
					}
			}
			if (dvig >= 2) {
				if (dvig/2 <= k2) {
					k2 -= dvig/2;
					dvig -= (dvig/2) * 2;
				}
				else {
					dvig -= k2*2;
					k2 = 0;
				}
			}
		}
		else if (k1 == 0 && dvig % 2 == 1 && k5 > 0 && k2 > 0) {
			if (dvig >= 5) {
				int a = dvig/5;
				if (a % 2 == 0)
					a--;
					if (a <= k5) {
						k5 -= a;
						dvig -= a * 5;
					}
					else {
						if (k5 == 1) {
						dvig -= k5 * 5;
						k5 = 0; 
						}
						else {
							dvig -= (k5-1) * 5;
							k5 = 1;
						}
					}
			}
			if (dvig >= 2) {
				if (dvig/2 <= k2) {
					k2 -= dvig/2;
					dvig -= (dvig/2) * 2;
				}
				else {
					dvig -= k2*2;
					k2 = 0;
				}
			}
		}
		else {
			if (dvig >= 5) {
				if (dvig/5 <= k5) {
					k5 -= dvig/5;
					dvig -= (dvig/5) * 5;
				}
				else {
					dvig -= k5 * 5;
					k5 = 0;
				}
			}
			if (dvig >= 2) {
				if (dvig/2 <= k2) {
					k2 -= dvig/2;
					dvig -= (dvig/2) * 2;
				}
				else {
					dvig -= k2 * 2;
					k2 = 0;
				}
			}
			if (dvig >= 1) {
				if (dvig <= k1) {
					k1 -= dvig;
					dvig = 0;
				}
				else {
					dvig -= k1;
					k1 = 0;
				}
			}
		}

		if (dvig == 0){
			this.n5 = k5;
			this.n2 = k2;
			this.n1 = k1;
			if (pd > maxi) {
				maxi = pd;
			}

			if (datum.jeEnakKot(maxd2) == false) {
				if (counter > maxi1) {
					maxi1 = counter;
					maxd1 = maxd2;
				}
				counter = pd;
				maxd2 = datum;
			}
			else {
				counter += pd;
				if (counter > maxi1) {
					maxi1 = counter;
					maxd1 = maxd2;
				}
			}
			return true;
		}else {
		return false;
		}
	}

	public int najDvig() {
		return maxi;
	}

	public Datum najDatum() {
		return maxd1;
	}


}