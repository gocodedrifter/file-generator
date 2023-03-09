package com.ulventech.generator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UniqueStringGeneratorTest {

	private UniqueStringGenerator generator;

    @Before
    public void setUp() {
        generator = new UniqueStringGenerator();
    }

    @Test
    public void testGenerateStringReturnsStringOfCorrectLength() throws Exception {
        String generatedString = generator.generateString();
        Assert.assertEquals(100, generatedString.length());
    }

    @Test
    public void testGenerateStringReturnsUniqueStrings() throws Exception {
        String string1 = generator.generateString();
        String string2 = generator.generateString();
        Assert.assertNotEquals(string1, string2);
    }
}
