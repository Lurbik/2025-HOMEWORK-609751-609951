package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;



public class ComandoVai implements Comando
{

	private String direzione;
	private IO io;
	private final static String NOME = "vai";

	
	@Override
	public void esegui(Partita partita) 
	{
	// qui il codice per cambiare stanza ...
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if(direzione == null) 
		{
			System.out.println("Dove vuoi andare? Devi specificare una direzione");
			return;
			
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		
		if(prossimaStanza == null) {
			System.out.println("Non puoi andare in questa direzione");
			return;
			
		}
		partita.setStanzaCorrente(prossimaStanza);
		System.out.println(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	@Override
	public String getParametro() {
		return this.direzione;
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
