package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.Partita;

/**
* Questa classe genera un giocatore all'interno della partita,
* il giocatore è responsabile della gestione dei CFU e degli attrezzi
* mediante una borsa.
*
* @author 609751 - 609951
* @see Borsa
* @version base
*/
public class Giocatore {
    private int cfu;
    private Borsa borsa;

    public Giocatore() {
        this.borsa = new Borsa(); // inizializza Borsa per il giocatore
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public Borsa getBorsa() {
        return borsa;
    }

    public void setBorsa(Borsa borsa) {
        this.borsa = borsa;
    }

    public boolean prendereAttrezzo(Attrezzo attrezzo) {
        return this.borsa.addAttrezzo(attrezzo);
    }

    public Attrezzo posareAttrezzo(String nomeAttrezzo) {
        return this.borsa.removeAttrezzo(nomeAttrezzo);
    }

}

