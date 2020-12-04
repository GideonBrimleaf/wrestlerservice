package com.codeclan.example.wrestlerservice.components;

import com.codeclan.example.wrestlerservice.models.Promotion;
import com.codeclan.example.wrestlerservice.models.Wrestler;
import com.codeclan.example.wrestlerservice.repositories.PromotionRepository;
import com.codeclan.example.wrestlerservice.repositories.WrestlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    WrestlerRepository wrestlerRepository;

    @Autowired
    PromotionRepository promotionRepository;

    public DataLoader() {

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Promotion allEliteWrestling = new Promotion("AEW", 2018);
        promotionRepository.save(allEliteWrestling);

        Promotion njpw = new Promotion("njpw", 1972);
        promotionRepository.save(njpw);

        Wrestler kennyOmega = new Wrestler("Kenny", "Omega", 37, false, allEliteWrestling);
        wrestlerRepository.save(kennyOmega);

        Wrestler orangeCassidy = new Wrestler("Orange", "Cassidy", 31, false, allEliteWrestling);
        wrestlerRepository.save(orangeCassidy);

        Wrestler chrisJericho = new Wrestler("Chris", "Jericho", 50, false, njpw);
        wrestlerRepository.save(chrisJericho);
    }
}
