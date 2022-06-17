package io.incondensable.parkingsystem.web.controller.pricerate;

import io.incondensable.parkingsystem.repository.entity.PriceRateEntity;
import io.incondensable.parkingsystem.service.PriceRateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/price/rate")
public class PriceRateController {

    private final PriceRateService priceRateService;

    public PriceRateController(PriceRateService priceRateService) {
        this.priceRateService = priceRateService;
    }

    @GetMapping
    public List<PriceRateEntity> getAllPriceRates() {
        return priceRateService.getAll();
    }

}
