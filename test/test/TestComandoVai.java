package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.comandi.*;

public class TestComandoVai {
	private Stanza a1;
	private Stanza a2;
	private Comando vai;
	private Partita p;
	
	
	@BeforeEach
	public void setup() {
		a1 = new Stanza("prima");
		a2 = new Stanza("seconda");
		vai = new ComandoVai();
		p = new Partita();
		vai.setIo(new IOConsole());
	}
	@Test
	public void Nientedirezioni() {
		p.setStanzaCorrente(a1);
		vai.esegui(p);
		assertEquals(a1, p.getStanzaCorrente());
	}
	@Test
	public void DirezioneNord() {
		p.setStanzaCorrente(a1);
		a1.impostaStanzaAdiacente("nord", a2);
		vai.setParametro("nord");
		vai.esegui(p);
		assertEquals(a2,p.getStanzaCorrente());
		
	}
	@Test
	public void DirezioneNonEsistente() {
		p.setStanzaCorrente(a1);
		a1.impostaStanzaAdiacente("nord", a2);
		vai.setParametro("sud");
		vai.esegui(p);
		assertNotEquals(a2, p.getStanzaCorrente());
	}
	
	@Test
	public void TestPartitaVai() {        
	    String[] daLeggere = {"vai ovest", "prendi chiave", "vai est", "posa chiave", "vai nord", "fine"};
	    IOSimulator io = Simulatore.creaSimulazionePartitaEGioca(daLeggere);

	    // Verifica il messaggio di benvenuto
	    assertTrue(io.hasNextMessaggio());
	    assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
	    
	    
	    // Verifica che si inizi nella stanza "Laboratorio Campus"
	    assertTrue(io.hasNextMessaggio());
	    assertEquals("Laboratorio Campus", io.nextMessaggio());
	    
	    // Verifica che l'attrezzo (la chiave) venga preso correttamente
	    assertTrue(io.hasNextMessaggio());
	    assertEquals("Hai preso l'attrezzo: chiave", io.nextMessaggio());
	    
	    // Verifica che il giocatore si sposti nella stanza successiva (Atrio)
	    assertTrue(io.hasNextMessaggio());
	    assertEquals("Atrio", io.nextMessaggio());
	    
	    // Verifica che l'attrezzo venga posato
	    assertTrue(io.hasNextMessaggio());
	    assertEquals("Hai posato l'attrezzo: chiave", io.nextMessaggio());
	    
	    // Verifica che il giocatore arrivi finalmente alla Biblioteca
	    assertTrue(io.hasNextMessaggio());
	    assertEquals("Biblioteca", io.nextMessaggio());
	    
	    // Verifica il messaggio di vincita
	    assertTrue(io.hasNextMessaggio());
	    assertEquals("Hai vinto!", io.nextMessaggio());
	}

}
