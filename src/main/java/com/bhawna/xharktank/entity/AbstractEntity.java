package com.bhawna.xharktank.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
    @Data
    public class AbstractEntity {

        @Column
        @JsonIgnore
        private LocalDateTime addedOn;

        @JsonIgnore
        @Column private LocalDateTime updatedOn;

        @Version
        @JsonIgnore
        @Column private Integer version;

        @PrePersist
        private void prePersist() {
            addedOn = LocalDateTime.now();
            updatedOn = LocalDateTime.now();
        }

        @PreUpdate
        private void preUpdate() {
            updatedOn = LocalDateTime.now();
        }
    }

