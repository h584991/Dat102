package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;


//********************************************************************
// Representer en samling koe, implementert vha kjedet struktur
//********************************************************************

public class KjedetKoe<T> implements KoeADT<T> {
	
	// Objektvariabler
	private int antall;
	private LinearNode<T> front, bak;
	
    /******************************************************************
     Oppretter en tom kø.
    ******************************************************************/
	public KjedetKoe() {
		this.antall = 0;
		this.front = this.bak = null;
	}
	
	@Override
	public int antall() {
		return antall;
	}
	
	@Override
	public void innKoe(T element) {
		LinearNode<T> nyttElement = new LinearNode<T>(element);
		if (front == null) {
			front = bak = nyttElement;
			antall++;
		}
		else {
			bak.setNeste(nyttElement);
			bak = nyttElement;
			antall++;
		}
	}
	
	@Override
	public T utKoe() {
		if (antall == 0) {
			throw new EmptyCollectionException("Køen");
		}
		else {
			T element = front.getElement();
			front = front.getNeste();
			antall--;
			return element;
		}
	}
	
	@Override
	public T foerste() {
		if (antall == 0) {
			throw new EmptyCollectionException("Køen");
		}
		else {
			T element = front.getElement();
			return element;
		}
	}
	
	@Override
	public boolean erTom() {
		if (antall > 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	
}// class
