package de.fotaris.retrofit;


import de.fotaris.retrofit.models.IpResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Tobias Feldmann on 12.08.16.
 */
public interface IpService {

    @GET("ip")
    Call<IpResponse> getIp();


}
