package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.giocatore.Borsa;

class TestGiocatore {

	
	
	private Giocatore giocatore;
    private Attrezzo lanterna;
    private Attrezzo osso;

    @BeforeEach
    void setUp() {
        // Creiamo una nuova istanza di Giocatore e Attrezzi prima di ogni test
        giocatore = new Giocatore();
        lanterna = new Attrezzo("lanterna", 3); // peso 3
        osso = new Attrezzo("osso", 1);         // peso 1
    }

    @Test
    void testPrendereAttrezzo() {
        // Verifica che l'attrezzo venga aggiunto alla borsa
        assertTrue(giocatore.prendereAttrezzo(lanterna), "L'attrezzo 'lanterna' dovrebbe essere preso correttamente");
        // Verifica che la borsa contenga l'attrezzo
        assertTrue(giocatore.getBorsa().hasAttrezzo("lanterna"), "La borsa dovrebbe contenere l'attrezzo 'lanterna'");
    }

    @Test
    void testPosareAttrezzo() {
        // Aggiungiamo l'attrezzo 'lanterna' alla borsa
        giocatore.prendereAttrezzo(lanterna);
        // Verifica che l'attrezzo venga rimosso correttamente dalla borsa
        Attrezzo attrezzoPosato = giocatore.posareAttrezzo("lanterna");
        assertNotNull(attrezzoPosato, "L'attrezzo 'lanterna' dovrebbe essere posato correttamente");
        assertFalse(giocatore.getBorsa().hasAttrezzo("lanterna"), "La borsa non dovrebbe contenere l'attrezzo 'lanterna' dopo essere stato posato");
    }

    @Test
    void testCFU() {
        // Verifica che i CFU vengano inizializzati correttamente
        assertEquals(0, giocatore.getCfu(), "I CFU iniziali dovrebbero essere 0");
        // Modifica i CFU
        giocatore.setCfu(10);
        assertEquals(10, giocatore.getCfu(), "I CFU dovrebbero essere impostati correttamente su 10");
    }

    @Test
    void testBorsaInizialmenteVuota() {
        // Verifica che la borsa sia inizialmente vuota
        assertTrue(giocatore.getBorsa().isEmpty(), "La borsa dovrebbe essere vuota inizialmente");
    }

    @Test
    void testPesoBorsa() {
        // Verifica il peso della borsa
        assertEquals(0, giocatore.getBorsa().getPeso(), "Il peso della borsa inizialmente dovrebbe essere 0");

        // Aggiungi l'attrezzo "lanterna"
        giocatore.prendereAttrezzo(lanterna);
        assertEquals(3, giocatore.getBorsa().getPeso(), "Il peso della borsa dovrebbe essere 3 dopo aver preso la lanterna");

        // Aggiungi l'attrezzo "osso"
        giocatore.prendereAttrezzo(osso);
        assertEquals(4, giocatore.getBorsa().getPeso(), "Il peso della borsa dovrebbe essere 4 dopo aver preso anche l'osso");
    }

    @Test
    void testRimozioneAttrezzoDallaBorsa() {
        // Aggiungi due attrezzi alla borsa
        giocatore.prendereAttrezzo(lanterna);
        giocatore.prendereAttrezzo(osso);

        // Rimuovi l'attrezzo "lanterna"
        giocatore.posareAttrezzo("lanterna");

        // Verifica che la borsa contenga solo l'attrezzo "osso"
        assertFalse(giocatore.getBorsa().hasAttrezzo("lanterna"), "La borsa non dovrebbe contenere l'attrezzo 'lanterna'");
        assertTrue(giocatore.getBorsa().hasAttrezzo("osso"), "La borsa dovrebbe contenere l'attrezzo 'osso'");
    }

}
