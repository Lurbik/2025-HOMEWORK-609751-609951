
/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	static final private int CFU_INIZIALI = 2;


    private Stanza stanzaCorrente;
    private boolean finita;
    private int cfu;
    private Labirinto labirinto; // riferimento al labirinto
	
    public Partita(){
        this.labirinto = new Labirinto(); // inizializza il labirinto
        this.stanzaCorrente = labirinto.getStanzaCorrente(); // stanza iniziale dal labirinto
        this.finita = false;
        this.cfu = CFU_INIZIALI;
    }

    public Stanza getStanzaVincente() {
        return labirinto.getStanzaVincente();
    }

    public void setStanzaCorrente(Stanza stanzaCorrente) {
        this.stanzaCorrente = stanzaCorrente;
    }

    public Stanza getStanzaCorrente() {
        return this.stanzaCorrente;
    }
    
    public boolean vinta() {
        return this.getStanzaCorrente() == labirinto.getStanzaVincente();
    }

    public boolean isFinita() {
        return finita || vinta() || (cfu == 0);
    }

    public void setFinita() {
        this.finita = true;
    }

    public int getCfu() {
        return this.cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;        
    }

    public Labirinto getLabirinto() {
        return this.labirinto;
    }
}
