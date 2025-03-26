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
        spada = new Attrezzo("spada", 8);
        
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
        
        //Verifica che la borsa piena non raccolga oggetti
        assertFalse(borsa.addAttrezzo(spada), "L'attrezzo 'spada' non dovrebbe essere aggiunto");
        
        //Verifica che l'attrezzo non sia stato aggiunto alla borsa
        assertTrue(borsa.hasAttrezzo("lanterna"), "La borsa dovrebbe contenere 'lanterna'");
        assertTrue(borsa.hasAttrezzo("osso"), "La borsa dovrebbe contenere 'osso'");
        assertFalse(borsa.hasAttrezzo("spada"), "La borsa non dovrebbe contenere 'sapda");
    }
    
    @Test
    void testAddAttrezzo2() {
    	//verifica che l'attrezzo spada venga aggiunto correttamente
    	assertTrue(borsa.addAttrezzo(spada), "L'attrezzo 'spada' dovrebbe essere stato aggiunto correttamente");
    	
    	//Verifica se l'attrezzo 'sapda' sia stato aggiungo correttamente
    	assertTrue(borsa.hasAttrezzo("spada"), "La borsa dovrebbe contenere 'spada");
    	
    	// Aggiungiamo un altro attrezzo che non dovrebbe entrare
        assertFalse(borsa.addAttrezzo(lanterna), "L'attrezzo 'lanterna' non dovrebbe essere aggiunto correttamente");
        
     // Verifica che solo un attrezzo sia presente
        assertTrue(borsa.hasAttrezzo("spada"), "La borsa dovrebbe contenere 'spada'");
        assertFalse(borsa.hasAttrezzo("lanterna"), "La borsa non dovrebbe contenere 'lanterna'");
        
     // Aggiungiamo un altro attrezzo
        assertTrue(borsa.addAttrezzo(osso), "L'attrezzo 'osso' dovrebbe essere aggiunto correttamente");
        
      //Verifica che gli attrezzi 'spada' e 'osso' siano presenti in borsa e invece l'attrezzo 'lanterna' no
        assertFalse(borsa.hasAttrezzo("lanterna"), "La borsa non dovrebbe contenere 'lanterna'");
        assertTrue(borsa.hasAttrezzo("osso"), "La borsa dovrebbe contenere 'osso'");
        assertTrue(borsa.hasAttrezzo("spada"), "La borsa dovrebbe contenere 'sapda");
    	
    }
    
    @Test
    void testAddAttrezzo3() {
    	
    	//creazione di una borsa limitata 
    	Borsa borsaLimitata = new Borsa(2);
    	
    	//creazione di un oggetto più pesante
    	Attrezzo lanternaPesante = new Attrezzo("lanterna", 6);
    	
    	//verifica che la borsa non può raccoglierlo
    	assertFalse(borsaLimitata.addAttrezzo(lanternaPesante), "La  lanterna non dovrebbe essere raccolta");
    	
    	//Verifica che la borsa sia vuota
    	assertTrue(borsaLimitata.isEmpty(), "La borsa dovrebbe essere vuota");
    	
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
       
        //Aggiungiamo un attrezzo troppo pesante
        borsa.addAttrezzo(spada);
        assertEquals(4, borsa.getPeso(), "Il peso della borsa dovrebbe rimanere 4");
    }
    
    @Test
    void testGetPeso2() {
    	//Verificare se la borsa è vuota e restituisca peso 0
    	assertTrue(borsa.isEmpty(), "La borsa dovrebbe restituire che sia vuota");
    	assertEquals(0, borsa.getPeso(), "Il peso della borsa vuota dovrebbe essere 0");
    	
    	//Verificare che con l'aggiunta di un oggetto la borsa non sia più vuota e che restituisca il peso dell'oggetto nella borsa
    	borsa.addAttrezzo(lanterna);
    	assertFalse(borsa.isEmpty(), "La borsa non dovrebbe essere vuota");
    	assertEquals(3, borsa.getPeso(), "la borsa dovrebbe restituire peso 3");
    	
    	//Inserendo un attrezzo troppo pesante per la borsa verificare che il peso rimane invariato a 3
    	borsa.addAttrezzo(spada);
    	assertEquals(3, borsa.getPeso(), "La borsa dovrebbe restituire peso 3");
    }
    
    @Test
    void testGetPeso3() {
    	//Verificare se con una borsa con meno peso massimo aggiungendo più oggetti mi restituisca comunque che sia vuota
    	Borsa borsaLimitata = new Borsa(2);
    	borsaLimitata.addAttrezzo(spada);
    	borsaLimitata.addAttrezzo(lanterna);
    	assertTrue(borsaLimitata.isEmpty(), "La borse dovrebbe essere vuota");
    	assertEquals(0, borsaLimitata.getPeso(), "La borsa dovrebbe avere peso 0");
    	
    	//aggiungiamo un attrezzo che dovrebbe entrare nella borsa e dovrebbe restituire una borsa non vuota e peso 1
    	borsaLimitata.addAttrezzo(lanterna);
    	borsaLimitata.addAttrezzo(osso);
    	borsaLimitata.addAttrezzo(spada);
    	assertFalse(borsaLimitata.isEmpty(), "La borse non dovrebbe essere vuota");
    	assertEquals(1, borsaLimitata.getPeso(), "La borsa dovrebbe avere peso 1");
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
    void TestRemoveAttrezzo2() {
    	//vediamo se aggiungendo 1 solo oggetto e provando ad eliminarne uno non presente la borsa rimanga invariata
    	
    	//Aggiungiamo lanterna
    	borsa.addAttrezzo(lanterna);
    	
    	//Rimuoviamo un attrezzo non presente nella borsa
    	Attrezzo attrezzoRimosso = borsa.removeAttrezzo("osso");
    	assertEquals(null, attrezzoRimosso, "Non dovrebbe essere stato rimosso nessun attrezo");
    	assertTrue(borsa.hasAttrezzo("lanterna"), "La borsa dovrebbe ancora avere l'attrezzo lanterna");
    	assertFalse(borsa.hasAttrezzo("osso"), "La borsa non dovrebbe avere 'osso' non avendolo mai toccato");
    }
    
    @Test
    void TestRemoveAttrezzo3() {
    	//Aggiungendo attrezzi i quali sono troppo grandi per la borsa allora rimuovendoli dovrebbe rimuovere null
    	
    	//creazione di una borsa con poca capienza
    	Borsa borsaLimitata = new Borsa(2);
    	
    	//aggiungiamo attrezzi troppo grandi
    	borsaLimitata.addAttrezzo(lanterna);
    	borsaLimitata.addAttrezzo(spada);
    	
    	//Rimozione degli oggetti dalla borsa che dovrebbe già essere vuota
    	Attrezzo attrezzoRimosso1 = borsaLimitata.removeAttrezzo("lanterna");
    	Attrezzo attrezzoRimosso2 = borsaLimitata.removeAttrezzo("spadda");
    	assertNull(attrezzoRimosso1, "Non dovrebbe essere stato rimosso alcun elemento");
    	assertNull(attrezzoRimosso2, "Non dovrebbe essere stato rimosso alcun elemento");
    	
    	//La borsa dovrebbe essere vuota siccome non sono mai stati aggiunti elemnti e nel caso sono stati rimossi
    	assertTrue(borsaLimitata.isEmpty(), "La borsa dovrebbe essere vuota");
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
    void testIsEmpty2() {
    	//Verificare che la borsa sia vuota con l'aggiunta di un oggetto troppo pesante
    	Attrezzo lanternaPesante = new Attrezzo("lanterna", 12);
    	
    	//verifica iniziale che la borsa sia vuota
    	assertTrue(borsa.isEmpty(), "La borsa dovrebbe essere vuota");
    	
    	//Inserire un oggetto troppo pesante e verificare che la borsa rimanga vuota
    	borsa.addAttrezzo(lanternaPesante);
    	assertTrue(borsa.isEmpty(), "La borsa dovrebbe essere vuota");

    	
    }
    
    @Test
    void testIsEmpty3() {
    	//Verificare che la borsa non sia vuota dopo che aggiungiamo un oggetto alla borsa e ne rimuoviamo un altro non presente
    	
    	//aggiunta di 1 oggetto e rimozione di un altro diverso
    	borsa.addAttrezzo(lanterna);
    	borsa.removeAttrezzo("osso");
    	
    	//verifica che la borsa non sia vuota
    	assertFalse(borsa.isEmpty(), "La borsa non dovrebbe essere vuota");
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
    void testHasAttrezzo2() {
    	//Verificare che la borsa non abbia un attrezzo che non può contenere 
    	Attrezzo lanternaPesante = new Attrezzo("lanterna", 11);
    	borsa.addAttrezzo(lanternaPesante);
    	
    	//verificare che 'lanternaPesante' non sia presente in borsa
    	assertFalse(borsa.hasAttrezzo("lanterna"), "L'attrezzo 'lanterna' non dovrebbe essere presente");
    }
    
    @Test
    void testHasAttrezzo3() {
    	//Verificare che con l'aggiunta di 1 attrezzo la borsa non contenga un altro attrezzo e che eliminandolo non lo abbia più
    	
    	//Verifica che un altro oggetto diverso da quello aggiunto non sia presente nella borsa
    	borsa.addAttrezzo(lanterna);
    	assertFalse(borsa.hasAttrezzo("osso"), "Non dovrebbe essere presente 'osso' nella borsa");
   
    	//Assicuriamoci che lanterna sia presente nella borsa e verificare se dopo la rimozione non sia più presente
    	assertTrue(borsa.hasAttrezzo("lanterna"), "L'attrezzo 'lanterna' dovrebbe essere presente nella borsa");
    	borsa.removeAttrezzo("lanterna");
    	assertFalse(borsa.hasAttrezzo("lanterna"), "Non dovrebbe essere  più presente nella borsa");
    	
    }

    @Test
    void testToString() {
        // Aggiungiamo un attrezzo alla borsa
        borsa.addAttrezzo(lanterna);

        // Verifica la rappresentazione della borsa
        String expected = "Contenuto borsa (3kg/10kg): lanterna (3kg)";
        assertEquals(expected, borsa.toString(), "La rappresentazione della borsa non è corretta");

        // Aggiungiamo un altro attrezzo
        borsa.addAttrezzo(osso);

        // Verifica la rappresentazione aggiornata della borsa
        expected = "Contenuto borsa (4kg/10kg): lanterna (3kg) osso (1kg)";
        assertEquals(expected, borsa.toString(), "La rappresentazione della borsa con due attrezzi non è corretta");
    }
    
    @Test
    void testToString2() {
        // Aggiungiamo 3 attrezzi alla borsa di cui 1 non sarà inserito per la poca capacità della borsa
        borsa.addAttrezzo(spada);
        borsa.addAttrezzo(osso);
        borsa.addAttrezzo(lanterna);

        // Verifica la rappresentazione della borsa
        String expected = "Contenuto borsa (9kg/10kg): spada (8kg) osso (1kg)";
        assertEquals(expected, borsa.toString(), "La rappresentazione della borsa non è corretta");

    }
    
    @Test
    void testToString3() {
    	//Verificare che all'aggiunta di un oggetto troppo pesante la borsa sia vuota
    	
        // Aggiungiamo un attrezzo troppo pesante alla borsa
    	Attrezzo lanternaPesante = new Attrezzo("lanterna",11);
        borsa.addAttrezzo(lanternaPesante);

        // Verifica la rappresentazione della borsa
        String expected = "Borsa vuota";
        assertEquals(expected, borsa.toString(), "La rappresentazione della borsa dovrebbe essere corretta");

    }

}
