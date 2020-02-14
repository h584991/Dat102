package no.hvl.dat102.adt;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;

public interface FILMarkivADT {
	
	
	
	/*
	 * Returnerer en tabell med filmer.
	 */
	Film[] hentFilmTabell();
	
	/*
	 * Legger til en ny film i arkivet.
	 */
	void leggTilFilm(Film nyFilm);
	
	/*
	 * Sletter en film hvis den finnes
	 */
	boolean slettFilm(int filmNr);
	
	/*
	 * Søker og henter filmer med en gitt delstreng.
	 */
	Film[] søkTittel(String delStreng);
	
	/*
	 * Søker og henter produsenter med en gitt delstreng.
	 */
	Film[] søkProdusent(String delStreng);
	
	/*
	 * Returnerer antall filmer innenfor en gitt sjanger.
	 */
	int antallSjanger(Sjanger sjanger);
	
	/*
	 * Returnerer antallet filmer i arkivet.
	 */
	int antall();
	
	

}
