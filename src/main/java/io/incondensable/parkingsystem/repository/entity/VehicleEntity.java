package io.incondensable.parkingsystem.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLE")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "plate_no")
    private String plateNumber;

    public VehicleEntity() {
    }

    public VehicleEntity(Long id, String type, String plateNumber) {
        this.id = id;
        this.type = type;
        this.plateNumber = plateNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
