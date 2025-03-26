package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class TestBorsa {

	
	
	private Borsa borsa;
    private Attrezzo lanterna;
    private Attrezzo osso;
    private Attrezzo spada;

    @BeforeEach
    void setUp() {
        // Inizializziamo la borsa e gli attrezzi prima di ogni test
        borsa = new Borsa();
        lanterna = new Attrezzo("lanterna", 3); // peso 3
        osso = new Attrezzo("osso", 1);         // peso 1
        
    }

    @Test
    void testAddAttrezzo() {
        // Verifica che l'attrezzo "lanterna" venga aggiunto correttamente
        assertTrue(borsa.addAttrezzo(lanterna), "L'attrezzo 'lanterna' dovrebbe essere aggiunto correttamente");
        
        // Verifica che la borsa contenga l'attrezzo "lanterna"
        assertTrue(borsa.hasAttrezzo("lanterna"), "La borsa dovrebbe contenere 'lanterna'");
        
        // Aggiungiamo un altro attrezzo
        assertTrue(borsa.addAttrezzo(osso), "L'attrezzo 'osso' dovrebbe essere aggiunto correttamente");
        
        // Verifica che entrambi gli attrezzi siano presenti
        assertTrue(borsa.hasAttrezzo("lanterna"), "La borsa dovrebbe contenere 'lanterna'");
        assertTrue(borsa.hasAttrezzo("osso"), "La borsa dovrebbe contenere 'osso'");
    }

    @Test
    void testGetPeso() {
        // Verifica che il peso della borsa sia inizialmente 0
        assertEquals(0, borsa.getPeso(), "Il peso iniziale della borsa dovrebbe essere 0");

        // Aggiungiamo un attrezzo e verifichiamo il peso
        borsa.addAttrezzo(lanterna);
        assertEquals(3, borsa.getPeso(), "Il peso della borsa dovrebbe essere 3 dopo aver aggiunto 'lanterna'");

        // Aggiungiamo un altro attrezzo e verifichiamo il peso
        borsa.addAttrezzo(osso);
        assertEquals(4, borsa.getPeso(), "Il peso della borsa dovrebbe essere 4 dopo aver aggiunto 'osso'");
    }

    @Test
    void testRemoveAttrezzo() {
        // Aggiungiamo due attrezzi
        borsa.addAttrezzo(lanterna);
        borsa.addAttrezzo(osso);

        // Rimuoviamo un attrezzo e verifichiamo che sia stato rimosso
        Attrezzo attrezzoRimosso = borsa.removeAttrezzo("lanterna");
        assertEquals(lanterna, attrezzoRimosso, "L'attrezzo rimosso dovrebbe essere 'lanterna'");
        assertFalse(borsa.hasAttrezzo("lanterna"), "La borsa non dovrebbe contenere l'attrezzo 'lanterna' dopo la rimozione");

        // Verifica che l'altro attrezzo sia ancora presente
        assertTrue(borsa.hasAttrezzo("osso"), "La borsa dovrebbe contenere ancora 'osso'");
    }

    @Test
    void testIsEmpty() {
        // Verifica che la borsa sia vuota inizialmente
        assertTrue(borsa.isEmpty(), "La borsa dovrebbe essere vuota inizialmente");

        // Aggiungiamo un attrezzo e verifichiamo che la borsa non sia più vuota
        borsa.addAttrezzo(lanterna);
        assertFalse(borsa.isEmpty(), "La borsa non dovrebbe essere vuota dopo aver aggiunto un attrezzo");

        // Rimuoviamo l'attrezzo e verifichiamo che la borsa sia vuota
        borsa.removeAttrezzo("lanterna");
        assertTrue(borsa.isEmpty(), "La borsa dovrebbe essere vuota dopo aver rimosso l'attrezzo");
    }

    @Test
    void testHasAttrezzo() {
        // Verifica che la borsa non contenga l'attrezzo "lanterna" inizialmente
        assertFalse(borsa.hasAttrezzo("lanterna"), "La borsa non dovrebbe contenere 'lanterna' inizialmente");

        // Aggiungiamo l'attrezzo "lanterna"
        borsa.addAttrezzo(lanterna);
        assertTrue(borsa.hasAttrezzo("lanterna"), "La borsa dovrebbe contenere 'lanterna' dopo l'aggiunta");

        
    }

    @Test
    void testToString() {
        // Aggiungiamo un attrezzo alla borsa
        borsa.addAttrezzo(lanterna);

        // Verifica la rappresentazione della borsa
        String expected = "Contenuto borsa (3kg/10kg): lanterna ";
        assertEquals(expected, borsa.toString(), "La rappresentazione della borsa non è corretta");

        // Aggiungiamo un altro attrezzo
        borsa.addAttrezzo(osso);

        // Verifica la rappresentazione aggiornata della borsa
        expected = "Contenuto borsa (4kg/10kg): lanterna osso ";
        assertEquals(expected, borsa.toString(), "La rappresentazione della borsa con due attrezzi non è corretta");
    }

}
