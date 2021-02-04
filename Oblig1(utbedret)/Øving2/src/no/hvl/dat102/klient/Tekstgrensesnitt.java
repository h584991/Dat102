package no.hvl.dat102.klient;

import java.util.Scanner;
import no.hvl.dat102.adt.FILMarkivADT;
import no.hvl.dat102.nyImplementasjon.Film;
import java.lang.Integer;
import no.hvl.dat102.nyImplementasjon.Sjanger;


public class Tekstgrensesnitt {
	
	Scanner s = new Scanner(System.in);
	
	
	public boolean checkInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}
	
	public Film lesFilm() {
		
		int filmNummer = 0;
		String produsentNavn;
		String tittel;
		int lanseringsår = 0;
		Sjanger sjanger;
		String filmselskap;
		
		
		boolean parseAble = false;
		while (!parseAble) {
			System.out.print("Filmnummer: ");
			String str = s.nextLine();
			if(checkInt(str)) {
				parseAble = true;
				filmNummer = Integer.parseInt(str);
			}
		}
		System.out.print("Produsentnavn: ");
		produsentNavn = s.nextLine();
		System.out.print("Tittel: ");
		tittel = s.nextLine();
		parseAble = false;
		while (!parseAble) {
			System.out.print("Lanseringsår: ");
			String str = s.nextLine();
			if(checkInt(str)) {
				parseAble = true;
				lanseringsår = Integer.parseInt(str);
			}
		}
		System.out.print("Sjanger (Action, Drama, History eller Scifi): ");
		Sjanger sjang = null;
		while ( sjang == null) {
			System.out.print("Sjanger (Action, Drama, History eller Scifi): ");
			String str = s.nextLine();
			sjang = Sjanger.finnSjanger(str);
		}
		sjanger = sjang;
		System.out.print("Filmselskap: ");
		filmselskap = s.nextLine();
		
		Film film = new Film(filmNummer, produsentNavn, tittel, lanseringsår, sjanger, filmselskap);
		return film;
		
		
	}
	
	public void visFilm(Film film) {
		System.out.println();
		System.out.println("Filmnummer: "  + film.getFilmNummer());
		System.out.println("Produsentnavn: "  + film.getProdusent());
		System.out.println("Tittel: "  + film.getTittel());
		System.out.println("Lanseringsår: "  + film.getLanseringsår());
		System.out.println("Sjanger: "  + film.getSjanger().toString());
		System.out.println("Filmselskap: "  + film.getFilmselskap());
		System.out.println();
	}
	
	public void skrivutFilmDelstrengITittel(FILMarkivADT filmarkiv, String delstreng) {
		System.out.println("*****************************");
		for (Film f : filmarkiv.søkTittel(delstreng)) {
			visFilm(f);
		}
		System.out.println("*****************************");
	}
	
	public void skrivutFilmDelstrengIProdusent(FILMarkivADT filmarkiv, String delstreng) {
		System.out.println("*****************************");
		for (Film f : filmarkiv.søkProdusent(delstreng)) {
			visFilm(f);
		}
		System.out.println("*****************************");
	}
	
	public void skrivUtStatistikk(FILMarkivADT filmarkiv) {
		System.out.println();
		System.out.println("Antall Action: " + filmarkiv.antallSjanger(Sjanger.ACTION));
		System.out.println("Antall Drama: " + filmarkiv.antallSjanger(Sjanger.DRAMA));
		System.out.println("Antall History: " + filmarkiv.antallSjanger(Sjanger.HISTORY));
		System.out.println("Antall Sci-Fi: " + filmarkiv.antallSjanger(Sjanger.SCIFI));
		System.out.println("Totalt antall filmer: " + filmarkiv.antall());
		System.out.println();
	}

}
