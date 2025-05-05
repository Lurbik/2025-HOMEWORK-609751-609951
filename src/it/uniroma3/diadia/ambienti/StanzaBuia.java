package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.*;

public class StanzaBuia extends Stanza{

	private String AttrezzoLuminoso;
	
	public StanzaBuia(String nome, String AttrezzoLuminoso) 
	{
		super(nome);
		this.AttrezzoLuminoso = AttrezzoLuminoso;
	}
	
	@Override
	public String getDescrizione() {
		String buio = new String();
		buio = "Qui c'è un buio pesto!";
		if(!this.hasAttrezzo(AttrezzoLuminoso)) {
			return buio;
		}
		return super.getDescrizione();
	}
}
