package no.hvl.dat102.nyImplementasjon;

import no.hvl.dat102.adt.FILMarkivADT;

public class Filmarkiv2 implements FILMarkivADT {
	
	private int antall;
	private LinearNode<Film> start;
	
	public Filmarkiv2() {
		this.antall = 0;
		this.start = null;
	}
	
	public Film[] hentFilmTabell() {
		LinearNode<Film> current = start;
		Film[] tab = new Film[antall];
		for (int i = 0; i < antall; i++) {
			tab[i] = current.getElement();
			current = current.getNeste();
		}
		return tab;
	}
	
	public void leggTilFilm(Film film) {
		LinearNode<Film> siste = start;
		LinearNode<Film> nyNode = new LinearNode<Film>(film);
		if (start == null) {
			start = nyNode;
			antall++;
		}
		else {
			while(siste.getNeste() != null) {
				siste = siste.getNeste();
			}
			siste.setNeste(nyNode);
			antall++;
		}
		
	}
	
	public boolean slettFilm(int filmNr) {
		boolean slettet = false;
		LinearNode<Film> forrige = start;
		LinearNode<Film> current = start.getNeste();
		if (current == null && start.getElement().getFilmNummer() == filmNr) {
			start = null;
			antall--;
			slettet = true;
		}
		else if (start.getElement().getFilmNummer() == filmNr) {
			this.start = current;
			antall--;
			slettet = true;
		}
		else {
			while(current != null) {
				if (current.getElement().getFilmNummer() == filmNr) {
					forrige.setNeste(current.getNeste());
					antall--;
					slettet = true;
				}
				forrige = current;
				current = current.getNeste();
			}
		}
		return slettet;
	}
	
	public Film[] søkTittel(String delStreng) {
		LinearNode<Film> current = start;
		Film[] tab = new Film[antall];
		int teller = 0;
		while(current != null) {
			if (current.getElement().getTittel().contains(delStreng)) {
				tab[teller] = current.getElement();
				teller++;
			}
			current = current.getNeste();
		}
		Film[] returTab = new Film[teller];
		for (int i = 0; i < teller; i++) {
			returTab[i] = tab[i];
		}
		return returTab;
	}
	
	public Film[] søkProdusent(String delStreng) {
		LinearNode<Film> current = start;
		Film[] tab = new Film[antall];
		int teller = 0;
		while(current != null) {
			if (current.getElement().getProdusent().contains(delStreng)) {
				tab[teller] = current.getElement();
				teller++;
			}
			current = current.getNeste();
		}
		Film[] returTab = new Film[teller];
		for (int i = 0; i < teller; i++) {
			returTab[i] = tab[i];
		}
		return returTab;
	}
	
	public int antallSjanger(Sjanger sjang) {
		LinearNode<Film> current = start;
		int teller = 0;
		while (current != null) {
			if(current.getElement().getSjanger() == sjang) {
				teller++;
			}
			current = current.getNeste();
		}
		return teller;
	}
	
	public int antall() {
		return antall;
	}

}
