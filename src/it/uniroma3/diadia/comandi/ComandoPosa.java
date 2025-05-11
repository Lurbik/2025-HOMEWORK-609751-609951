package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	private IO io;
	private String NomeAttrezzo;
	private final static String NOME = "posa";
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(NomeAttrezzo);
		if (a == null) {
		    io.mostraMessaggio("Attrezzo non presente nella borsa!");
		    return;
		}
		if(partita.getStanzaCorrente().getNumeroAttrezziPossibili()>0) {
			partita.getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(NomeAttrezzo);
			io.mostraMessaggio("attrezzo posato con successo!");
		}
		else {
			io.mostraMessaggio("Errore");
		}
		}
	
	@Override
	public void setParametro(String parametro) {
		this.NomeAttrezzo  = parametro;

	}

	@Override
	public String getParametro() {
		return this.NomeAttrezzo;
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
