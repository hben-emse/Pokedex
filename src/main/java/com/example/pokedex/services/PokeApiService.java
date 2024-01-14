package com.example.pokedex.services;

import com.example.pokedex.models.Pokemon;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Service class for interacting with the PokeAPI.
 * This class is responsible for making HTTP requests to the PokeAPI to retrieve Pokémon data.
 */
public class PokeApiService implements PokemonDataService {
    // URL of the PokeAPI endpoint
    private static final String API_URL = "https://pokeapi.co/api/v2/pokemon/";

    /**
     * Retrieves a Pokémon by its ID from the PokeAPI.
     * This method forms an HTTP GET request to the PokeAPI, parses the JSON
     * @param id The ID of the Pokémon to be retrieved.
     * @return A Pokemon object with data retrieved from the PokeAPI, or null in case of an error.
     * @throws IOException if a network error occurs during the HTTP request.
     * @throws ParseException if an error occurs during parsing of the JSON response.
     */
    @Override
    public Pokemon getPokemonById(int id) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // Forming the GET request with the specified Pokémon ID
            HttpGet request = new HttpGet(API_URL + id);
            // Executing the request and getting the response
            HttpResponse response = httpClient.execute(request);
            // Converting the response entity to a String
            String jsonString = EntityUtils.toString(response.getEntity());
            // Parsing the JSON string to a JSONObject
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonString);

            // Extracting data from the JSON object
            int pokemonId = ((Long) jsonObject.get("id")).intValue();
            String name = (String) jsonObject.get("name");
            int height = ((Long) jsonObject.get("height")).intValue();
            int weight = ((Long) jsonObject.get("weight")).intValue();

            // Creating and returning a new Pokemon object with the retrieved data
            return new Pokemon(pokemonId, name, height, weight);
        } catch (IOException | ParseException e) {
            // Printing the stack trace in case of an exception and returning null
            e.printStackTrace();
            return null;
        }
    }
}
