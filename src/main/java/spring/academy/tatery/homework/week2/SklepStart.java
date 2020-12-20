package spring.academy.tatery.homework.week2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("start")
public class SklepStart extends Sklep {

    private final Koszyk koszyk;

    @Autowired
    public SklepStart(Koszyk koszyk) {
        this.koszyk = koszyk;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void wyswietl() {
        System.out.println("Aktywny profil sklepu: \"start\"");
        super.wyswietlKoszyk(koszyk);
    }
}

