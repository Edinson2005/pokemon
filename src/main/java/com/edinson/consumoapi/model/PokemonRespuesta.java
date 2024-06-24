package com.edinson.consumoapi.model;

import java.util.List;


///Segundo paso este paso Respuesta

public class PokemonRespuesta {
    private List<Pokemon> results;
//constructor vacio
    public PokemonRespuesta() {
    }
//costructor con para metros
    public PokemonRespuesta(List<Pokemon> results) {
        this.results = results;
    }
//get  y set
    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}
