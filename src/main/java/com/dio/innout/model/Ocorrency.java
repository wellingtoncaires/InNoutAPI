package com.dio.innout.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Ocorrency {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
}
