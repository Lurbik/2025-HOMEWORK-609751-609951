package it.uniroma3.diadia;

import java.util.Scanner;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;

//commenti da mettere
public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole io;

	public DiaDia() {
		this.partita = new Partita();
		this.io = new IOConsole();
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
				
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		 Comando comandoDaEseguire = new Comando(istruzione);

	        if (comandoDaEseguire.getNome().equals("fine")) {
	            this.fine();
	            return true;
	        } else if (comandoDaEseguire.getNome().equals("vai"))
	            this.vai(comandoDaEseguire.getParametro());
	        else if (comandoDaEseguire.getNome().equals("aiuto"))
	            this.aiuto();
	        else if (comandoDaEseguire.getNome().equals("prendi"))
	            this.prendi(comandoDaEseguire.getParametro());
	        else if (comandoDaEseguire.getNome().equals("posa"))
	            this.posa(comandoDaEseguire.getParametro());
	        else
	        	io.mostraMessaggio("ERRORE: Comando inserito non corretto!!!");

	        if (this.partita.isFinita()) {
	            if (this.partita.vinta()) {
	            	io.mostraMessaggio("CONGRATULAZIONI, HAI VINTO LA PARTITA!");
	            } else {
	            	io.mostraMessaggio("HAI PERSO! CFU ESAURITI");
	            }
	            return true;
	        }

	        return false;
	    }


	private void aiuto() {
	    StringBuilder messaggioAiuto = new StringBuilder();
	    for (int i = 0; i < elencoComandi.length; i++) {
	        messaggioAiuto.append(elencoComandi[i]).append(" "); // Aggiungi il comando seguito da uno spazio
	    }
	    io.mostraMessaggio(messaggioAiuto.toString()); // Stampa tutti i comandi su una singola riga
	}

	
	private void vai(String direzione) {
		if (direzione == null)
			io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("ERRORE: La direzione che hai inserito non esiste!");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(--cfu);
		}
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
	
	private void prendi(String nomeAttrezzo) {
        Stanza stanza = this.partita.getStanzaCorrente();
        Attrezzo attrezzo = stanza.getAttrezzo(nomeAttrezzo);
        if (attrezzo != null) {
            if (this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
                io.mostraMessaggio("Hai preso l'attrezzo: " + attrezzo.getNome());
                stanza.removeAttrezzo(attrezzo);
            } else {
                // Se la borsa è piena
                //stanza.addAttrezzo(attrezzo); // Rimetti l'attrezzo nella stanza
                io.mostraMessaggio("Non hai abbastanza spazio nella borsa!");
            }
        } else {
            io.mostraMessaggio("L'attrezzo non si trova in questa stanza.");
        }
    }
	
	private void posa(String nomeAttrezzo) {
        Borsa borsa = this.partita.getGiocatore().getBorsa();
        Attrezzo attrezzo = borsa.removeAttrezzo(nomeAttrezzo);
        if (attrezzo != null) {
            this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
            io.mostraMessaggio("Hai posato l'attrezzo: " + attrezzo.getNome());
        } else {
            io.mostraMessaggio("Non hai questo attrezzo nella borsa.");
        }
    }

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}

