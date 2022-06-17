package io.incondensable.parkingsystem.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "PRICE_RATE")
public class PriceRateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "daily_price_rate")
    private Double dailyPriceRate;

    @Column(name = "monthly_price_rate")
    private Double monthlyPriceRate;

    public PriceRateEntity() {
    }

    public PriceRateEntity(Long id, String title, Double dailyPriceRate, Double monthlyPriceRate) {
        this.id = id;
        this.title = title;
        this.dailyPriceRate = dailyPriceRate;
        this.monthlyPriceRate = monthlyPriceRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getDailyPriceRate() {
        return dailyPriceRate;
    }

    public void setDailyPriceRate(Double dailyPriceRate) {
        this.dailyPriceRate = dailyPriceRate;
    }

    public Double getMonthlyPriceRate() {
        return monthlyPriceRate;
    }

    public void setMonthlyPriceRate(Double monthlyPriceRate) {
        this.monthlyPriceRate = monthlyPriceRate;
    }
}
