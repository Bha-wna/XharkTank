package com.bhawna.xharktank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "")
public class OfferEntity extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String investor;
    @Column
    private BigDecimal amount;
    @Column
    private BigDecimal equity;
    @Column
    private String comment;
    @Column
    @JsonIgnore
    private Long pitchId;
}
