package io.incondensable.parkingsystem.domain.model;

public class PriceRate {
    private Long id;
    private String title;
    private Double dailyPriceRate;
    private Double monthlyPriceRate;

    public PriceRate() {
    }

    public PriceRate(Long id, String title, Double dailyPriceRate, Double monthlyPriceRate) {
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
