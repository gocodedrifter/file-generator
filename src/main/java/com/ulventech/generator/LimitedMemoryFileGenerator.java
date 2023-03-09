package com.ulventech.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

public class LimitedMemoryFileGenerator implements FileGenerator {
	private static final int MAX_MEMORY_USAGE_BYTES = 10 * 1024 * 1024; // 10 MB
    private final StringGenerator stringGenerator;
    private final String filename = "output.txt";

    public LimitedMemoryFileGenerator(StringGenerator stringGenerator) {
        this.stringGenerator = stringGenerator;
    }
    
    public boolean isFileGenerated(String filename) {
        File file = new File(filename);
        return file.exists();
    }

    @Override
    public void generateFile(int n) throws Exception {
        if (n <= 0 || n >= Math.pow(2, 30)) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        long startTime = System.currentTimeMillis();

        Set<String> uniqueStrings = new HashSet<>();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.filename))) {
            int linesWritten = 0;
            while (linesWritten < n) {
                String line = stringGenerator.generateString();
                if (uniqueStrings.add(line)) {
                    writer.write(line);
                    writer.newLine();
                    linesWritten++;
                    if (linesWritten % 10000 == 0) {
                        long currentMemoryUsage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                        if (currentMemoryUsage > MAX_MEMORY_USAGE_BYTES) {
                            System.gc();
                            Thread.sleep(100);
                        }
                    }
                }
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Total time taken: " + (endTime - startTime) + " ms");
    }
}
