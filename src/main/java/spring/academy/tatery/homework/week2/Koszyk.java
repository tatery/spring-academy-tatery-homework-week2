package spring.academy.tatery.homework.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class Koszyk {

	private List<Produkt> koszyk;

	public Koszyk() {
		int koszykSize = 5;
		Random random = new Random();
		koszyk = new ArrayList<Produkt>(koszykSize);

		for (int i = 0; i < koszykSize; i++) {
			Produkt produkt = new Produkt("Produkt_" + (1 + i), random.nextInt(251) + 50);
			koszyk.add(produkt);
		}
	}

	public List<Produkt> getListaProduktow() {
		return koszyk;
	}

}
