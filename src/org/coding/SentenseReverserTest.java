package org.coding;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SentenseReverserTest {

	SentenceReverser reverser = new SentenceReverser();

	@Test
	public void test() {
		String result = reverser.process("This is a simple test");
		assertEquals("test simple a is This", result);
	}

	@Test
	public void testWithSpace() {
		String result = reverser.process("This  is a simple   test");
		assertEquals("test   simple a is  This", result);
	}

	@Test
	public void testWithSpace2() {
		String result = reverser.process(" This is a simple test  ");
		assertEquals("  test simple a is This ", result);
	}

	@Test
	public void testInPlacePermutations() {
		String sentence = "This is a simple test";
		char[] in = sentence.toCharArray();
		reverser.process(in);
		assertEquals("test simple a is This", new String(in));
	}

}
