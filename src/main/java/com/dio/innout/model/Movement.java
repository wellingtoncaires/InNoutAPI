package com.dio.innout.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Movement {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class MovementId implements Serializable{
        private long movementId;
        private long userId;
    }
    @EmbeddedId
    private MovementId id;
    private LocalDateTime dateIn;
    private LocalDateTime dateOut;
    private BigDecimal period;
    @ManyToOne
    private Ocorrency ocorrency;
    @ManyToOne
    private Calendars calendar;
}
