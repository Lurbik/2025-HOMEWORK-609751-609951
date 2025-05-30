

package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.ambienti.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.Configuratore;



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
	
	public int getPesoRimanente() {
		return pesoMax-getPeso();
	}
	public boolean getPesoRimanenteB(Attrezzo attrezzo) {
		if(attrezzo != null && this.getPesoMax()-this.getPeso()>=attrezzo.getPeso()) {
			return true;
		}
		return false;
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
		s.append("Borsa vuota");public class Borsa {
			
			public final static int DEFAULT_PESO_MAX_BORSA = Configuratore.getPesoMax();
			//public final static int DEFAULT_PESO_MAX_BORSA = 10;
			private Map<String, Attrezzo> nome2attrezzi;
			private int numeroAttrezzi;
			private int pesoMax;
			private int pesoAttuale;
			
			public Borsa() {
				this(DEFAULT_PESO_MAX_BORSA);
			}
			public Borsa(int pesoMax) {
				this.pesoMax = pesoMax;
				//this.attrezzi = new Attrezzo[10]; // speriamo che bastino...
				this.nome2attrezzi = new TreeMap<>();
				this.numeroAttrezzi = 0;
				this.pesoAttuale = 0;
			}
			public boolean addAttrezzo(Attrezzo attrezzo) {
				if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
					return false;
				this.nome2attrezzi.put(attrezzo.getNome(),attrezzo);
				this.numeroAttrezzi++;
				this.pesoAttuale += attrezzo.getPeso();
				return true;
			}
			
			public int getPesoMax() {
				return pesoMax;
			}

			public Attrezzo getAttrezzo(String nomeAttrezzo) {
				Attrezzo a = null;
				if(nomeAttrezzo != null && this.nome2attrezzi.containsKey(nomeAttrezzo))
					a = this.nome2attrezzi.get(nomeAttrezzo);
				return a;
			}

			public int getPeso() {
				return this.pesoAttuale;
			}

			public boolean getPesoRimanente(Attrezzo a) {
				if(a != null && this.getPesoMax()-this.getPeso()>=a.getPeso())
					return true;
				return false; 
			}

			public boolean isEmpty() {
				return this.numeroAttrezzi == 0;
			}
			public boolean hasAttrezzo(String nomeAttrezzo) {
				return this.getAttrezzo(nomeAttrezzo)!=null;
			}
			public Attrezzo removeAttrezzo(String nomeAttrezzo) {
				Attrezzo a = null;
				if(nomeAttrezzo!=null){
					a = nome2attrezzi.remove(nomeAttrezzo);
				}
				return a;
			}
			public String toString() {
				StringBuilder s = new StringBuilder();
				if (!this.isEmpty()) {
					s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
					s.append("\n");
					s.append(this.getContenutoOrdinatoPerNome().toString());
					s.append("\n");
					s.append(this.getContenutoRaggruppatoPerPeso().toString());
					s.append("\n");
					s.append(this.getSortedSetOrdinatoPerPeso().toString());
				}
				else
					s.append("Borsa vuota");
				return s.toString();
			}

			SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
				SortedSet<Attrezzo> s = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerPeso());
				s.addAll(this.nome2attrezzi.values());
				return s;
			}
//			List<Attrezzo> getContenutoOrdinatoPerPesoCompareTo(){
//				Set<Attrezzo> s = new TreeSet<>();
//				s.addAll(this.nome2attrezzi.values());
//				List<Attrezzo> l = new ArrayList<>();
//				
//				l.addAll(s);
//				return l;
//			}
			
			List<Attrezzo> getContenutoOrdinatoPerPeso(){
				List<Attrezzo> l = new ArrayList<>();
				l.addAll(this.nome2attrezzi.values());
				Collections.sort(l, new ComparatoreAttrezziPerPeso());
				return l;
			}

			SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
				return new TreeSet<Attrezzo>(this.nome2attrezzi.values());
			}

			Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
				Map<Integer, Set<Attrezzo>> a2p = new TreeMap<>();
				//il for e' stato inserito successivamente all'esercizio 2 (nell'esercizio 3)
				for(Attrezzo a : this.nome2attrezzi.values()){
					if(a2p.containsKey(a.getPeso())) {
						a2p.get(a.getPeso()).add(a);
					}
					else {
						Set<Attrezzo>  s =new HashSet<Attrezzo>();
						s.add(a);
						a2p.put(a.getPeso(), s);
					}
				}
				return a2p;
			}

		}
		return s.toString();
		}
}

