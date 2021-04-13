package com.cibertec.ejercicio_3.api;

import com.cibertec.ejercicio_3.entity.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceApi {
    @GET("/posts")
    public abstract Call<List<Posts>> listaPosts();

}
