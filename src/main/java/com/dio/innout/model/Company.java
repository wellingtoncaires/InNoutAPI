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
@Audited
public class Company {
    @Id
    @GeneratedValue
    private long id;
    private String description;
    private String cnpj;
    private String address;
    private String neighborhood;
    private String city;
    private String state;
    private String telephone;
}
