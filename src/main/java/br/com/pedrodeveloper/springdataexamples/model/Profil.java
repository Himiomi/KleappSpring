package br.com.pedrodeveloper.springdataexamples.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Profil")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ref_type", discriminatorType = DiscriminatorType.STRING)
public class Profil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ref_id")
    private Long refId;

    private String localisation;

    private String preference;

    private String recherche;

}
