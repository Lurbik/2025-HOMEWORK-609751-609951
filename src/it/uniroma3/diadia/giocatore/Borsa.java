package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.*;

/**
 * Questa classe modella una borsa all'interno del gioco utilizzabile dal giocatore
 *
 * @author  609751 - 609951
 * @see Attrezzo
 * 
 * @version base
 */

public class Borsa {


	    public final static int DEFAULT_PESO_MAX_BORSA = 10;
		private Attrezzo[] attrezzi;
		private int numeroAttrezzi;
		private int pesoMax;
		
		public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	
	}
		
	public Borsa(int pesoMax) {
		
	
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
		return false;
		if (this.numeroAttrezzi==10)
		return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
		if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
		a = attrezzi[i];
		
		return a;
	}
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
		peso += this.attrezzi[i].getPeso();
		
		return peso;
	}
	

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	public Attrezzo removeAttrezzo(String nomeAttrezzo) 
	{
		
		
		for (int i = 0; i < this.numeroAttrezzi; i++) {
            if (this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
                Attrezzo attrezzo = this.attrezzi[i];
                // sposta tutti gli attrezzi successivi indietro
                for (int j = i; j < this.numeroAttrezzi - 1; j++) {
                    this.attrezzi[j] = this.attrezzi[j + 1];
                }
                this.attrezzi[this.numeroAttrezzi - 1] = null; // pulisce l'ultima posizione
                this.numeroAttrezzi--;
                return attrezzo;
            }
        }
        return null; // l'attrezzo non è stato trovato
    }
		
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+ this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++) {
					s.append(attrezzi[i].toString());
					if(i<this.numeroAttrezzi -1) {
						s.append(" ");
					}
				
			}
		
		}
		else
		s.append("Borsa vuota");
		return s.toString();
		}
}

