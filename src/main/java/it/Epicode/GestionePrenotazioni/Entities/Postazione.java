package it.Epicode.GestionePrenotazioni.Entities;

import it.Epicode.GestionePrenotazioni.Enumeration.TipoPostazione;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Postazione {
    @Id
    @GeneratedValue
    private int id;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;

    private int numMaxP;

@ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

@OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;







}
