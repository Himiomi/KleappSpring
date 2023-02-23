package br.com.pedrodeveloper.springdataexamples.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "person")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;

    @Column(name = "mot_de_passe")
    private String motDePasse;

    @GeneratedValue(generator = "pg-uuid")
    @GenericGenerator(name = "pg-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "identifiant", columnDefinition = "uuid")
    private String identifiant;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_compte")
    private Date creationCompte;

    @Column(name = "genre")
    private Long genre;

    @PrePersist
    public void onCreate() {
        creationCompte = new Date();
    }

}

