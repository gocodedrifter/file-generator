package com.ulventech;

import com.ulventech.command.GenerateFileCommand;
import com.ulventech.command.Invoker;

public class Main {
	public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            throw new IllegalArgumentException("Please provide a number as an argument");
        }

        int n = Integer.parseInt(args[0]);

        if (n <= 0 || n >= Math.pow(2, 30)) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        GenerateFileCommand generateFileCommand = new GenerateFileCommand();
        Invoker invoker = new Invoker();
        invoker.setCommand(generateFileCommand);
        invoker.executeCommand(n);
    }
}
