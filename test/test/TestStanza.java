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
    private Attrezzo spada;
    private Attrezzo osso;


    @BeforeEach
    void setUp() {
        // Creiamo la stanza atrio e gli altri oggetti necessari per i test
        atrio = new Stanza("Atrio");
        aulaN11 = new Stanza("Aula N11");
        biblioteca = new Stanza("Biblioteca");

        // Creiamo attrezzi
        lanterna = new Attrezzo("lanterna", 3);
        spada = new Attrezzo("spada", 8);
        osso = new Attrezzo("osso", 1);

        
    }

    

    @Test
    void testAggiungiAttrezzo() {
        // Verifica che l'attrezzo venga aggiunto correttamente
        assertTrue(atrio.addAttrezzo(lanterna), "L'attrezzo 'lanterna' dovrebbe essere aggiunto correttamente");
        assertTrue(atrio.hasAttrezzo("lanterna"), "La stanza dovrebbe contenere l'attrezzo 'lanterna'");
    }
  
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


    @Test
    void testRimozioneAttrezzo() {
        // Aggiungiamo e rimuoviamo un attrezzo dalla stanza
        atrio.addAttrezzo(lanterna);
        boolean attrezzoRimosso = atrio.removeAttrezzo(lanterna);
        
        assertTrue(attrezzoRimosso, "L'attrezzo dovrebbe essere rimosso correttamente");
        assertFalse(atrio.hasAttrezzo("lanterna"), "La stanza non dovrebbe più contenere l'attrezzo 'lanterna'");
    }

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


    @Test
    void testGetAttrezzo() {
        // Verifica che l'attrezzo venga recuperato correttamente
        atrio.addAttrezzo(lanterna);
        Attrezzo attrezzoTrovato = atrio.getAttrezzo("lanterna");
        assertNotNull(attrezzoTrovato, "L'attrezzo 'lanterna' dovrebbe essere trovato");
        assertEquals("lanterna", attrezzoTrovato.getNome(), "Il nome dell'attrezzo trovato non è corretto");
    }
    
    @Test
    void testGetAttrezzo2() {
        // Verifica che all'aggiunta di più attrezzi possa trovarli tutti
        atrio.addAttrezzo(lanterna);
        atrio.addAttrezzo(osso);
        Attrezzo attrezzoTrovato1 = atrio.getAttrezzo("lanterna");
        Attrezzo attrezzoTrovato2 = atrio.getAttrezzo("osso");
        assertNotNull(attrezzoTrovato1, "L'attrezzo 'lanterna' dovrebbe essere trovato");
        assertNotNull(attrezzoTrovato2, "L'attrezzo 'osso' dovrebbe essere trovato");
        assertEquals("lanterna", attrezzoTrovato1.getNome(), "Il nome dell'attrezzo trovato è corretto");
        assertEquals("osso", attrezzoTrovato2.getNome(), "Il nome dell'attrezzo trovato è corretto");
    }
    
    @Test
    void testGetAttrezzo3() {
        // Verifica che all'aggiunta di 1 attrezzo non me ne trovi un altro
        atrio.addAttrezzo(lanterna);
        Attrezzo attrezzoTrovato1 = atrio.getAttrezzo("osso");
        Attrezzo attrezzoTrovato2 = atrio.getAttrezzo("spada");
        assertNull(attrezzoTrovato1, "L'attrezzo 'osso' non dovrebbe essere trovato");
        assertNull(attrezzoTrovato2, "L'attrezzo 'spada' non dovrebbe essere trovato");
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
    void testImpostaStanzaAdiacente2() {
    	// Impostiamo due stanze adiacenti e verifichiamo che siano correttamente collegate
    	atrio.impostaStanzaAdiacente("nord", aulaN11);
    	atrio.impostaStanzaAdiacente("sud", biblioteca);
    	Stanza stanzaAdiacente = atrio.getStanzaAdiacente("nord");
    	Stanza stanzaAdiacente2 = atrio.getStanzaAdiacente("sud");
    	assertEquals("Aula N11", stanzaAdiacente.getNome(), "La stanza adiacente a nord dovrebbe essere l'Aula N11");
    	assertEquals("Biblioteca", stanzaAdiacente2.getNome(), "La stanza adiacente a sud dovrebbe essere la Biblioteca");
    }
    
    @Test
    void testImpostaStanzaAdiacente3() {
    	atrio.impostaStanzaAdiacente("nord", aulaN11);
        atrio.impostaStanzaAdiacente("sud", biblioteca);
        
        // Verifica che la direzione "est" non sia stata impostata
        Stanza stanzaAdiacenteEst = atrio.getStanzaAdiacente("est");
        
        // Ci aspettiamo che la stanza adiacente verso "est" sia null
        assertNull(stanzaAdiacenteEst, "La stanza adiacente a est non dovrebbe esistere");
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
    void testGetDirezioni2() {
    	atrio.impostaStanzaAdiacente("nord", aulaN11);
        atrio.impostaStanzaAdiacente("est", biblioteca);
        
        String[] direzioni = atrio.getDirezioni();
        assertEquals(2, direzioni.length, "Le direzioni dovrebbero essere 2");
        assertFalse(direzioni[0].equals("ovest") || direzioni[1].equals("nord"), "La direzione 'nord' dovrebbe essere presente");
        assertTrue(direzioni[0].equals("est") || direzioni[1].equals("est"), "La direzione 'est' dovrebbe essere presente");
    }
    
    @Test
    void testGetDirezioni3() {
    	//aggiungiamo più stanze
    	Stanza aulaN10 = new Stanza("Aula N10");
        Stanza aulacampus = new Stanza("AulaCampus");
        Stanza rettorato = new Stanza("Rettorato");
        //impostiamo come stanze adiacenti piu stanze del dovuto
    	atrio.impostaStanzaAdiacente("nord", aulaN11);
        atrio.impostaStanzaAdiacente("est", biblioteca);
        atrio.impostaStanzaAdiacente("sud", aulacampus );
        atrio.impostaStanzaAdiacente("ovest", aulaN10);
        atrio.impostaStanzaAdiacente("nord", rettorato);    
        String[] direzioni = atrio.getDirezioni();
        assertEquals(4, direzioni.length, "Le direzioni dovrebbero essere 4");
        assertTrue(direzioni[0].equals("nord") || direzioni[1].equals("nord")|| direzioni[2].equals("nord")|| direzioni[3].equals("nord"), "La direzione 'nord' dovrebbe essere presente");
        assertTrue(direzioni[0].equals("est") || direzioni[1].equals("est")|| direzioni[2].equals("est")|| direzioni[3].equals("est"), "La direzione 'est' dovrebbe essere presente");
        assertTrue(direzioni[0].equals("ovest") || direzioni[1].equals("ovest")|| direzioni[2].equals("ovest")|| direzioni[3].equals("ovest"), "La direzione 'nord' dovrebbe essere presente");
        assertTrue(direzioni[0].equals("sud") || direzioni[1].equals("sud")|| direzioni[2].equals("sud")|| direzioni[3].equals("sud"), "La direzione 'est' dovrebbe essere presente");
        assertTrue(atrio.getStanzaAdiacente("nord").equals(rettorato), "La stanza a nord dovrebbe essere rettorato in quanto sovrascrive aula N11");
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
