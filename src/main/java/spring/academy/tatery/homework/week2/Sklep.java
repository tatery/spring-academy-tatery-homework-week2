package spring.academy.tatery.homework.week2;

import java.util.List;

//@Service
//@ConfigurationProperties(prefix = "sklep")
class Sklep {
/*
	private Koszyk koszyk;

	private Environment environment;
	private float vat;
	private int rabat;

	@Autowired
	public Sklep(final Koszyk koszyk, Environment environment) {
		this.koszyk = koszyk;
		this.environment = environment;
	}

	public void setVat(int vat) {
		this.vat = vat;
	}

	public void setRabat(int rabat) {
		this.rabat = rabat;
	}
	*/

	/*@EventListener(ApplicationReadyEvent.class)*/
	float wyswietlKoszyk(Koszyk kosz) {
/*
		String[] activeProfiles = environment.getActiveProfiles();
		String profiles = "";
		if (activeProfiles != null && activeProfiles.length > 0) {
			profiles = Arrays.toString(activeProfiles).toLowerCase();
		}
*/

		System.out.println("Zawartość koszyka:");
		List<Produkt> listaProduktow = kosz.getListaProduktow();
		listaProduktow.forEach(System.out::println);

		float suma = listaProduktow.stream().map(Produkt::getCena).reduce(0, Integer::sum);
		System.out.printf("Wartość netto zamówienia: %.2f\r\n", suma);
/*

		if (profiles.contains("pro")) {
			suma = rabat(suma, rabat);
		}

		if ((profiles.contains("plus") || profiles.contains("pro"))) {
			dodajVat(suma, vat);
		}
*/
		return suma;
	}

	void dodajVat(float suma, float vat) {
		if (vat > 0) {
			suma += suma * vat / 100.0;
		}
		System.out.printf("Wartość brutto zamówienia (vat = %.2f): %.2f\r\n", vat, suma);
	}

	float rabat(float suma, float rabat) {
		if (rabat > 0) {
			suma -= suma * (float) rabat / 100.0;
		}
		System.out.printf("Wartość netto zamówienia po uwzględnieniu rabatu (rabat = %.2f): %.2f\r\n", rabat, suma);
		return suma;
	}

}
