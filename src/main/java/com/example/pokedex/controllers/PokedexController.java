package com.example.pokedex.controllers;

import com.example.pokedex.models.Pokemon;
import com.example.pokedex.services.PokemonDataService;


/**
 * Controller class for the Pokedex application.
 * This class handles the interaction between the view and the data service layer,
 * facilitating data retrieval and processing.
 */
public class PokedexController {
    private PokemonDataService dataService;

    /**
     * Constructor for PokedexController.
     * Initializes the controller with a specific data service.
     *
     * @param dataService The data service to be used by this controller.
     */
    public PokedexController(PokemonDataService dataService) {
        this.dataService = dataService;
    }

    /**
     * Retrieves a Pokémon by its ID.
     * Delegates the data fetching operation to the data service.
     *
     * @param pokemonId The ID of the Pokémon to be retrieved.
     * @return A Pokemon object corresponding to the specified ID.
     */
    public Pokemon getPokemonById(int pokemonId) { // return pokemon
        return dataService.getPokemonById(pokemonId);
    }
}


