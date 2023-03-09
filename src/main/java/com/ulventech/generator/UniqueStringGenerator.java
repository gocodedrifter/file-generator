package com.ulventech.generator;

import java.util.Random;

public class UniqueStringGenerator implements StringGenerator {
	private final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    @Override
    public String generateString(int length) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();

        while (builder.length() < length) {
            int index = random.nextInt(CHARACTERS.length());
            builder.append(CHARACTERS.charAt(index));
        }

        return builder.toString();
    }
}
