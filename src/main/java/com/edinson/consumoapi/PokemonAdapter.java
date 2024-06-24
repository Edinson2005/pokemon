package com.edinson.consumoapi;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.edinson.consumoapi.model.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.List;


public class PokemonAdapter extends ArrayAdapter<Pokemon> {
    public PokemonAdapter(Context context, List<Pokemon> pokemons) {
        super(context, 0, pokemons);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Pokemon pokemon = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_pokemon, parent, false);
        }
        // Lookup view for data population
        TextView nameTextView = convertView.findViewById(R.id.pokemon_name);


        // Populate the data into the template view using the data object
        nameTextView.setText(pokemon.getName());


        return convertView;

    }
}