package com.ulventech.command;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ulventech.generator.LimitedMemoryFileGenerator;
import com.ulventech.generator.UniqueStringGenerator;

public class InvokerTest {
	
	@Test
    public void testExecuteCommand() throws Exception {
        LimitedMemoryFileGenerator fileGenerator = new LimitedMemoryFileGenerator(new UniqueStringGenerator());
        GenerateFileCommand generateFileCommand = new GenerateFileCommand();
        Invoker invoker = new Invoker();
        invoker.setCommand(generateFileCommand);
        invoker.executeCommand(1000);
        assertTrue(fileGenerator.isFileGenerated("output.txt"));
    }
}
