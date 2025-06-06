package it.Epicode.GestionePrenotazioni.Repository;

import it.Epicode.GestionePrenotazioni.Entities.Postazione;
import it.Epicode.GestionePrenotazioni.Enumeration.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione,Integer> {


    List<Postazione> findByTipoPostazioneAndEdificio_CittaIgnoreCase(TipoPostazione tipo, String citta);
}

