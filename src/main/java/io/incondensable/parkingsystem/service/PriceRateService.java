package io.incondensable.parkingsystem.service;

import io.incondensable.parkingsystem.repository.entity.PriceRateEntity;
import io.incondensable.parkingsystem.repository.PriceRateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceRateService {

    private final PriceRateRepository priceRateRepository;

    public PriceRateService(PriceRateRepository priceRateRepository) {
        this.priceRateRepository = priceRateRepository;
    }

    public List<PriceRateEntity> getAll() {
        return priceRateRepository.findAll();
    }

    public PriceRateEntity getByTitle(String basePriceRateTitle) {
        return priceRateRepository.findByTitle(basePriceRateTitle);
    }

}
