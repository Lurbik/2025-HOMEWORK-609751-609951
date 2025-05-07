package test;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class TestStanzaBloccata {
	private StanzaBloccata stanzabloccata;
	private Stanza stanzanord;
	private Attrezzo chiave;
	
	@BeforeEach
	void setup() {
		stanzabloccata = new StanzaBloccata("atrio", "nord", "chiave");
		stanzanord = new Stanza("Biblioteca");
		chiave = new Attrezzo("chiave", 10);
		stanzabloccata.impostaStanzaAdiacente("nord", stanzanord);
	}
	
	@Test
	public void TestBloccataSenzaChiave() {
		assertNull(stanzabloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void TestBloccataConChiave() {
		stanzabloccata.addAttrezzo(chiave);
		assertEquals(stanzanord, stanzabloccata.getStanzaAdiacente("nord"));
		
	}
	
	@Test
	public void TestBloccataDescrizioneBloccata() {
		String a = "A nord ci sta una serratura. Servirà una chiave?";
		assertTrue(stanzabloccata.getDescrizione().contains(a));
		
	}
	@Test
	public void TestBloccataDescrizioneConChiave(){
		stanzabloccata.addAttrezzo(chiave);
		String a = "A nord ci sta una serratura. Servirà una chiave?";
		assertFalse(stanzabloccata.getDescrizione().contains(a));
	}
}

	
