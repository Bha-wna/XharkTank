package com.bhawna.xharktank.Domain;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
public class OfferRequest {
    @NonNull
    String investor;
    @NonNull
    String amount;
    @NonNull

    String equity;
    @NonNull
    String comment;
}
