package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.*;

/**
* Questa classe imposta le locazioni delle varie stanze 
* nella partita, si occupa di impostare anche la stanza corrente
* e la stanza vincente e imposta i possibili attrezzi che una stanza 
* può contenere
* 
*
* @author 609751 - 609951
* @see Stanza
* @version versione
*/

public class Labirinto {
	private Stanza StanzaCorrente;
    private Stanza StanzaVincente;


    public Labirinto() {
        this.creaStanze();

    }
    
    private void creaStanze() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo chiave = new Attrezzo("chiave", 10);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new StanzaBloccata("Atrio", "nord","chiave");
		Stanza aulaN11 = new StanzaMagica("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new StanzaBuia("Laboratorio Campus", "lanterna");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		laboratorio.addAttrezzo(chiave);

		// il gioco comincia nell'atrio
        StanzaCorrente = atrio;  
		StanzaVincente = biblioteca;
    }
    
    public Stanza getStanzaVincente() {
		return StanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.StanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.StanzaCorrente;
	}
	
}

