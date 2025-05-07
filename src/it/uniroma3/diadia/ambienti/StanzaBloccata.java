package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	private String direzione;
	private String Lasciapassare;
	public StanzaBloccata(String nome, String direzione, String Lasciapassare) {
		super(nome);
		this.Lasciapassare = Lasciapassare;
		this.direzione = direzione;
		
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(!this.hasAttrezzo(Lasciapassare)) {
			if (direzione.equals("nord"))  {
				System.out.println("La porta è chiusa.");
				return null;
			}
		}
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		String bloccato = new String();
		bloccato = "A nord ci sta una serratura. Servirà una chiave?";
		if(!this.hasAttrezzo(Lasciapassare)) {
			return super.getDescrizione() +"\n" +bloccato;
		}
		return super.getDescrizione();
	}
}