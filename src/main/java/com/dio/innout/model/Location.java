package com.dio.innout.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class Location {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private AccessLevel accessLevel;
    private String description;
}
