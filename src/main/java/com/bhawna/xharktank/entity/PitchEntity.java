package com.bhawna.xharktank.entity;

import javax.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "")
public class PitchEntity extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String entrepreneur;
    @Column
    private String pitchTitle;
    @Column
    private String pitchIdea;
    @Column
    private String askAmount;
    @Column
    private String equity;
    @Transient
    private List<OfferEntity> offers;



}



