package com.example.pokedex.utilities;

/**
 * Utility class for console output in various formats.
 * This class is responsible for outputting data to the console in different formats,
 * such as text, HTML, or CSV, depending on the specified output format.
 */
public class ConsoleOutputUtility {
    private OutputFormat outputFormat;           // The desired output format
    private TextFormatGenerator textGenerator;   // Utility for generating text format
    private HtmlFormatGenerator htmlGenerator;   // Utility for generating HTML format
    private CsvFormatGenerator csvGenerator;     // Utility for generating CSV format

    /**
     * Constructor for ConsoleOutputUtility.
     * Initializes the utility with specific format generators.
     *
     * @param outputFormat The output format (TEXT, HTML, CSV).
     * @param textGen The text format generator.
     * @param htmlGen The HTML format generator.
     * @param csvGen The CSV format generator.
     */
    public ConsoleOutputUtility(OutputFormat outputFormat,
                                TextFormatGenerator textGen,
                                HtmlFormatGenerator htmlGen,
                                CsvFormatGenerator csvGen) {
        this.outputFormat = outputFormat;
        this.textGenerator = textGen;
        this.htmlGenerator = htmlGen;
        this.csvGenerator = csvGen;
    }

    /**
     * Produces and prints the output in the designated format.
     * Depending on the output format set, this method will use the appropriate
     * generator to create and print the output to the console.
     *
     * @throws IllegalArgumentException if an unknown output format is specified.
     */
    public void makeOutput() {
        switch (outputFormat) {
            case TEXT:
                if (textGenerator != null) {
                    System.out.println(textGenerator.generateHumanReadableText());
                }
                break;
            case HTML:
                if (htmlGenerator != null) {
                    System.out.println(htmlGenerator.generateHTML());
                }
                break;
            case CSV:
                if (csvGenerator != null) {
                    System.out.println(csvGenerator.generateCSV());
                }
                break;
            default:
                // Handling unexpected output format
                throw new IllegalArgumentException("Unknown output format");
        }
    }
}
