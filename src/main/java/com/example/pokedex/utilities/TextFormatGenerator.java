package com.example.pokedex.utilities;

/**
 * Interface for generating human-readable text format.
 * Implementing classes should provide the functionality to generate data in a text format
 * that is easily readable by humans.
 */
public interface TextFormatGenerator {

    /**
     * Generates and returns a string in a human-readable text format.
     * This method is responsible for creating a textual representation of data,
     * formatted in a way that is easy to read and understand.
     *
     * @return A String representing the data in a human-readable text format.
     */
    String generateHumanReadableText();
}
