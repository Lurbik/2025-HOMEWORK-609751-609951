package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.comandi.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.ambienti.*;

public class TestComandoPrendi {
	private Partita p;
	private Comando c;
	private IO i;
	private Attrezzo a;//attrezzo prendibile
	private Attrezzo b;//attrezzo pesante
	private Attrezzo n; //attrezzo null
	
	
	
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
		String[] daLeggere = {
			"prendi osso",       // preso correttamente
			"vai ovest",         // vai in laboratorio
			"prendi chiave",     // troppo pesante (peso 10)
			"prendi mandorla",   // NON presente → nuovo messaggio
			"fine"
		};

		IOSimulator io = Simulatore.creaSimulazionePartitaEGioca(daLeggere);

		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertEquals("attrezzo preso con successo!", io.nextMessaggio());
		assertEquals("Laboratorio Campus", io.nextMessaggio());
		assertEquals("Errore", io.nextMessaggio());
		assertEquals("Attrezzo non presente nella stanza!", io.nextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}



}
