package io.incondensable.parkingsystem.repository.mappers.interactors;

import io.incondensable.parkingsystem.domain.model.PriceRate;
import io.incondensable.parkingsystem.repository.entity.PriceRateEntity;
import io.incondensable.parkingsystem.repository.mappers.Mapper;
import io.incondensable.parkingsystem.repository.mappers.ParkingSystemMappers;

@Mapper
public class PriceRateMapper implements ParkingSystemMappers<PriceRate, PriceRateEntity> {

    @Override
    public PriceRate mapEntityToDomain(PriceRateEntity entity) {
        return new PriceRate(
                entity.getId(),
                entity.getTitle(),
                entity.getDailyPriceRate(),
                entity.getMonthlyPriceRate()
        );
    }

    @Override
    public PriceRateEntity mapDomainToEntity(PriceRate domain) {
        return new PriceRateEntity(
                domain.getId(),
                domain.getTitle(),
                domain.getDailyPriceRate(),
                domain.getMonthlyPriceRate()
        );
    }

}
