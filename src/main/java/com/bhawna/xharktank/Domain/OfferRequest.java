package com.bhawna.xharktank.Domain;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
public class OfferRequest {
    @NonNull
    String investor;
    @NonNull
    BigDecimal amount;
    @NonNull

    BigDecimal equity;
    @NonNull
    String comment;
}
