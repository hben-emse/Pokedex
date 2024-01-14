package com.example.pokedex.utilities;

/**
 * Interface for generating HTML formatted data.
 * Implementing classes should provide the functionality to generate data in HTML format.
 */
public interface HtmlFormatGenerator {

    /**
     * Generates and returns a string in HTML format.
     * This method is responsible for creating an HTML representation of data.
     *
     * @return A String representing the data in HTML format.
     */
    String generateHTML();
}
