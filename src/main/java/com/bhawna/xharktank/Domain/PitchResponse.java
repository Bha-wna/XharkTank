package com.bhawna.xharktank.Domain;


import com.bhawna.xharktank.entity.OfferEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.List;

@Data
public class PitchResponse <T1,T2> {
    private String id;
    private String entrepreneur;
    private String pitchTitle;
    private String pitchIdea;
    private T1 askAmount;
    private T2 equity;
    private List<OfferEntity> offers;
}
