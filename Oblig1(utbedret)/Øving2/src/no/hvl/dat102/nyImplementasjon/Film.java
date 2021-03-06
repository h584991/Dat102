package no.hvl.dat102.nyImplementasjon;

public class Film {
	
	//Oppretter objektvariabler
	private int filmNummer;
	private String produsentNavn;
	private String tittel;
	private int lanseringsår;
	private Sjanger sjanger;
	private String filmselskap;
	
	//konstruktør uten parameter
	public Film() {
		this.filmNummer = 0;
		this.produsentNavn = null;
		this.tittel = null;
		this.lanseringsår = 0;
		this.sjanger = null;
		this.filmselskap = null;
	}
	
	//konstruktør med parameter
	public Film(int filmNummer, String produsentNavn, String tittel, int lanseringsår, 
					Sjanger sjanger, String filmselskap) {	
		this.filmNummer = filmNummer;
		this.produsentNavn = produsentNavn;
		this.tittel = tittel;
		this.lanseringsår = lanseringsår;
		this.sjanger = sjanger;
		this.filmselskap = filmselskap;
	}
	
	//get metoder for objektvariabel verdier
	public int getFilmNummer() {
		return filmNummer;
	}
	
	public String getProdusent() {
		return produsentNavn;
	}
	
	public String  getTittel() {
		return tittel;
	}
	
	public int getLanseringsår() {
		return lanseringsår;
	}
	
	public Sjanger getSjanger() {
		return sjanger;
	}
	
	public String getFilmselskap() {
		return filmselskap;
	}
	
}
