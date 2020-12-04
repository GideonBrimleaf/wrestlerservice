package com.codeclan.example.wrestlerservice.repositories;

import com.codeclan.example.wrestlerservice.models.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
//    get promotions by wrestler first name

    List<Promotion> findByWrestlersFirstName(String name);
//    findBy[Property[Property]](args)
//    SELECT * FROM Promotions
//    INNER JOIN Wrestlers
//    ON Wrestlers.promotion_id = Promotions.id
//    WHERE wrestlers.first_name = [args]
}
