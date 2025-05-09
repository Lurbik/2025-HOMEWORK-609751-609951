package test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaBuia{
	private StanzaBuia stanzaBuia;
	private  Attrezzo lanterna;
	
	@BeforeEach
	void setup() {
		stanzaBuia = new StanzaBuia("laboratorio", "lanterna");
		lanterna = new Attrezzo("lanterna", 4);
		
	}
	
	@Test
	public void TestDescrizioneConLanterna() {
		stanzaBuia.addAttrezzo(lanterna);
		assertEquals(stanzaBuia.toString(), stanzaBuia.getDescrizione());
	}
	@Test
	public void TestDescrizioneSenzaLanterna() {
		assertEquals("Qui c'è un buio pesto!", stanzaBuia.getDescrizione());
	}
}
