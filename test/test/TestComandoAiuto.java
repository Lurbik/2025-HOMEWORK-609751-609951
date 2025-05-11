package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.ComandoAiuto;

public class TestComandoAiuto {

	@Test
	public void testEseguiMostraComandi() {
	    IOSimulator io = new IOSimulator(new String[]{});
	    ComandoAiuto comando = new ComandoAiuto();
	    comando.setIo(io);
	    Partita partita = new Partita();

	    comando.esegui(partita);

	    // Costruiamo una stringa con tutti i messaggi concatenati
	    StringBuilder tuttiIMessaggi = new StringBuilder();
	    while (io.hasNextMessaggio()) {
	        String msg = io.nextMessaggio();
	        if (msg != null) {
	            tuttiIMessaggi.append(msg).append(" ");
	        }
	    }

	    // Verifica che ogni comando sia presente nella stringa complessiva
	    for (String cmd : ComandoAiuto.ELENCO_COMANDI) {
	        assertTrue(tuttiIMessaggi.toString().contains(cmd), "Comando mancante nel messaggio: " + cmd);
	    }
	}

}
