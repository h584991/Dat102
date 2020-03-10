package no.hvl.dat102.sirkulær;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

//********************************************************************
// Representerer en samling kø, implementert vha en sirkulær tabell.
//********************************************************************
public class SirkulaerKoe<T> implements KoeADT<T> {
	
	// Objektvariabler
	private int front, rear;
	private final int STANDARDSIZE = 10;
	private T[] koe;
	private int size;
	private int antall;
	
	/******************************************************************
     Oppretter en tom kø med standard størrelse.
    ******************************************************************/
	public SirkulaerKoe() {
		this.front = this.rear = -1;
		this.koe = (T[])(new Object[STANDARDSIZE]);
		this.size = STANDARDSIZE;
	}
	
	/******************************************************************
     Oppretter en tom kø med kapasitet gitt ved parameter
    ******************************************************************/
	public SirkulaerKoe(int size) {
		this.front = this.rear = -1;
		this.koe = (T[])(new Object[size]);
		this.size = size;
	}
	
	@Override
	public void innKoe(T element) {
		if (front == -1 && rear == -1) {
			koe[0] = element;
			front = rear = 0;
			antall++;
		}
		else if ((rear+1)%size == front) {
			System.out.println("Køen er full");
		}
		else {
			rear = (rear+1)%size;
			koe[rear] = element;
			antall++;
		}
	}
	
	@Override
	public T utKoe() {
		if (front == -1 && rear == -1) {
			throw new EmptyCollectionException("Køen");
		}
		else if (front == rear) {
			T element = koe[front];
			front = rear = -1;
			antall--;
			return element;
		}
		else {
			T element = koe[front];
			front = (front+1)%size;
			antall--;
			return element;
		}
	}
		
	@Override
	public T foerste() {
		if (front == -1 && rear == 1) {
			throw new EmptyCollectionException("Køen");
		}
		else {
			T element = koe[front];
			return element;
		}
			
	}
	
	@Override
	public boolean erTom() {
		if (front == -1 && rear == -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public int antall() {
		return antall;
	}
	

}
