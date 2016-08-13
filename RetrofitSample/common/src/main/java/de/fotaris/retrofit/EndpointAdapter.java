package de.fotaris.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tobias Feldmann on 12.08.16.
 */
public class EndpointAdapter {

    private static final String ENDPOINT_URL = "http://httpbin.org/";

    private static EndpointAdapter instance;
    private Retrofit retrofit;
    private IpService service;

    public EndpointAdapter() {
        retrofit = new Retrofit.Builder().baseUrl(ENDPOINT_URL).addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient()).build();
        service = retrofit.create(IpService.class);
    }

    public static EndpointAdapter getInstance() {

        if (EndpointAdapter.instance == null) {
            EndpointAdapter.instance = new EndpointAdapter();
        }
        return EndpointAdapter.instance;
    }

    public IpService getService() {
        return service;
    }
}
