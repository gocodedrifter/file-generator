package com.ulventech.command;

import com.ulventech.generator.FileGenerator;
import com.ulventech.generator.LimitedMemoryFileGenerator;
import com.ulventech.generator.UniqueStringGenerator;

public class GenerateFileCommand implements FileGenerator {

    @Override
    public void generateFile(int n) throws Exception {
        LimitedMemoryFileGenerator fileGenerator = new LimitedMemoryFileGenerator(new UniqueStringGenerator());
        fileGenerator.generateFile(n);
    }
}
