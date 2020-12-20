package spring.academy.tatery.homework.week2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("pro")
@ConfigurationProperties(prefix = "sklep")
public class SklepPro extends Sklep {

    private final Koszyk koszyk;
    private float vat;
    private int rabat;

    @Autowired
    public SklepPro(Koszyk koszyk) {
        this.koszyk = koszyk;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public void setRabat(int rabat) {
        this.rabat = rabat;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void wyswietl() {
        System.out.println("Aktywny profil sklepu: \"pro\"");
        float koszykSuma = super.wyswietlKoszyk(koszyk);
        koszykSuma = super.rabat(koszykSuma, rabat);
        super.dodajVat(koszykSuma, vat);
    }
}
