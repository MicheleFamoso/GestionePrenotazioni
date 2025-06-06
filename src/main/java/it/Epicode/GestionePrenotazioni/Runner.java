package it.Epicode.GestionePrenotazioni;

import it.Epicode.GestionePrenotazioni.Entities.Edificio;
import it.Epicode.GestionePrenotazioni.Entities.Postazione;
import it.Epicode.GestionePrenotazioni.Entities.Prenotazione;
import it.Epicode.GestionePrenotazioni.Entities.Utente;
import it.Epicode.GestionePrenotazioni.Repository.EdificioRepository;
import it.Epicode.GestionePrenotazioni.Repository.PostazioneRepository;
import it.Epicode.GestionePrenotazioni.Repository.PrenotazioneRepository;
import it.Epicode.GestionePrenotazioni.Repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    //Utente
    @Autowired
    @Qualifier("utenteL")
    private Utente utente1;

    //Edifici

    @Autowired
    @Qualifier("edificioNapoli")
    private Edificio napoli;

    @Autowired
    @Qualifier("edificioRoma")
    private Edificio roma;

    @Autowired
    @Qualifier("edificioMilano")
    private Edificio milano;

    //Postazioni

    //Private
    @Autowired
    @Qualifier("PostPrivataNapoli")
    private Postazione pPrivNap;
    @Autowired
    @Qualifier("PostPrivataRoma")
    private Postazione pPrivRoma;
    @Autowired
    @Qualifier("PostPrivataMilano")
    private Postazione pPrivMil;

    //Open
    @Autowired
    @Qualifier("PostOpenNapoli")
    private Postazione pOpNap;
    @Autowired
    @Qualifier("PostOpenRoma")
    private Postazione pOpRoma;
    @Autowired
    @Qualifier("PostOpenMilano")
    private Postazione pOpMil;

    //Runioni

    @Autowired
    @Qualifier("PostRunioniNapoli")
    private Postazione pRunNap;
    @Autowired
    @Qualifier("PostRunioniRoma")
    private Postazione pRunRoma;
    @Autowired
    @Qualifier("PostRunioniMilano")
    private Postazione pRunMil;


    @Override
    public void run(String... args) throws Exception {

        edificioRepository.save(napoli);
        edificioRepository.save(roma);
        edificioRepository.save(milano);

        postazioneRepository.save(pPrivNap);
        postazioneRepository.save(pPrivRoma);
        postazioneRepository.save(pPrivMil);
        postazioneRepository.save(pOpNap);
        postazioneRepository.save(pOpRoma);
        postazioneRepository.save(pOpMil);
        postazioneRepository.save(pRunNap);
        postazioneRepository.save(pRunRoma);
        postazioneRepository.save(pRunMil);

        utenteRepository.save(utente1);

        Prenotazione p = new Prenotazione();
        p.setData(LocalDate.of(2025, 6, 7));
        p.setUtente(utente1);
        p.setPostazione(pPrivNap);
        prenotazioneRepository.save(p);

    }
}
