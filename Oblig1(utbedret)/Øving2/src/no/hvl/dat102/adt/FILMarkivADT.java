package no.hvl.dat102.adt;

import no.hvl.dat102.nyImplementasjon.Film;
import no.hvl.dat102.nyImplementasjon.Sjanger;
/**
 * Dette er en interface med metoder som kreves av filmarkivet for at resten av filmarkivklienten 
 * skal kunne fungere, uavhengig av hvordan arkivet i seg selv er bygget.
 * 
 * @author jmengevik
 *
 */
public interface FILMarkivADT {
	
	
	
	/**
	 * Skal returnere alle Film objektene i arkivet
	 * @return
	 */
	Film[] hentFilmTabell();
	
	/**
	 * Skal legge til parameteren nyFilm til arkivet
	 * @param nyFilm
	 */
	void leggTilFilm(Film nyFilm);
	
	/**
	 * skal slette filmen i arkivet med filmnummeret angitt av parametere og returnere true om den bel slettet
	 * eller false om det ikke ble slettet noe
	 * @param filmNr
	 * @return
	 */
	boolean slettFilm(int filmNr);
	
	/**
	 * Skal returnere alle Film objekter i arkivet som har en tittel som inneholder delstrengen
	 * angitt som parameter.
	 * @param delStreng
	 * @return
	 */
	Film[] søkTittel(String delStreng);
	
	/**
	 * Skal returnere alle Film objekter i arkivet som har en produsent som inneholder delstrengen
	 * angitt som parameter
	 * @param delStreng
	 * @return
	 */
	Film[] søkProdusent(String delStreng);
	
	/**
	 * Skal returnere antallet filmer i arkivet som har sjengeren spesifisert som parameter.
	 * @param sjanger
	 */
	int antallSjanger(Sjanger sjanger);
	
	/**
	 * Skal returnere antallet filmer i arkivet.
	 * @return
	 */
	int antall();
	
	

}
