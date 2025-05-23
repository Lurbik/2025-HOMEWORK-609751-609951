package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;

public class ComandoPrendi implements Comando{
	private IO io;
	private String nomeAttrezzo;
	private final static String NOME = "prendi";
	
	@Override
	
	public void esegui(Partita partita) {
		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if (a == null) {
	        io.mostraMessaggio("Attrezzo non presente nella stanza!");
	        return;
	    }
		if(partita.getGiocatore().getBorsa().getPesoRimanenteB(a)) {
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			partita.getStanzaCorrente().removeAttrezzo(a);
			io.mostraMessaggio("attrezzo preso con successo!");
		} 
		else {
			io.mostraMessaggio("Errore");
		}
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo  = parametro;

	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
	
	@Override
	public String getNome() {
		return NOME;
	}


}
