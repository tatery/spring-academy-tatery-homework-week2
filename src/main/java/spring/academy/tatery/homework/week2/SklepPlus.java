package spring.academy.tatery.homework.week2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("plus")
@ConfigurationProperties(prefix = "sklep")
public class SklepPlus extends Sklep {

    private final Koszyk koszyk;
    private float vat = 0f;

    @Autowired
    public SklepPlus(Koszyk koszyk) {
        this.koszyk = koszyk;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void wyswietl() {
        System.out.println("Aktywny profil sklepu: \"plus\"");
        float koszykSuma = super.wyswietlKoszyk(koszyk);
        super.dodajVat(koszykSuma, vat);
    }
}
