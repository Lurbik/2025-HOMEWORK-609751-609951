	package test;
	import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertTrue;
	
	import org.junit.Test;
	
	import it.uniroma3.diadia.*;
	import it.uniroma3.diadia.comandi.ComandoFine;
	public class TestComandoFine {
		@Test
		public void TestComandoF() {
			String[] righeDaLeggere = {"fine"};
			IOSimulator io = Simulatore.creaSimulazionePartitaEGioca(righeDaLeggere);
			assertTrue(io.hasNextMessaggio());
			assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
			assertTrue(io.hasNextMessaggio());
			assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
		}
	}
