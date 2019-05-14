package org.coding;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LetterSorterTest {

	LetterSorter sorter = new LetterSorter();
	
	@Test
	public void test() {		
				
		assertEquals("[a=3, h=4, d=5]", sorter.findKMostFrequentLetters("aaabhbcdddddhhhi", 3).toString());
	}
	
}
