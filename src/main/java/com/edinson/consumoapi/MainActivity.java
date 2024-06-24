package com.edinson.consumoapi;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.edinson.consumoapi.model.Pokemon;
import com.edinson.consumoapi.model.PokemonApi;
import com.edinson.consumoapi.model.PokemonRespuesta;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ListView pokemonListView;
    private PokemonAdapter pokemonAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        pokemonListView = findViewById(R.id.pokemon_list);

///paso 4 colocamos la url principal para hacer el llamado a la base de datos
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //realizar la creacion de la interfaz donde esta el metodo
        PokemonApi pokemonApi = retrofit.create(PokemonApi.class);
        //Hago el llamado al metodo que esta en el APIservicxe
        Call<PokemonRespuesta> call = pokemonApi.getPokemonList();

        //creamos el evento callback  de el llamado al metodo
        call.enqueue(new Callback<PokemonRespuesta>() {
            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
                if(response.isSuccessful()) {
                    List<Pokemon> pokemonList = response.body().getResults();
                    pokemonAdapter = new PokemonAdapter(MainActivity.this, pokemonList);
                    pokemonListView.setAdapter(pokemonAdapter);
                } else {
                    Toast.makeText(MainActivity.this, "Failed to retrieve Pokémon", Toast.LENGTH_SHORT).show();
                }
               /* PokemonRespuesta pokemonRespuesta = response.body();

                Toast.makeText(MainActivity.this ,""+response.body(), Toast.LENGTH_SHORT).show();
                for(Pokemon pokemon : pokemonRespuesta.getResults()){
                    Toast.makeText(MainActivity.this, ""+ pokemon.getName(),Toast.LENGTH_SHORT).show();

                }*/
            }

            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {

            }
        });
    }
}