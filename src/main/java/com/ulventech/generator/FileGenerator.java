package com.ulventech.generator;

import java.io.IOException;

public interface FileGenerator {
	void generateFile(int numLines, String fileName) throws IOException;
}
