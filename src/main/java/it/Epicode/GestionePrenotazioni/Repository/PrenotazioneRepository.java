package it.Epicode.GestionePrenotazioni.Repository;

import it.Epicode.GestionePrenotazioni.Entities.Postazione;
import it.Epicode.GestionePrenotazioni.Entities.Prenotazione;
import it.Epicode.GestionePrenotazioni.Entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Integer> {

    boolean existsByUtenteAndData(Utente utente, LocalDate data);
    boolean existsByPostazioneAndData(Postazione postazione, LocalDate data);
    List<Prenotazione> findByUtente(Utente utente);
}
