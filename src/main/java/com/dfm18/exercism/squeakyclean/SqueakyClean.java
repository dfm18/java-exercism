package com.dfm18.exercism.squeakyclean;

public class SqueakyClean {

    static String clean(String identifier) {
        // Replace ' ' with '_'
        identifier = identifier.replace(' ', '_');

        // Convert kebab-case to camelCase
        StringBuilder builder = new StringBuilder();
        boolean capitalizeNext = false;

        for (char c : identifier.toCharArray()) {
            if (c == '-') {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                builder.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                builder.append(c);
            }
        }

        identifier = builder.toString();

        // Convert leetspeak to normal text
        identifier = identifier.replace('4', 'a')
                .replace('3', 'e')
                .replace('0', 'o')
                .replace('1', 'l')
                .replace('7', 't');

        // Delete characters that are not letters or underscore
        builder = new StringBuilder();

        for (char c : identifier.toCharArray()) {
            if (Character.isLetter(c) || c == '_') {
                builder.append(c);
            }
        }

        return builder.toString();
    }
}
