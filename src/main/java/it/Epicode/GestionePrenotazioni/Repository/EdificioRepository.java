package it.Epicode.GestionePrenotazioni.Repository;

import it.Epicode.GestionePrenotazioni.Entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<Edificio,Integer> {
}
