package com.example.pokedex.utilities;

/**
 * Interface for generating CSV formatted data.
 * Implementing classes should provide the functionality to generate data in CSV format.
 */
public interface CsvFormatGenerator {

    /**
     * Generates and returns a string in CSV format.
     * This method is responsible for creating a CSV representation of data.
     *
     * @return A String representing the data in CSV format.
     */
    String generateCSV();
}
