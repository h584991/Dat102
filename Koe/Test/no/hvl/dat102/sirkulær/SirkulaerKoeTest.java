package no.hvl.dat102.sirkulær;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeADTTest;
import no.hvl.dat102.sirkulær.SirkulaerKoe;

public class SirkulaerKoeTest extends KoeADTTest {
	   @Override
		protected KoeADT<Integer> reset() {
			return new SirkulaerKoe<Integer>();
		}		
}
