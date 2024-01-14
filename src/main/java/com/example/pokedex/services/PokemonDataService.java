package com.example.pokedex.services;

import com.example.pokedex.models.Pokemon;

/**
 * Interface for services that provide data about Pokémon.
 * This interface defines the contract for services that can retrieve Pokémon data,
 * ensuring a consistent API regardless of the underlying data source implementation.
 */
public interface PokemonDataService {

    /**
     * Retrieves a Pokémon by its ID.
     * Implementing classes should provide the logic to fetch data for a Pokémon based on its ID,
     * and return the corresponding Pokémon object.
     *
     * @param id The ID of the Pokémon to be retrieved.
     * @return A Pokemon object corresponding to the specified ID, or null if no Pokémon is found.
     */
    Pokemon getPokemonById(int id);
}
