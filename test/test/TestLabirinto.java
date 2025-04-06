package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
class TestLabirinto {

	private Labirinto labirinto;
    private Stanza atrio;
    private Stanza aulaN11;
    private Stanza aulaN10;
    private Stanza laboratorio;
    private Stanza biblioteca;

    @BeforeEach
    void setUp() {
        // Inizializziamo il labirinto e otteniamo le stanze per ogni test
        labirinto = new Labirinto();
        atrio = labirinto.getStanzaCorrente();
        aulaN11 = new Stanza("Aula N11");
        aulaN10 = new Stanza("Aula N10");
        laboratorio = new Stanza("Laboratorio Campus");
        biblioteca = labirinto.getStanzaVincente();
    }

    @Test
    void testStanzaIniziale() {
    	//Verifica che la stanza iniziale sia Atrio
        assertNotNull(atrio, "La stanza corrente non dovrebbe essere null");
        assertEquals("Atrio", atrio.getNome(), "La stanza corrente dovrebbe essere l'atrio");
    }
    
    @Test
    void testStanzaCorrenteNonNull() {
    	//Verifica che la stanza corrente non sia nulla quando il labirinto viene creato
        assertNotNull(labirinto.getStanzaCorrente(), "La stanza corrente non dovrebbe essere null");
    }
    
    @Test
    void testStanzaInizialeAtrio() {
    	//Verifica che la stanza corrente sia effettivamente l'atrio all'inizio
        assertEquals("Atrio", labirinto.getStanzaCorrente().getNome(), "La stanza iniziale deve essere Atrio");
    }


    @Test
    void testStanzaVincente() {
        // Verifica che la stanza vincente sia correttamente la biblioteca
        assertNotNull(biblioteca, "La stanza vincente non dovrebbe essere null");
        assertEquals("Biblioteca", biblioteca.getNome(), "La stanza vincente dovrebbe essere la biblioteca");
    }
    
    @Test
    void testStanzaVincenteDifferente() {
    	//Verifica che la stanza vincente sia diversa dalla stanza corrente
        assertNotEquals(labirinto.getStanzaCorrente().getNome(), biblioteca.getNome(), 
                        "La stanza vincente dovrebbe essere diversa dalla stanza corrente");
    }
    
    @Test
    void testStanzaVincenteNelLabirinto() {
    	//Verifica che la stanza vincente sia quella impostata nel labirinto
        assertEquals(labirinto.getStanzaVincente().getNome(), "Biblioteca", 
                     "La stanza vincente deve essere correttamente impostata come Biblioteca");
    }


    @Test
    void testCollegamentiStanze() {
        // Verifica che le stanze siano correttamente collegate tra loro
        Stanza atrio = labirinto.getStanzaCorrente();

        Stanza adiacenteNord = atrio.getStanzaAdiacente("nord");
        assertNotNull(adiacenteNord, "La stanza adiacente a nord non dovrebbe essere null");
        assertEquals("Biblioteca", adiacenteNord.getNome(), "La stanza adiacente a nord dovrebbe essere la biblioteca");

        Stanza adiacenteEst = atrio.getStanzaAdiacente("est");
        assertNotNull(adiacenteEst, "La stanza adiacente a est non dovrebbe essere null");
        assertEquals("Aula N11", adiacenteEst.getNome(), "La stanza adiacente a est dovrebbe essere l'Aula N11");

        Stanza adiacenteSud = atrio.getStanzaAdiacente("sud");
        assertNotNull(adiacenteSud, "La stanza adiacente a sud non dovrebbe essere null");
        assertEquals("Aula N10", adiacenteSud.getNome(), "La stanza adiacente a sud dovrebbe essere l'Aula N10");

        Stanza adiacenteOvest = atrio.getStanzaAdiacente("ovest");
        assertNotNull(adiacenteOvest, "La stanza adiacente a ovest non dovrebbe essere null");
        assertEquals("Laboratorio Campus", adiacenteOvest.getNome(), "La stanza adiacente a ovest dovrebbe essere il Laboratorio Campus");
    }

    @Test
    void testNavigazioneStanzaCorrenteBiblioteca() {
        // Cambiamo la stanza corrente a "Biblioteca"
        labirinto.setStanzaCorrente(biblioteca);
        assertEquals(biblioteca, labirinto.getStanzaCorrente(), "La stanza corrente dovrebbe essere la biblioteca");
    }
    
    @Test
    void testCambioStanzaCorrenteDaAtrio() {
    	//Verifica che la stanza corrente non sia più l'atrio dopo il cambio
        labirinto.setStanzaCorrente(biblioteca);
        assertNotEquals(atrio, labirinto.getStanzaCorrente(), "La stanza corrente non dovrebbe essere l'atrio");
    }

    @Test
    void testNavigazioneStanza() {
    	//Verifica che il cambio della stanza corrente aggiorni il riferimento alla stanza corrente
        labirinto.setStanzaCorrente(biblioteca);
        Stanza nuovaStanza = labirinto.getStanzaCorrente();
        assertNotNull(nuovaStanza, "La stanza corrente dopo il cambio dovrebbe essere diversa da null");
        assertEquals("Biblioteca", nuovaStanza.getNome(), "La stanza corrente dopo il cambio dovrebbe essere la biblioteca");
    }


}
