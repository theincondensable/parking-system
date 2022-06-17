package io.incondensable.parkingsystem.repository.mappers;

public interface ParkingSystemMappers<DOMAIN, ENTITY> {

    public DOMAIN mapEntityToDomain(ENTITY entity);

    public ENTITY mapDomainToEntity(DOMAIN domain);

}
