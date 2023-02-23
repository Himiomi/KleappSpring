package br.com.pedrodeveloper.springdataexamples.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "Genre")
@Data
public class Genre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nom")
    private String nom;

}
