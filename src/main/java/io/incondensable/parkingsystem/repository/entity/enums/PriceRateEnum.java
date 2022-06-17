package io.incondensable.parkingsystem.repository.entity.enums;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

public enum PriceRateEnum {
    BASE_PACKAGE((byte) 1, "Base Package"),
    SPECIAL_PACKAGE((byte) 2, "Special Package"),
    SUPER_PACKAGE((byte) 3, "Supreme Package"),
    PREMIUM_PACKAGE((byte) 4, "Premium Package");

    private final Byte code;
    private final String title;

    PriceRateEnum(Byte code, String title) {
        this.code = code;
        this.title = title;
    }

    public static PriceRateEnum getByTitle(String title) {
        return Arrays.stream(PriceRateEnum.values())
                .filter(priceRate -> priceRate.title.equals(title))
                .reduce((t1, t2) -> t1)
                .get();
    }

    public static void main(String[] args) {
        System.out.println(getByTitle("Premium Package").code);

        Timestamp ts1 = Timestamp.valueOf(LocalDateTime.of(2020, Month.APRIL, 20, 10, 10, 30));
        Timestamp ts2 = Timestamp.valueOf(LocalDateTime.of(2022, Month.JULY, 20, 10, 10, 30));

    }
}
