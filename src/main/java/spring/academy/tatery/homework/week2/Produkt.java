package spring.academy.tatery.homework.week2;

public class Produkt {

	public Produkt(final String nazwa, final int cena) {
		this.nazwa = nazwa;
		this.cena = cena;
	}

	private String nazwa;
	private int cena;

	public String getNazwa() {
		return nazwa;
	}

	public int getCena() {
		return cena;
	}

	@Override
	public String toString() {
		return "Nazwa produktu=" + nazwa + ", cena=" + cena;
	}
}
