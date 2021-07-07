package com.dio.innout.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
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
public class HourBank {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class HourBankId implements Serializable {
        private long hourBankId;
        private long movementId;
        private long userId;
    }
    @EmbeddedId
    private HourBankId id;
    private LocalDateTime workedDate;
    private BigDecimal quantityHours;
    private BigDecimal hHoursBalance;
}
