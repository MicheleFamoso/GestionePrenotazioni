package it.Epicode.GestionePrenotazioni;

import it.Epicode.GestionePrenotazioni.Entities.Postazione;
import it.Epicode.GestionePrenotazioni.Entities.Prenotazione;
import it.Epicode.GestionePrenotazioni.Entities.Utente;
import it.Epicode.GestionePrenotazioni.Enumeration.TipoPostazione;
import it.Epicode.GestionePrenotazioni.Repository.PostazioneRepository;
import it.Epicode.GestionePrenotazioni.Repository.PrenotazioneRepository;
import it.Epicode.GestionePrenotazioni.Repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


@Component
public class RunnerUtente implements CommandLineRunner {


    @Autowired
    private PostazioneRepository postazioneRepo;
    @Autowired
    private PrenotazioneRepository prenotazioneRepo;
    @Autowired
    private UtenteRepository utenteRepo;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci username:");
        String username = scanner.nextLine();

        Utente utente = utenteRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));

        System.out.println("Cosa vuoi fare?");
        System.out.println("1) Prenota una postazione");
        System.out.println("2) Visualizza le tue prenotazioni");
        String sceltaUtente = scanner.nextLine();

        switch (sceltaUtente) {
            case "1" -> {
                System.out.println("Inserisci tipo di postazione (PRIVATO, OPENSPACE, SALARUNIONI):");
                TipoPostazione tipo = TipoPostazione.valueOf(scanner.nextLine().toUpperCase());

                System.out.println("Inserisci città:");
                String citta = scanner.nextLine();

                LocalDate data = null;
                while (data == null) {
                    try {
                        System.out.println("Inserisci data (yyyy-MM-dd):");
                        String inputData = scanner.nextLine();
                        data = LocalDate.parse(inputData);
                    } catch (Exception e) {
                        System.out.println("Formato data non valido. Riprova.");
                    }
                }

                boolean haPrenotazione = prenotazioneRepo.existsByUtenteAndData(utente, data);
                if (haPrenotazione) {
                    System.out.println("Hai già una prenotazione per quella data.");
                    return;
                }
                LocalDate finalData = data;
                List<Postazione> disponibili = postazioneRepo.findByTipoPostazioneAndEdificio_CittaIgnoreCase(tipo, citta).stream()
                        .filter(p -> !prenotazioneRepo.existsByPostazioneAndData(p, finalData))
                        .toList();

                if (disponibili.isEmpty()) {
                    System.out.println("Nessuna postazione disponibile trovata.");
                    return;
                }

                System.out.println("Postazioni disponibili:");
                for (int i = 0; i < disponibili.size(); i++) {
                    System.out.println((i + 1) + ") " + disponibili.get(i).getDescrizione());
                }

                System.out.println("Seleziona una postazione (numero):");
                int scelta = Integer.parseInt(scanner.nextLine());

                Postazione sceltaPostazione = disponibili.get(scelta - 1);

                Prenotazione prenotazione = new Prenotazione();
                prenotazione.setUtente(utente);
                prenotazione.setPostazione(sceltaPostazione);
                prenotazione.setData(data);
                prenotazioneRepo.save(prenotazione);

                System.out.println("Prenotazione effettuata con successo!");
            }
            case "2" -> {
                List<Prenotazione> prenotazioni = prenotazioneRepo.findByUtente(utente);
                if (prenotazioni.isEmpty()) {
                    System.out.println("Nessuna prenotazione trovata.");
                } else {
                    System.out.println("Le tue prenotazioni:");
                    for (Prenotazione p : prenotazioni) {
                        System.out.println("- " + p.getData() + " = " + p.getPostazione().getDescrizione() + " (" + p.getPostazione().getEdificio().getCitta() + ")");
                    }
                }
            }
            default -> System.out.println("Scelta non valida.");
        }
    }}