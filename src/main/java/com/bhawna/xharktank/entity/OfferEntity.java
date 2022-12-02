package com.bhawna.xharktank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
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
    private String amount;
    @Column
    private String equity;
    @Column
    private String comment;
    @Column
    @JsonIgnore
    private Long pitchId;
}
