package com.bhawna.xharktank.Domain;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
public class PitchRequest {

    @NonNull
    String entrepreneur;
    @NonNull
    String pitchTitle;
    @NonNull
    String pitchIdea;
    @NonNull
    BigDecimal askAmount;
    @NonNull
    BigDecimal equity;
}
