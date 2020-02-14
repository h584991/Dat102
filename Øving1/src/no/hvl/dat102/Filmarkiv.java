package no.hvl.dat102;

import no.hvl.dat102.adt.FILMarkivADT;

public class Filmarkiv implements FILMarkivADT {
	
	private int antall;
	
	private Film[] arkiv;
	
	public Filmarkiv(int n) {
		this.arkiv = new Film[n];
		this.antall = 0;
	}
	
	public Film[] hentFilmTabell() {
		return arkiv;
	}
	
	public void leggTilFilm(Film nyFilm) {
		if (antall == arkiv.length) {
			utvidKapasitet();
		}
		arkiv[antall] = nyFilm;
		antall++;
	}
	
	private void utvidKapasitet() {
		Film[] hjelpetabell = new Film[(int)Math.ceil(1.1 * arkiv.length)];
		for (int i = 0; i < arkiv.length; i++){
		      hjelpetabell[i] = arkiv[i];
		    }
		arkiv = hjelpetabell;
	}
	
	private boolean finnesFilm(int filmNr) {
		boolean finnes = false;
		for (int i = 0; i < antall; i++) {
			if (filmNr == arkiv[i].getFilmNummer()) {
				finnes = true;
			}
		}
		return finnes;
	}
	
	public boolean slettFilm(int filmNr) {
		boolean slettet = false;
		if (finnesFilm(filmNr)) {
			Film[] hjelpetabell = new Film[antall];
			int hjelpeteller = 0;
			for (int i = 0; i < antall; i++) {
				if (filmNr != arkiv[i].getFilmNummer()) {
					hjelpetabell[hjelpeteller] = arkiv[i];
					hjelpeteller++;
				}
			}
			arkiv = hjelpetabell;
			antall--;
			slettet = true;
		}
		return slettet;
		
	}
	
	public Film[] søkTittel(String delstreng) {
		Film[] tab = new Film[antall];
		int teller = 0;
		for (int i = 0; i < antall; i++) {
			if (arkiv[i].getTittel().contains(delstreng)) {
				tab[teller] = arkiv[i];
				teller++;
			}
		}
		Film[] returTab = new Film[teller];
		for (int i = 0; i < teller; i++) {
			returTab[i] = tab[i];
		}
		return returTab;
	}
	
	public Film[] søkProdusent(String delstreng) {
		Film[] tab = new Film[antall];
		int teller = 0;
		for (int i = 0; i < antall; i++) {
			if (arkiv[i].getProdusent().contains(delstreng)) {
				tab[teller] = arkiv[i];
				teller++;
			}
		}
		Film[] returTab = new Film[teller];
		for (int i = 0; i < teller; i++) {
			returTab[i] = tab[i];
		}
		return returTab;
	}
	
	public int antallSjanger(Sjanger sjanger) {
		int teller = 0;
		for (int i = 0; i < antall; i++) {
			if (arkiv[i].getSjanger() == sjanger) {
				teller++;
			}
		}
		return teller;
	}
	
	public int antall() {
		return antall;
	}
}