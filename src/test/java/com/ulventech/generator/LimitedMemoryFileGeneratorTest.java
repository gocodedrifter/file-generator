package com.ulventech.generator;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class LimitedMemoryFileGeneratorTest {
	
	@Test
    public void testGenerateFilePositive() throws Exception {
        LimitedMemoryFileGenerator fileGenerator = new LimitedMemoryFileGenerator(new UniqueStringGenerator());
        int n = 100;

        // Act
        fileGenerator.generateFile(n);

        // Assert
        assertEquals(n, countLinesInFile());
        assertEquals(n, countUniqueLinesInFile());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenerateFileInvalidInput() throws Exception {
        LimitedMemoryFileGenerator fileGenerator = new LimitedMemoryFileGenerator(new UniqueStringGenerator());
        int n = (int) Math.pow(2, 30);

        // Act
        fileGenerator.generateFile(n);
    }

    private int countLinesInFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        return lines;
    }

    private int countUniqueLinesInFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
        Set<String> uniqueLines = new HashSet<>();
        String line;
        while ((line = reader.readLine()) != null) {
            uniqueLines.add(line);
        }
        reader.close();
        return uniqueLines.size();
    }
}
