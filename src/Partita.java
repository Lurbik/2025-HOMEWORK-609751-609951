
/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	static final private int CFU_INIZIALI = 20;


    private Stanza stanzaCorrente;
    private boolean finita;
    private Giocatore giocatore;
    private Labirinto labirinto; // riferimento al labirinto
	
    public Partita() {
        this.labirinto = new Labirinto();
        this.stanzaCorrente = labirinto.getStanzaCorrente();
        this.finita = false;
        this.giocatore = new Giocatore(); // inizializza Giocatore
        this.giocatore.setCfu(CFU_INIZIALI); // setta i CFU in Giocatore
    }

	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
    public Stanza getStanzaCorrente() {
        return this.stanzaCorrente;
    }

    public void setStanzaCorrente(Stanza stanzaCorrente) {
        this.stanzaCorrente = stanzaCorrente;
    }

    public boolean vinta() {
        return this.getStanzaCorrente().equals(this.labirinto.getStanzaVincente());
    }

    public boolean isFinita() {
        return finita || vinta() || (this.giocatore.getCfu() == 0); // get CFU dal Giocatore
    }

    public void setFinita() {
        this.finita = true;
    }

    public Giocatore getGiocatore() {
        return this.giocatore; // getter di Giocatore
    }

	public void setCfu(int cfu) {
		this.giocatore.setCfu(cfu);		
	}
	public int getCfu() {
		return this.giocatore.getCfu();
	}
	public Labirinto getLabirinto() {
        return this.labirinto;
    }
}
