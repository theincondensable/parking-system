package io.incondensable.parkingsystem.repository;

import io.incondensable.parkingsystem.repository.entity.PriceRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRateRepository extends JpaRepository<PriceRateEntity, Long> {

    PriceRateEntity findByTitle(String basePriceRateTitle);

}
