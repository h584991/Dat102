package no.hvl.dat102.klient;



import no.hvl.dat102.Fil;
import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.adt.FILMarkivADT;

import java.util.Scanner;

public class KlientFilmarkiv {
	
	public static void main(String[] args) {
		String filnavn = null;
		FILMarkivADT filma = null;
		boolean validInput = false;
		Scanner s = new Scanner(System.in);
		System.out.println("Velkommen til filmarkivet");
		System.out.println("Tast inn filnavn på arkivet du ønsker å bruke, eller tast enter dersom du ønsker å starte et nytt arkiv");
		while(!validInput) {
			String str = s.nextLine();
			switch(str) {
			
			case "":
				System.out.print("Tast inn filnavn på nytt arkiv: ");
				filnavn = s.nextLine();
				filma = new Filmarkiv(10);
				validInput = true;
				break;
				
			default:
				filnavn = str;
				filma = Fil.lesFraFil(filnavn);
				if (filma != null) {
					validInput = true;
				}//if
				
			}//switch
			
		}//while
		
		Meny meny = new Meny(filma);
		meny.start();
		Fil.skrivTilFil(filma, filnavn);
		s.close();

	}//main

}//class
