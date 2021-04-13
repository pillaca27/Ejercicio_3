package com.cibertec.ejercicio_3.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectionRest {
    public static Retrofit retrofit;
    public static final String direccion="https://jsonplaceholder.typicode.com";

    public static Retrofit getConexion(){
        if(retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(direccion).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }


}
