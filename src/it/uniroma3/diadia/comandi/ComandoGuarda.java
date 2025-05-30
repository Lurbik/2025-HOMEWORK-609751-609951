package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando{
	private IO io;
	private final static String NOME = "guarda";
	
	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		this.getIo().mostraMessaggio("Hai ancora: "+partita.getGiocatore().getCfu()+ "CFU");
		this.getIo().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		
	}
/*
	@Override
	public void setParametro(String parametro) {
		

	}

	@Override
	public String getParametro() {
		
		return null;
	}


	@Override
	public void setIo(IO io) {
		this.io = io;
	}
*/
	@Override
	public String getNome() {
		return NOME;
	}
}
