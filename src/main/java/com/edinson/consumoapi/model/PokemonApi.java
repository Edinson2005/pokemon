package com.edinson.consumoapi.model;

import android.adservices.topics.GetTopicsRequest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonApi {

    //3 paso añadimos los metodos q vamos a utilizar
    @GET("pokemon") //metodo get para obtener los datos
    Call<PokemonRespuesta> getPokemonList();

}
