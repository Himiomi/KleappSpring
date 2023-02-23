package br.com.pedrodeveloper.springdataexamples.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "Couple")
public class Couple {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IdPersonneUn")
    private User personneUn;

    @ManyToOne
    @JoinColumn(name = "IdPersonneDeux")
    private User personneDeux;

}
