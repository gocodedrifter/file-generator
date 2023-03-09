package com.ulventech.generator;

import java.security.SecureRandom;

public class UniqueStringGenerator implements StringGenerator {
	private final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private final int LINE_LENGTH = 100;
    private final SecureRandom random = new SecureRandom();

    @Override
    public String generateString() throws Exception {
        byte[] randomBytes = new byte[LINE_LENGTH];
        random.nextBytes(randomBytes);
        StringBuilder sb = new StringBuilder(LINE_LENGTH);
        for (byte b : randomBytes) {
            sb.append(CHARACTERS.charAt(Math.abs(b) % CHARACTERS.length()));
        }
        return sb.toString();
    }
}
