package it.Epicode.GestionePrenotazioni.Configuration;

import it.Epicode.GestionePrenotazioni.Entities.Edificio;
import it.Epicode.GestionePrenotazioni.Entities.Postazione;
import it.Epicode.GestionePrenotazioni.Entities.Utente;
import it.Epicode.GestionePrenotazioni.Enumeration.TipoPostazione;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfing {

    @Bean("utenteL")
    public Utente getUtenteL() {
        Utente u = new Utente();
        u.setUsername("Elle");
        u.setNomeCompleto("L Lawliet");
        u.setEmail("L.Lawliet@email.com");
        return u;
    }

    @Bean("PostPrivataNapoli")
    public Postazione getPostPrivataNapoli(Edificio edificioNapoli){
        Postazione p1 = new Postazione();
        p1.setTipoPostazione(TipoPostazione.PRIVATO);
        p1.setDescrizione("Postazione privata ottima per lavorare in pace");
        p1.setNumMaxP(20);
        p1.setEdificio(edificioNapoli);
        return p1;
    }

    @Bean("PostOpenNapoli")
    public Postazione getPostOpenNapoli(Edificio edificioNapoli){
        Postazione p1 = new Postazione();
        p1.setTipoPostazione(TipoPostazione.OPENSPACE);
        p1.setDescrizione("Postazione privata ottima per lavorare in gruppo");
        p1.setNumMaxP(20);
        p1.setEdificio(edificioNapoli);
        return p1;
    }

    @Bean("PostRunioniNapoli")
    public Postazione getPostRunioniNapoli(Edificio edificioNapoli){
        Postazione p1 = new Postazione();
        p1.setTipoPostazione(TipoPostazione.SALARUNIONI);
        p1.setDescrizione("Sala runioni");
        p1.setNumMaxP(16);
        p1.setEdificio(edificioNapoli);
        return p1;
    }

    @Bean("edificioNapoli")
    public Edificio getEdificioNapoli(){
        Edificio em = new Edificio();
        em.setCitta("Napoli");
        em.setNome("Edificio A");
        em.setIndirizzo("Via Napoli 35");
        return em;
    }

    @Bean("PostPrivataRoma")
    public Postazione getPostPrivataRoma(Edificio edificioRoma){
        Postazione p1 = new Postazione();
        p1.setTipoPostazione(TipoPostazione.PRIVATO);
        p1.setDescrizione("Postazione privata ottima per lavorare in pace");
        p1.setNumMaxP(20);
        p1.setEdificio(edificioRoma);
        return p1;
    }

    @Bean("PostOpenRoma")
    public Postazione getPostOpenRoma(Edificio edificioRoma){
        Postazione p1 = new Postazione();
        p1.setTipoPostazione(TipoPostazione.OPENSPACE);
        p1.setDescrizione("Postazione privata ottima per lavorare in gruppo");
        p1.setNumMaxP(45);
        p1.setEdificio(edificioRoma);
        return p1;
    }
    @Bean("PostRunioniRoma")
    public Postazione getPostRunioniRoma(Edificio edificioRoma){
        Postazione p1 = new Postazione();
        p1.setTipoPostazione(TipoPostazione.SALARUNIONI);
        p1.setDescrizione("Sala Runioni");
        p1.setNumMaxP(145);
        p1.setEdificio(edificioRoma);
        return p1;
    }

    @Bean("edificioRoma")
    public Edificio getEdificioRoma(){
        Edificio em = new Edificio();
        em.setCitta("Roma");
        em.setNome("Edificio A");
        em.setIndirizzo("Via Roma 5");
        return em;
    }

    @Bean("PostPrivataMilano")
    public Postazione getPostPrivataMilano(Edificio edificioMilano){
        Postazione p1 = new Postazione();
        p1.setTipoPostazione(TipoPostazione.PRIVATO);
        p1.setDescrizione("Postazione privata ottima per lavorare in pace");
        p1.setNumMaxP(20);
        p1.setEdificio(edificioMilano);
        return p1;
    }

    @Bean("PostOpenMilano")
    public Postazione getPostOpenMilano(Edificio edificioMilano){
        Postazione p1 = new Postazione();
        p1.setTipoPostazione(TipoPostazione.OPENSPACE);
        p1.setDescrizione("Postazione privata ottima per lavorare in gruppo");
        p1.setNumMaxP(90);
        p1.setEdificio(edificioMilano);
        return p1;
    }
    @Bean("PostRunioniMilano")
    public Postazione getPostRunioniMilano(Edificio edificioMilano){
        Postazione p1 = new Postazione();
        p1.setTipoPostazione(TipoPostazione.SALARUNIONI);
        p1.setDescrizione("Sala runioni");
        p1.setNumMaxP(50);
        p1.setEdificio(edificioMilano);
        return p1;
    }

    @Bean("edificioMilano")
    public Edificio getEdificioMilano(){
        Edificio em = new Edificio();
        em.setCitta("Milano");
        em.setNome("Edificio A");
        em.setIndirizzo("Via Milano 75");
        return em;
    }





}
