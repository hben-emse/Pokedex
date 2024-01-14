package com.example.pokedex.models;

/**
 * Represents a Pokémon entity.
 * This class models the essential attributes of a Pokémon, such as its ID, name, height, and weight.
 */
public class Pokemon {
    private int id;
    private String name;
    private int height;
    private int weight;

    /**
     * Constructor for the Pokemon class.
     * Initializes a new Pokémon instance with the specified attributes.
     *
     * @param id The unique identifier for the Pokémon.
     * @param name The name of the Pokémon.
     * @param height The height of the Pokémon.
     * @param weight The weight of the Pokémon.
     */
    public Pokemon(int id, String name, int height, int weight) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    // Getters

    /**
     * Gets the ID of the Pokémon.
     *
     * @return The ID of the Pokémon.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the Pokémon.
     *
     * @return The name of the Pokémon.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the height of the Pokémon.
     *
     * @return The height of the Pokémon.
     */
    public int getHeight() {
        return height;
    }
    /**
     * Gets the weight of the Pokémon.
     *
     * @return The weight of the Pokémon.
     */
    public int getWeight() {
        return weight;
    }
}
