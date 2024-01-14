package com.example.pokedex.models;

/**
 * Represents a detailed Pokémon entity, extending the basic Pokémon model.
 * This class includes additional information in the form of a description,
 * providing more detailed data about the Pokémon.
 */
public class DetailedPokemon extends Pokemon {
    private String description;  // Detailed description of the Pokémon

    /**
     * Constructor for the DetailedPokemon class.
     * Initializes a new instance of DetailedPokemon with the specified attributes,
     * including the description.
     *
     * @param id The unique identifier for the Pokémon.
     * @param name The name of the Pokémon.
     * @param height The height of the Pokémon.
     * @param weight The weight of the Pokémon.
     * @param description The detailed description of the Pokémon.
     */
    public DetailedPokemon(int id, String name, int height, int weight, String description) {
        super(id, name, height, weight);  // Call to the superclass (Pokemon) constructor
        this.description = description;   // Setting the description
    }

    /**
     * Retrieves the description of the Pokémon.
     * This method returns the detailed description associated with the Pokémon.
     *
     * @return A string representing the description of the Pokémon.
     */
    public String getDescription() {
        return description;
    }
}
