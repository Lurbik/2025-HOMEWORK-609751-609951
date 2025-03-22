package it.uniroma3.diadia;




/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;



public class Partita {

	static final private int CFU_INIZIALI = 20;

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
	private Giocatore giocatore;
	private Labirinto labirinto;
	
	 public Partita() {
	        this.labirinto = new Labirinto();
	        this.stanzaCorrente = labirinto.getStanzaCorrente();
	        this.stanzaVincente = labirinto.getStanzaVincente();
	        this.finita = false;
	        this.giocatore = new Giocatore(); // inizializza Giocatore
	        this.giocatore.setCfu(CFU_INIZIALI); // setta i CFU in Giocatore
	}

   

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public Giocatore getGiocatore() {
        return this.giocatore;  // Aggiungi il getter per il Giocatore
    }
	
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	 public int getCfu() {
	        return this.giocatore.getCfu(); // Restituisce i CFU dal Giocatore
	    }

	    public void setCfu(int cfu) {
	        this.giocatore.setCfu(cfu); // Imposta i CFU nel Giocatore
	    }
}

/*pablo*/