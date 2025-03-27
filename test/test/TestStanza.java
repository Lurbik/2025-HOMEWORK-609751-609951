package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
<<<<<<< HEAD
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.giocatore.*;
=======
>>>>>>> provaLurbik
class TestStanza {

	private Stanza atrio;
    private Stanza aulaN11;
    private Stanza biblioteca;
    private Attrezzo lanterna;
<<<<<<< HEAD
=======
    private Attrezzo spada;
    private Attrezzo osso;
>>>>>>> provaLurbik
    

    @BeforeEach
    void setUp() {
        // Creiamo la stanza atrio e gli altri oggetti necessari per i test
        atrio = new Stanza("Atrio");
        aulaN11 = new Stanza("Aula N11");
        biblioteca = new Stanza("Biblioteca");

        // Creiamo attrezzi
        lanterna = new Attrezzo("lanterna", 3);
<<<<<<< HEAD
=======
        spada = new Attrezzo("spada", 8);
        osso = new Attrezzo("osso", 1);
>>>>>>> provaLurbik
        
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
<<<<<<< HEAD
=======
    
    @Test
    void testAggiungiAttrezzo2() {
        // Verifica che più attrezzi possano essere inseriti in una stanza
        assertTrue(atrio.addAttrezzo(lanterna), "L'attrezzo 'lanterna' dovrebbe essere aggiunto correttamente");
        assertTrue(atrio.addAttrezzo(spada), "L'attrezzo 'spada' dovrebbe essere aggiunto correttamente");
        assertTrue(atrio.addAttrezzo(osso), "L'attrezzo 'osso' dovrebbe essere aggiunto correttamente");
        assertTrue(atrio.hasAttrezzo("lanterna"), "La stanza dovrebbe contenere l'attrezzo 'lanterna'");
        assertTrue(atrio.hasAttrezzo("spada"), "La stanza dovrebbe contenere l'attrezzo 'spada'");
        assertTrue(atrio.hasAttrezzo("osso"), "La stanza dovrebbe contenere l'attrezzo 'osso'");
    }
    
    @Test
    void testAggiungiAttrezzo3() {
        // Verifica che inserendo 1 attrezzo la stanza abbia solo quell'attrezzo
        assertTrue(atrio.addAttrezzo(lanterna), "L'attrezzo 'lanterna' dovrebbe essere aggiunto correttamente");
        assertTrue(atrio.hasAttrezzo("lanterna"), "La stanza dovrebbe contenere l'attrezzo 'lanterna'");
        assertFalse(atrio.hasAttrezzo("spada"), "La stanza non dovrebbe contenere l'attrezzo 'spada'");
        assertFalse(atrio.hasAttrezzo("osso"), "La stanza non dovrebbe contenere l'attrezzo 'osso'");
    }
>>>>>>> provaLurbik

    @Test
    void testRimozioneAttrezzo() {
        // Aggiungiamo e rimuoviamo un attrezzo dalla stanza
        atrio.addAttrezzo(lanterna);
        boolean attrezzoRimosso = atrio.removeAttrezzo(lanterna);
        
        assertTrue(attrezzoRimosso, "L'attrezzo dovrebbe essere rimosso correttamente");
        assertFalse(atrio.hasAttrezzo("lanterna"), "La stanza non dovrebbe più contenere l'attrezzo 'lanterna'");
    }
<<<<<<< HEAD
=======
    
    @Test
    void testRimozioneAttrezzo2() {
        // Aggiungiamo più attrezzi e ne rimuoviamo solo 1 verificando che mantenga gli altri 2
        atrio.addAttrezzo(lanterna);
        atrio.addAttrezzo(spada);
        atrio.addAttrezzo(osso);
        boolean attrezzoRimosso = atrio.removeAttrezzo(spada);
        
        assertTrue(attrezzoRimosso, "L'attrezzo dovrebbe essere rimosso correttamente");
        assertFalse(atrio.hasAttrezzo("spada"), "La stanza non dovrebbe più contenere l'attrezzo 'spada'");
        assertTrue(atrio.hasAttrezzo("lanterna"), "La stanza dovrebbe ancora contenere l'attrezzo 'lanterna'");
        assertTrue(atrio.hasAttrezzo("osso"), "La stanza dovrebbe ancora contenere l'attrezzo 'osso'");
    }
    
    @Test
    void testRimozioneAttrezzo3() {
        // Aggiungiamo un attrezzo e ne rimuoviamo un altro non presente, verificando che non tolga nessun attrezzo
        atrio.addAttrezzo(lanterna);
        boolean attrezzoRimosso = atrio.removeAttrezzo(spada);
        
        assertFalse(attrezzoRimosso, "L'attrezzo dovrebbe essere rimosso correttamente");
        assertTrue(atrio.hasAttrezzo("lanterna"), "La stanza dovrebbe ancora contenere l'attrezzo 'lanterna'");
    }
>>>>>>> provaLurbik

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
