package it.Epicode.GestionePrenotazioni.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Edificio {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String indirizzo;
    private String citta;

   @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni;
}
