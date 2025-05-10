package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.comandi.*;
import it.uniroma3.diadia.attrezzi.*;

public class TestComandoPrendi {
	private Partita p;
	private Comando c;
	private IO i;
	private Attrezzo a;//attrezzo prendibile
	private Attrezzo b;//attrezzo pesante
	private Attrezzo n; //attrezzo null
	
	@BeforeEach
	public void setup() {
		p = new Partita();
		c = new ComandoPrendi();
		a = new Attrezzo("torcia", 4);
		b = new Attrezzo("obesa", 100);
		n = null;
		i = new IOConsole();
		c.setIo(i);
	}
	
	/*@Test
	public void TestAttrezzoNonPresente() {
		c.setParametro("torcia");
		c.esegui(p);
		assertEquals(io.leggiRiga(), "Attrezzo troppo pesante per entrare nella borsa!");
	}
	
	@Test
	public void TestAttrezzoPresente() {
		p.getStanzaCorrente().addAttrezzo(a);
		c.setParametro("torcia");
		c.esegui(p);
		assertEquals(io.leggiRiga(), "attrezzo preso con successo!");
	}
	
	@Test
	public void TestAttrezzoTroppoPesante() {
	    // Aggiungiamo l'attrezzo "obesa" alla stanza corrente (che è troppo pesante)
	    p.getStanzaCorrente().addAttrezzo(b);

	    // Il giocatore prova a prenderlo
	    c.setParametro("obesa");
	    c.esegui(p);

	    // Verifica che il messaggio di attrezzo troppo pesante venga stampato
	    assertEquals("Attrezzo troppo pesante per entrare nella borsa!", io.leggiRiga());
	}
	
	Da rivedere
	*/
	
	@Test
	public void TestPartitaPrendi() {
		String[] daLeggere = {"prendi osso", "vai ovest", "prendi chiave", "prendi mandorla", "fine"};
	    IOSimulator io = Simulatore.creaSimulazionePartitaEGioca(daLeggere);

	    // Verifica il messaggio di benvenuto
	    assertTrue(io.hasNextMessaggio());
	    assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
	    
	    assertTrue(io.hasNextMessaggio());
	    assertEquals("attrezzo preso con successo!", io.nextMessaggio());
	    
	    assertTrue(io.hasNextMessaggio());
	    assertEquals("Laboratorio Campus", io.nextMessaggio());
	    
	    assertTrue(io.hasNextMessaggio());
	    assertEquals("Attrezzo troppo pesante per entrare nella borsa!", io.nextMessaggio());
	    
	    assertTrue(io.hasNextMessaggio());
	    assertEquals("Attrezzo troppo pesante per entrare nella borsa!", io.nextMessaggio());
	    
	    assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}
}
