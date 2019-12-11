package Productdto;


public class Time{
	private int BD;
	private int KT;

	
	public Time(int bD, int kT) {
		super();
		BD = bD;
		KT = kT;
	}

	public int getBD() {
		return BD;
	}

	public void setBD(int bD) {
		BD = bD;
	}

	public int getKT() {
		return KT;
	}

	public void setKT(int kT) {
		KT = kT;
	}
	@Override
	public String toString() {
		return "khungGio [BD=" + BD + ", KT=" + KT + "]";
	}
}
