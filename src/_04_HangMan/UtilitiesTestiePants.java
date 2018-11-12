package _04_HangMan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UtilitiesTestiePants {

	@Test
	void test() {
		System.out.println(Utilities.getTotalWordsInFile("dictionary.txt"));
		assertEquals(Utilities.getTotalWordsInFile("dictionary.txt"), 266);
	}

}
