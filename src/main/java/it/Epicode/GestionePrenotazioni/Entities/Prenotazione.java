package it.Epicode.GestionePrenotazioni.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@Entity
public class Prenotazione {

    @Id
    @GeneratedValue
    private int id;
    private LocalDate data;
    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;


}
