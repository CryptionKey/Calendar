package com.example.recyclerview.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestPokemonAPI {
    @GET("pokemon")
    Call<RestPokemonResponse> getListPokemon();

}
