package com.ulventech.command;

import com.ulventech.generator.FileGenerator;

public class Invoker {
	
	private FileGenerator command;

    public void setCommand(FileGenerator command) {
        this.command = command;
    }

    public void executeCommand(int n) throws Exception {
        if (command == null) {
            throw new Exception("No command set");
        }
        command.generateFile(n);
    }
}
