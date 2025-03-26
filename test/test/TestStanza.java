package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
class TestStanza {

	private Stanza atrio;
    private Stanza aulaN11;
    private Stanza biblioteca;
    private Attrezzo lanterna;
    

    @BeforeEach
    void setUp() {
        // Creiamo la stanza atrio e gli altri oggetti necessari per i test
        atrio = new Stanza("Atrio");
        aulaN11 = new Stanza("Aula N11");
        biblioteca = new Stanza("Biblioteca");

        // Creiamo attrezzi
        lanterna = new Attrezzo("lanterna", 3);
        
    }

    @Test
    void testStanzaIniziale() {
        // Verifica che la stanza sia correttamente inizializzata
        assertNotNull(atrio, "La stanza 'Atrio' non dovrebbe essere null");
        assertEquals("Atrio", atrio.getNome(), "Il nome della stanza non è corretto");
    }

    @Test
    void testAggiungiAttrezzo() {
        // Verifica che l'attrezzo venga aggiunto correttamente
        assertTrue(atrio.addAttrezzo(lanterna), "L'attrezzo 'lanterna' dovrebbe essere aggiunto correttamente");
        assertTrue(atrio.hasAttrezzo("lanterna"), "La stanza dovrebbe contenere l'attrezzo 'lanterna'");
    }

    @Test
    void testRimozioneAttrezzo() {
        // Aggiungiamo e rimuoviamo un attrezzo dalla stanza
        atrio.addAttrezzo(lanterna);
        Attrezzo attrezzoRimosso = atrio.removeAttrezzo(lanterna);
        
        assertNotNull(attrezzoRimosso, "L'attrezzo dovrebbe essere rimosso correttamente");
        assertFalse(atrio.hasAttrezzo("lanterna"), "La stanza non dovrebbe più contenere l'attrezzo 'lanterna'");
    }

    @Test
    void testGetAttrezzo() {
        // Verifica che l'attrezzo venga recuperato correttamente
        atrio.addAttrezzo(lanterna);
        Attrezzo attrezzoTrovato = atrio.getAttrezzo("lanterna");
        assertNotNull(attrezzoTrovato, "L'attrezzo 'lanterna' dovrebbe essere trovato");
        assertEquals("lanterna", attrezzoTrovato.getNome(), "Il nome dell'attrezzo trovato non è corretto");
    }

    @Test
    void testImpostaStanzaAdiacente() {
        // Impostiamo la stanza adiacente e verifichiamo che sia correttamente collegata
        atrio.impostaStanzaAdiacente("nord", aulaN11);
        Stanza stanzaAdiacente = atrio.getStanzaAdiacente("nord");
        assertNotNull(stanzaAdiacente, "La stanza adiacente a nord non dovrebbe essere null");
        assertEquals("Aula N11", stanzaAdiacente.getNome(), "La stanza adiacente a nord dovrebbe essere l'Aula N11");
    }

    @Test
    void testGetDirezioni() {
        // Verifica che le direzioni siano correttamente assegnate
        atrio.impostaStanzaAdiacente("nord", aulaN11);
        atrio.impostaStanzaAdiacente("est", biblioteca);
        
        String[] direzioni = atrio.getDirezioni();
        assertEquals(2, direzioni.length, "Le direzioni dovrebbero essere 2");
        assertTrue(direzioni[0].equals("nord") || direzioni[1].equals("nord"), "La direzione 'nord' dovrebbe essere presente");
        assertTrue(direzioni[0].equals("est") || direzioni[1].equals("est"), "La direzione 'est' dovrebbe essere presente");
    }

    @Test
    void testToString() {
        // Verifica che il metodo toString restituisca una descrizione corretta della stanza
        atrio.addAttrezzo(lanterna);
        String descrizione = atrio.toString();
        assertTrue(descrizione.contains("Atrio"), "La descrizione dovrebbe contenere il nome della stanza");
        assertTrue(descrizione.contains("lanterna"), "La descrizione dovrebbe contenere il nome dell'attrezzo");
    }

}
