package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

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
    void testPrendereAttrezzo3() {
    	//Verificare che il giocatore non possa prende un attrezzo troppo pesante per la borsa
    	Attrezzo spada = new Attrezzo("spada", 11);
    	
        // Verifica che l'attrezzo non venga inserito nella borsa
        assertFalse(giocatore.prendereAttrezzo(spada), "L'attrezzo 'spada' =^-^=  non dovrebbe essere preso");
       
        // Verifica che la borsa non contenga l'attrezzo
        assertFalse(giocatore.getBorsa().hasAttrezzo("spada"), "La borsa non dovrebbe contenere l'attrezzo 'spada'");
    }
    
    @Test
    void testPrendereAttrezzo2() {
    	//Verificare che più attrezzi vengano presi e aggiunti alla borsa
    	
        // Verifica che gli attrezzi vengano aggiunti alla borsa
        assertTrue(giocatore.prendereAttrezzo(lanterna), "L'attrezzo 'lanterna' dovrebbe essere preso correttamente");
        assertTrue(giocatore.prendereAttrezzo(osso), "L'attrezzo 'osso' =^-^= dovrebbe essere preso correttamente");
        // Verifica che la borsa contenga l'attrezzo
        assertTrue(giocatore.getBorsa().hasAttrezzo("lanterna"), "La borsa dovrebbe contenere l'attrezzo 'lanterna'");
        assertTrue(giocatore.getBorsa().hasAttrezzo("osso"), "La borsa dovrebbe contenere l'attrezzo 'osso'");
    }
    

    @Test
    void testPosareAttrezzo() {
    	//verificare che la funzione posareAttrezzo funzioni per togliere un attrezzo precedentemente aggiunto
    	
        // Aggiungiamo l'attrezzo 'lanterna' alla borsa
        giocatore.prendereAttrezzo(lanterna);
        // Verifica che l'attrezzo venga rimosso correttamente dalla borsa
        Attrezzo attrezzoPosato = giocatore.posareAttrezzo("lanterna");
        assertNotNull(attrezzoPosato, "L'attrezzo 'lanterna' dovrebbe essere posato correttamente");
        assertFalse(giocatore.getBorsa().hasAttrezzo("lanterna"), "La borsa non dovrebbe contenere l'attrezzo 'lanterna' dopo essere stato posato");
    }
    
    @Test
    void testPosareAttrezzo2() {
    	//Verificare che un attrezzo non presente nella borsa non potrà essere posato e che terrà invariata la borsa
    	
        // Aggiungiamo l'attrezzo 'lanterna' alla borsa
        giocatore.prendereAttrezzo(lanterna);
        // Verifica che l'attrezzo non presente non possa essere rimosso
        Attrezzo attrezzoPosato = giocatore.posareAttrezzo("osso");
        assertNull(attrezzoPosato, "L'attrezzo 'osso' non  dovrebbe essere posato non essedoci in partenza");
        assertTrue(giocatore.getBorsa().hasAttrezzo("lanterna"), "La borsa dovrebbe contenere l'attrezzo 'lanterna'=^-^=");
        assertFalse(giocatore.getBorsa().hasAttrezzo("osso"), "La borsa non ha mai avuto l'attrezzo 'osso");
    }
    
    @Test
    void testPosareAttrezzo3() {
    	//Verificare che aggiungendo più attrezzi e posandone uno la borsa non li posa tutti
    	
    	Attrezzo spada = new Attrezzo("spada", 11);
        // Aggiungiamo l'attrezzo 'lanterna' 'osso' e 'spada' alla borsa (spada non verrà aggiunta correttamente)
        giocatore.prendereAttrezzo(lanterna);
        giocatore.prendereAttrezzo(spada);
        giocatore.prendereAttrezzo(osso);
        
        // Verifica che l'attrezzo 'osso' venga rimosso correttamente
        Attrezzo attrezzoPosato = giocatore.posareAttrezzo("osso");
        assertNotNull(attrezzoPosato, "L'attrezzo 'osso' non  dovrebbe essere posato non essedoci in partenza");
       //Verifica che la borsa abbia solo l'oggetto 'lanterna'
        assertTrue(giocatore.getBorsa().hasAttrezzo("lanterna"), "La borsa dovrebbe contenere l'attrezzo 'lanterna'=^-^=");
        assertFalse(giocatore.getBorsa().hasAttrezzo("spada"), "La borsa non dovrebbe contenere l'attrezzo 'spada'");
        assertFalse(giocatore.getBorsa().hasAttrezzo("osso"), "La borsa non dovrebbe contenere l'attrezzo 'osso'");
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
    void testCFU2() {
        // Verifica che i CFU vengano tolti correttamente
    	
    	//verifica che i CFU vengano inizializzati correttamente
        assertEquals(0, giocatore.getCfu(), "I CFU iniziali dovrebbero essere 0");
        // Modifica i CFU
        giocatore.setCfu(10);
        assertEquals(10, giocatore.getCfu(), "I CFU dovrebbero essere impostati correttamente su 10");
        
        //Diminuiamo i cfu a causa di un possibile 'movimento'
        int cfu = giocatore.getCfu();
        giocatore.setCfu(--cfu);
        assertEquals(9, giocatore.getCfu(), "I CFU dovrebbero essere diventati 9");
      }
    
    @Test
    void testCFU3() {
        // Verifica che i CFU  possano essere riaggiunti
    	
    	//Inizializziamo i CFU a 10
        giocatore.setCfu(10);
        
        //Diminuiamo i cfu a causa di un possibile 'movimento'
        int cfu = giocatore.getCfu();
        giocatore.setCfu(++cfu);
        assertEquals(11, giocatore.getCfu(), "I CFU dovrebbero essere diventati 9");
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


}
