package com.example.pokedex.utilities;

/**
 * Enumeration of possible output formats.
 * This enum defines the different types of output formats that can be used
 * for displaying or exporting data, such as text, HTML, or CSV.
 */
public enum OutputFormat {
    /**
     * Represents a plain text output format.
     * This format is intended for human-readable text, typically used for console or log output.
     */
    TEXT,

    /**
     * Represents an HTML output format.
     * This format is intended for data structured in HTML, which can be rendered in web browsers.
     */
    HTML,

    /**
     * Represents a CSV (Comma-Separated Values) output format.
     * This format is used for data export and import, especially in spreadsheets and databases,
     * where data is separated by commas.
     */
    CSV
}
