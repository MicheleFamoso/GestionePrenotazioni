package it.Epicode.GestionePrenotazioni.Repository;

import it.Epicode.GestionePrenotazioni.Entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente,Integer> {


        Optional<Utente> findByUsername(String username);

}
