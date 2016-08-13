package de.fotaris.retrofit;

import de.fotaris.retrofit.models.IpResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Tobias Feldmann on 12.08.16.
 */
public class IpController {

    private EndpointAdapter endpointAdapter;
    private IpService ipService;


    public IpController() {
        endpointAdapter = EndpointAdapter.getInstance();
        ipService = endpointAdapter.getService();
    }

    public void getIp(final ResponseCallback<IpResponse> callback) {
        Call<IpResponse> call = ipService.getIp();
        call.enqueue(new Callback<IpResponse>() {
            @Override
            public void onResponse(Call<IpResponse> call, Response<IpResponse> response) {
                if (response.isSuccessful()) {
                    callback.success(response.body());
                } else {
                    callback.error();
                }
            }

            @Override
            public void onFailure(Call<IpResponse> call, Throwable t) {
                    callback.error();
                }
        });
    }

}
