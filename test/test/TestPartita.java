package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.Labirinto;


class TestPartita {

	private Partita partita;
    private Stanza atrio;
    private Stanza biblioteca;
    private Giocatore giocatore;

    @BeforeEach
    void setUp() {
        // Inizializza il gioco prima di ogni test
        partita = new Partita();
        atrio = partita.getStanzaCorrente();
        biblioteca = partita.getStanzaVincente();
        giocatore = partita.getGiocatore();
    }

    @Test
    void testStanzeIniziali() {
        // Verifica che la partita inizi correttamente con le stanze
        assertNotNull(atrio, "La stanza corrente non dovrebbe essere null");
        assertNotNull(biblioteca, "La stanza vincente non dovrebbe essere null");

        // Verifica che la stanza iniziale sia correttamente l'atrio
        assertEquals("Atrio", atrio.getNome(), "La stanza corrente dovrebbe essere l'atrio");
        
        // Verifica che la stanza vincente sia correttamente la biblioteca
        assertEquals("Biblioteca", biblioteca.getNome(), "La stanza vincente dovrebbe essere la biblioteca");
    }

    @Test
    void testVinta() {
        // Verifica che la partita non sia vinta inizialmente
        assertFalse(partita.vinta(), "La partita non dovrebbe essere vinta all'inizio");

        // Cambiamo la stanza corrente e testiamo che la partita sia vinta
        partita.setStanzaCorrente(biblioteca);
        assertTrue(partita.vinta(), "La partita dovrebbe essere vinta quando si arriva alla stanza vincente");
    }

    @Test
    void testIsFinita() {
        // Verifica che la partita non sia finita inizialmente
        assertFalse(partita.isFinita(), "La partita non dovrebbe essere finita all'inizio");

        // Impostiamo la partita come finita
        partita.setFinita();
        assertTrue(partita.isFinita(), "La partita dovrebbe essere finita dopo che è stato impostato il flag 'finita'");

        // Impostiamo la stanza corrente come la stanza vincente
        partita.setStanzaCorrente(biblioteca);
        assertTrue(partita.isFinita(), "La partita dovrebbe essere finita quando la stanza vincente è raggiunta");

        // Impostiamo i CFU a 0
        giocatore.setCfu(0);
        assertTrue(partita.isFinita(), "La partita dovrebbe essere finita quando i CFU sono a 0");
    }

    @Test
    void testSetCfu() {
        // Verifica che i CFU siano inizializzati correttamente
        assertEquals(20, giocatore.getCfu(), "I CFU iniziali del giocatore dovrebbero essere 20");

        // Modifica i CFU
        partita.setCfu(10);
        assertEquals(10, giocatore.getCfu(), "I CFU dovrebbero essere aggiornati correttamente a 10");

        // Imposta i CFU a 5
        giocatore.setCfu(5);
        assertEquals(5, giocatore.getCfu(), "I CFU dovrebbero essere impostati correttamente a 5");
    }

    @Test
    void testGetGiocatore() {
        // Verifica che il giocatore venga restituito correttamente
        assertNotNull(partita.getGiocatore(), "Il giocatore non dovrebbe essere null");
        assertEquals(giocatore, partita.getGiocatore(), "Il giocatore dovrebbe essere lo stesso oggetto restituito da getGiocatore");
    }

    @Test
    void testFinitaConCfuZero() {
        // Impostiamo i CFU a 0 e verifichiamo che la partita sia finita
        giocatore.setCfu(0);
        assertTrue(partita.isFinita(), "La partita dovrebbe essere finita quando i CFU sono a 0");
    }
}
