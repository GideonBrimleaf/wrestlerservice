package com.codeclan.example.wrestlerservice.repositories;

import com.codeclan.example.wrestlerservice.models.Wrestler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WrestlerRepository extends JpaRepository<Wrestler, Long> {
//    findBy[Property](args)
//    SELECT * FROM Wrestlers WHERE [Property] = [args]

    List<Wrestler> findByFirstName(String firstName);
//    SELECT * FROM Wrestlers WHERE first_name = [args]

//    findBy[Property[Property]](args)
    List<Wrestler> findByPromotionName(String promotionName);
//    SELECT * FROM Wrestlers
//    INNER JOIN Promotions ON wrestlers.promotion_id = promotions.id
//    WHERE promotion.name = [args]
}
