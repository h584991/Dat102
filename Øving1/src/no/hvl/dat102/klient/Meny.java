package no.hvl.dat102.klient;

import no.hvl.dat102.adt.FILMarkivADT;
import no.hvl.dat102.Film;
import java.util.Scanner;
import java.lang.Integer;

public class Meny {
	
	private Scanner s;
	private Tekstgrensesnitt tekstgr;
	private FILMarkivADT filma;
	
	public Meny(FILMarkivADT filma) {
		this.filma = filma;
		tekstgr = new Tekstgrensesnitt();
		s = new Scanner(System.in);
	}
	
	public void start() {
		boolean keepAlive = true;
		System.out.println("Taster du \"valg\" for du opp en liste med lovlige valg du kan gjøre");
		while (keepAlive) {
			System.out.print("\nVelg funksjon: ");
			String str = s.nextLine().toLowerCase();
			switch(str) {
			
			case "add":
				
				Film nyFilm = tekstgr.lesFilm();
				filma.leggTilFilm(nyFilm);
				break;
				
			case "tittel":
				System.out.print("\nSøk etter tittel: ");
				str = s.nextLine();
				tekstgr.skrivutFilmDelstrengITittel(filma, str);
				break;
				
			case "produsent":
				System.out.print("\nSøk etter produsent: ");
				str = s.nextLine();
				tekstgr.skrivutFilmDelstrengIProdusent(filma, str);
				break;
				
			case "slett":
				boolean parseAble = false;
				int filmNr = -1;
				while(!parseAble) {
					System.out.print("\nFilmnr på film som skal slettes: ");
					str = s.nextLine();
					if (tekstgr.checkInt(str)) {
						parseAble = true;
						filmNr = Integer.parseInt(str);
					}
				}
				if (filma.slettFilm(filmNr)) {
					System.out.print("\nFilmen med filmnummer " + filmNr + " er slettet");
				}
				else {
					System.out.print("\nFilmen med filmnummer " + filmNr + " ble ikke funnet.");
				}
				break;
				
			case "stats":
				System.out.println();
				tekstgr.skrivUtStatistikk(filma);
				break;
				
			case "valg":
				System.out.print("\nadd - Gir mulighet for å legge til en film."
						+ "\nslett - Gir mulighet for å slette en film med et bestemt filmnummer."
						+ "\ntittel - Gir mulighet for å søke etter filmer med en tittel som inneholder en bestemt delstreng."
						+ "\nprodusent - Gir mulighet for å søke etter filmer med en produsent som inneholder en bestemt delstreng."
						+ "\nstats - Skriver ut statistikk om antallet filmer i hver sjanger og totalt antall filmer."
						+ "\navslutt - Avslutter menyen og lagrer endringer i arkivfilen.");
				break;
				
			case "avslutt":
				keepAlive = false;
				break;
				
			default:
				System.out.print("\nIkke et lovlig valg. tast \"valg\" for å få en liste over lovlige valg.");
			} //switch
		}//while
		s.close();
	}//metode
	

}//class
