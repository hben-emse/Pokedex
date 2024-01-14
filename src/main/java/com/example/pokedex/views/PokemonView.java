package com.example.pokedex.views;

import com.example.pokedex.utilities.CsvFormatGenerator;
import com.example.pokedex.utilities.HtmlFormatGenerator;
import com.example.pokedex.utilities.TextFormatGenerator;
import com.example.pokedex.models.Pokemon;

/**
 * View class for presenting Pokémon data in various formats.
 * This class implements methods to represent Pokémon data as human-readable text,
 * HTML, and CSV formats.
 */
public class PokemonView implements TextFormatGenerator, HtmlFormatGenerator, CsvFormatGenerator {
    protected Pokemon pokemon;  // The Pokémon data to be displayed

    /**
     * Constructor for PokemonView.
     * Initializes the view with a specific Pokémon instance.
     *
     * @param pokemon The Pokemon object to be displayed.
     */
    public PokemonView(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    /**
     * Generates a human-readable text representation of the Pokémon data.
     *
     * @return A string representing the Pokémon data in a human-readable text format.
     */
    @Override
    public String generateHumanReadableText() {
        return "=============================" +
                "\nPokémon # " + pokemon.getId() +
                "\nNom : " + pokemon.getName() +
                "\nTaille : " + pokemon.getHeight() +
                "\nPoids : " + pokemon.getWeight() +
                "\n=============================\n";
    }

    /**
     * Generates an HTML representation of the Pokémon data.
     *
     * @return A string representing the Pokémon data in HTML format.
     */
    @Override
    public String generateHTML() {
        return "<h1>" + pokemon.getName() + "</h1>\n" +
                "<ul>\n" +
                "<li>Id : " + pokemon.getId() + "</li>\n" +
                "<li>Taille : " + pokemon.getHeight() + "</li>\n" +
                "<li>Poids : " + pokemon.getWeight() + "</li>\n" +
                "</ul>\n";
    }

    /**
     * Generates a CSV (Comma-Separated Values) representation of the Pokémon data.
     *
     * @return A string representing the Pokémon data in CSV format.
     */
    @Override
    public String generateCSV() {
        return "Id;Name;Height;Weight;\n" +
                pokemon.getId() + ";" +
                "\"" + pokemon.getName() + "\";" +
                pokemon.getHeight() + ";" +
                pokemon.getWeight() + "\n";
    }
}
