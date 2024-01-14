package com.example.pokedex.services;

import com.example.pokedex.models.Pokemon;
import com.example.pokedex.models.DetailedPokemon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Service class for interacting with an SQLite database to retrieve Pokémon data.
 * This class implements the PokemonDataService interface, providing the functionality
 * to retrieve Pokémon data from a local SQLite database.
 */
public class SQLitePokemonService implements PokemonDataService {
    private final String dbPath;

    /**
     * Constructor for the SQLitePokemonService.
     * Initializes a new instance with the specified database path.
     *
     * @param dbPath The file path to the SQLite database.
     */
    public SQLitePokemonService(String dbPath) {
        this.dbPath = dbPath;
    }

    /**
     * Retrieves a Pokémon by its ID from the SQLite database.
     * This method queries the database for a Pokémon with the specified ID and returns
     * the Pokémon data, including a detailed description if available.
     *
     * @param id The ID of the Pokémon to be retrieved.
     * @return A Pokemon object, or DetailedPokemon if additional data is available,
     *         or null if no Pokémon is found or in case of a database error.
     */
    @Override
    public Pokemon getPokemonById(int id) {
        // SQL query to fetch Pokémon data by ID
        String sql = "SELECT id, name, height, weight, description FROM pokemons WHERE id = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);  // Setting the ID parameter in the SQL query
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Extracting data from the ResultSet
                    int pokemonId = rs.getInt("id");
                    String name = rs.getString("name");
                    int height = rs.getInt("height");
                    int weight = rs.getInt("weight");
                    String description = rs.getString("description");

                    // Return a DetailedPokemon if description is available, else a regular Pokemon
                    return (description != null && !description.isEmpty())
                            ? new DetailedPokemon(pokemonId, name, height, weight, description)
                            : new Pokemon(pokemonId, name, height, weight);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Logging the SQL exception
        }
        return null;  // Returning null if no Pokémon is found or in case of an error
    }
}
