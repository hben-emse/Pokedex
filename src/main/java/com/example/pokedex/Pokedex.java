package com.example.pokedex;

import com.example.pokedex.controllers.PokedexController;
import com.example.pokedex.models.DetailedPokemon;
import com.example.pokedex.models.Pokemon;
import com.example.pokedex.services.PokeApiService;
import com.example.pokedex.services.PokemonDataService;
import com.example.pokedex.services.SQLitePokemonService;
import com.example.pokedex.utilities.ConsoleOutputUtility;
import com.example.pokedex.utilities.OutputFormat;
import com.example.pokedex.views.PokemonView;
import com.example.pokedex.views.DetailedPokemonView;
import org.apache.commons.cli.*;

/**
 * The Pokedex class, containing the main method and application logic.
 */
public class Pokedex {

    /**
     * Enumeration for data source options.
     * WEB_API - to use a web-based API for data
     * LOCAL_DATABASE - to use a local database for data
     */
    private enum DataSource { WEB_API, LOCAL_DATABASE };

    /* Initializing dataSource to default value (WEB_API) */
    private static DataSource dataSource = DataSource.WEB_API;
    private static String databasePath;

    /* Initializing outputFormat to default value (TEXT) */
    private static OutputFormat outputFormat = OutputFormat.TEXT;
    private static int pokemonId;


    /**
     * The main method of the Pokedex application.
     * It parses command line arguments and initializes the application.
     *
     * @param args Command line arguments passed to the application
     * @throws ParseException if there is an error parsing command line arguments
     */
    public static void main(String[] args) throws ParseException {

        /* Parsing the command line arguments */
        try {
            parseCommandLineArguments(args);
        } catch (PokemonCommandLineParsingException e) {
            System.err.println(e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("./Pokedex <PokemonId> [-d|--database <databaseFile>] [-f|--format <format>]", e.getOptions());
            System.exit(0);
        }


        /* Initialize the appropriate data service based on the data source selected */
        PokemonDataService service;
        if (dataSource == DataSource.LOCAL_DATABASE) {
            service = new SQLitePokemonService(databasePath);
        } else {
            service = new PokeApiService();
        }
        /* Initialize the controller with the chosen data service */
        PokedexController controller = new PokedexController(service);

        /* Fetch the Pokémon data using the controller */
        Pokemon pokemon = controller.getPokemonById(pokemonId);


        /* Determine the appropriate view based on the type of Pokémon data */
        PokemonView view;
        if (pokemon instanceof DetailedPokemon) {
            // Use DetailedPokemonView for DetailedPokemon instances
            view = new DetailedPokemonView((DetailedPokemon) pokemon);
        } else {
            // Use PokemonView for other instances
            view = new PokemonView(pokemon);
        }


        /* Output using ConsoleOutputUtility */
        ConsoleOutputUtility consoleOutputUtility = new ConsoleOutputUtility(outputFormat, view, view, view);
        consoleOutputUtility.makeOutput();
    }

    /**
     * Parses the command line arguments and sets application configurations.
     * This method uses the Apache Commons CLI library to parse command line options.
     *
     * @param args Array of command line arguments passed to the application.
     * @throws PokemonCommandLineParsingException if there is an error during parsing.
     * @throws ParseException if there is an error in parsing the command line options.
     */
    public static void parseCommandLineArguments(String[] args) throws PokemonCommandLineParsingException, ParseException {
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();

        // Option for specifying the path to the SQLite database
        options.addOption("d", "database", true, "Path to a SQLite database containing pokemons");
        // Option for specifying the output format (text, html, csv)
        options.addOption("f", "format", true, "Specify the output format, between 'text', 'html' and 'csv'. By default 'text'.");

        // Parse the command line arguments
        CommandLine line = parser.parse(options, args);

        // Set the data source to LOCAL_DATABASE if the database option is provided
        if (line.hasOption("d")) {
            dataSource = DataSource.LOCAL_DATABASE;
            databasePath = line.getOptionValue("d");
        }

        // Set the output format based on the command line argument
        if (line.hasOption("f")) {
            String formatArgValue = line.getOptionValue("f");
            if (formatArgValue.equals("html")) {
                outputFormat = OutputFormat.HTML;
            } else if (formatArgValue.equals("csv")) {
                outputFormat = OutputFormat.CSV;
            } else if (formatArgValue.equals("text")) {
                outputFormat = OutputFormat.TEXT;
            } else {
                throw new PokemonCommandLineParsingException("Invalid value for the option -f/--format", options);
            }
        }
        // Get pokemon ID from remaining arguments
        String[] remainingArgs = line.getArgs();
        if (remainingArgs.length < 1) {
            throw new PokemonCommandLineParsingException("You must provide a pokemon ID", options);
        }
        try {
            pokemonId = Integer.parseInt(remainingArgs[0]);
        } catch (NumberFormatException e) {
            throw new PokemonCommandLineParsingException("'" + remainingArgs[0] + "' is not a valid pokemon ID", options);
        }
    }

    /**
     * A custom exception class used for handling command line parsing errors.
     * This exception class encapsulates details about the command line options
     * that led to the parsing error.
     */
    static class PokemonCommandLineParsingException extends Exception {

        private Options options; // Apache Commons CLI Options object

        /**
         * Constructor for PokemonCommandLineParsingException.
         * Creates a new exception instance with a detailed message and the related options.
         *
         * @param msg The detailed error message.
         * @param options The Options object containing the command line options.
         */
        public PokemonCommandLineParsingException(String msg, Options options) {
            super(msg); // Pass the error message to the superclass constructor
            this.options = options; // Set the options related to the exception
        }

        /**
         * Retrieves the Options object associated with this exception.
         * The Options object contains the command line options that triggered the exception.
         *
         * @return The Options object associated with the parsing error.
         */
        public Options getOptions() {
            return options;
        }

    }
}

