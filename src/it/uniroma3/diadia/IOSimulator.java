package it.uniroma3.diadia;

public class IOSimulator implements IO{
	private String[] righeDaLeggere;
	private int messaggiLetti;
	public String[] getMessaggiProdotti() {
		return messaggiProdotti;
	}
	public void setMessaggiProdotti(String[] messaggiProdotti) {
		this.messaggiProdotti = messaggiProdotti;
	}
	private String[] messaggiProdotti;
	private int indiceMessaggiProdotti;
	private int indiceMessaggiMostrati;
	
	public IOSimulator(String[] righeLette) {
		this.righeDaLeggere = righeLette;
		this.messaggiLetti = 0;
		this.indiceMessaggiMostrati = 0;
		this.messaggiProdotti = new String[10000];
		
		
	}
	@Override
	public void mostraMessaggio(String msg) {
		this.messaggiProdotti[indiceMessaggiProdotti] = msg;
		this.indiceMessaggiProdotti++;
	}

	@Override
	public String leggiRiga() {
		if (messaggiLetti < righeDaLeggere.length) {
			return righeDaLeggere[messaggiLetti];
		}
		return null;
	}
	
	public String nextMessaggio() {
		String next = this.messaggiProdotti[this.indiceMessaggiMostrati];
		this.indiceMessaggiMostrati++;
		return next;
	}

	public boolean hasNextMessaggio() {
		return this.indiceMessaggiMostrati < this.indiceMessaggiProdotti;
	}

}
