package com.example.pokedex.views;

import com.example.pokedex.models.DetailedPokemon;

/**
 * View class for presenting detailed Pokémon data in various formats.
 * This class extends PokemonView to include additional information, specifically a detailed description.
 */
public class DetailedPokemonView extends PokemonView {

    private DetailedPokemon detailedPokemon;  // The detailed Pokémon data to be displayed

    /**
     * Constructor for DetailedPokemonView.
     * Initializes the view with a specific DetailedPokemon instance.
     *
     * @param pokemon The DetailedPokemon object to be displayed.
     */
    public DetailedPokemonView(DetailedPokemon pokemon) {
        super(pokemon);
        this.detailedPokemon = pokemon;
    }

    /**
     * Generates a human-readable text representation of the detailed Pokémon data.
     * This method adds the Pokémon's description to the text representation.
     *
     * @return A string representing the detailed Pokémon data in a human-readable text format.
     */
    @Override
    public String generateHumanReadableText() {
        String original = super.generateHumanReadableText();
        return original.substring(0, original.lastIndexOf("\n============================="))
                + "\nDescription : " + detailedPokemon.getDescription() + "\n=============================\n";
    }

    /**
     * Generates an HTML representation of the detailed Pokémon data.
     * This method adds the Pokémon's description to the HTML representation.
     *
     * @return A string representing the detailed Pokémon data in HTML format.
     */
    @Override
    public String generateHTML() {
        return super.generateHTML().substring(0, super.generateHTML().length() - 5) // Remove the closing </ul>
                + "<li>Description : " + detailedPokemon.getDescription() + "</li>\n</ul>\n";
    }

    /**
     * Generates a CSV (Comma-Separated Values) representation of the detailed Pokémon data.
     * This method adds the Pokémon's description to the CSV representation.
     *
     * @return A string representing the detailed Pokémon data in CSV format.
     */
    @Override
    public String generateCSV() {
        String[] rows = super.generateCSV().trim().split("\n");
        return String.join("description;\n", rows) + ";\"" + detailedPokemon.getDescription() + "\"\n";
    }
}
