package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

//********************************************************************
// Representerer en samling kø, implementert vha en tabell.
// foran er i posisjon 0.
//********************************************************************

 public class TabellKoe<T> implements KoeADT<T>{
	 
   //Objektvariabler
   private final static int STDK = 100;
   private int bak;
   private T[] koe;
   private int kapasitet;

   /******************************************************************
    Oppretter en tom kø med standard størrelse.
   ******************************************************************/
   public TabellKoe()   {
     this.bak = 0;
     this.kapasitet = STDK;
     this.koe = (T[])(new Object[STDK]);
   }

   /******************************************************************
    Oppretter en tom kø med kapasitet gitt ved parameter
   ******************************************************************/
   public TabellKoe (int startKapasitet){
      this.bak = 0; 
      this.kapasitet = startKapasitet;
      this.koe = (T[])(new Object[startKapasitet]);
    }
   
   @Override
   public void innKoe(T element) {
	   if (bak == kapasitet) {
		   utvid();
	   }
	   koe[bak] = element;
	   bak++;
   }
   
   // Hjelpemetode for å utvide en full tabell.
   private void utvid() {
	   int nyKap = (int)Math.ceil(bak * 1.1);
	   T[] nyTabell = (T[])(new Object[nyKap]);
	   for (int i = 0; i < bak; i++) {
		   nyTabell[i] = this.koe[i];
	   }
	   this.koe = nyTabell;
   }
   
   @Override
   public T utKoe() {
	   if(erTom()) {
		   throw new EmptyCollectionException("Koe");
	   }
	   T utElement = koe[0];
	   for(int i = 1; i < bak; i++) {
		   koe[i-1] = koe[i];
	   }
	   bak--;
	   return utElement;
   }
   
   @Override
   public T foerste() {
	   if(erTom()) {
		   throw new EmptyCollectionException("Koe");
	   }
	   return koe[0];
   }
   
   @Override
   public int antall() {
	   return bak;
   }
   
   @Override
   public boolean erTom() {
	   boolean tom = false;
	   if (bak == 0) {
		   tom = true;
	   }
	   return tom;
   }

   //....
   
}//class



