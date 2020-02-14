package no.hvl.dat102;

import no.hvl.dat102.adt.FILMarkivADT;

public class Filmarkiv implements FILMarkivADT {
	
	// Objektvariabler
	private int antall;
	private Film[] arkiv;
	
	//konstruktør
	public Filmarkiv(int n) {
		this.arkiv = new Film[n];
		this.antall = 0;
	}
	
	//returnerer hele listen med filmer.
	@Override
	public Film[] hentFilmTabell() {
		return arkiv;
	}
	
	//Legger en ny film til i tabellen.
	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall == arkiv.length) {
			utvidKapasitet();
		}
		arkiv[antall] = nyFilm;
		antall++;
		arkiv = trimTab(arkiv, antall);
	}
	
	//utvider kapasiteten til arkivet.
	private void utvidKapasitet() {
		Film[] hjelpetabell = new Film[(int)Math.ceil(1.1 * arkiv.length)];
		for (int i = 0; i < arkiv.length; i++){
		      hjelpetabell[i] = arkiv[i];
		    }
		arkiv = hjelpetabell;
	}
	
	//hjelpemetode for å sjekke om filmen finnes
	private boolean finnesFilm(int filmNr) {
		boolean finnes = false;
		for (int i = 0; i < antall; i++) {
			if (filmNr == arkiv[i].getFilmNummer()) {
				finnes = true;
			}
		}
		return finnes;
	}
	//metode for å slette film
	@Override
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
	//metode for å søke etter en film basert på tittel, OBS case sensitiv
	@Override
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
	
	//metode for å søke etter ne film basert på produsent. OBS case sensitiv.
	@Override
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
	
	//metode for å finne antall filmer innenfor en sjanger
	@Override
	public int antallSjanger(Sjanger sjanger) {
		int teller = 0;
		for (int i = 0; i < antall; i++) {
			if (arkiv[i].getSjanger() == sjanger) {
				teller++;
			}
		}
		return teller;
	}
	
	//hjelpemetode for å trimme tabellen.
	private Film[] trimTab(Film[] tab, int n) {
		Film[] filmtab2 = new Film[n];
		int i = 0;
		while (i < n) {
		filmtab2[i] = tab[i];
		         i++;
		   }//while
		return filmtab2; }//
	
	//returenerer antallet filmer i arkivet.
	@Override
	public int antall() {
		return antall;
	}
}