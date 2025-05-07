package it.uniroma3.diadia;

public class IOSimulator implements IO{
	private String[] righeDaLeggere;
	private String[] messaggiScritti;
	private int messaggiLetti;
	
	public IOSimulator(String[] righeLette) {
		this.righeDaLeggere = righeLette;
		this.messaggiLetti = 0;
		this.messaggiScritti = new String[10000];
		
		
	}
	@Override
	public void mostraMessaggio(String msg) {
		if (messaggiLetti < messaggiScritti.length) {
			messaggiScritti[messaggiLetti++] = msg;
		}
	}

	@Override
	public String leggiRiga() {
		if (messaggiLetti < righeDaLeggere.length) {
			return righeDaLeggere[messaggiLetti];
		}
		return null;
	}
}
