package phamtanphat.ptp.khoaphamtraining.apptodolist02072019.respository;

import androidx.lifecycle.MutableLiveData;

import phamtanphat.ptp.khoaphamtraining.apptodolist02072019.api.modelapi.Loginresponse;
import phamtanphat.ptp.khoaphamtraining.apptodolist02072019.api.retrofit.Responseapi;
import phamtanphat.ptp.khoaphamtraining.apptodolist02072019.api.retrofit.Retrofitinit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Loginrespository {

    private static Loginrespository loginrespository = null;
    private Responseapi responseapi;

    private Loginrespository() {
        responseapi = Retrofitinit.getApi();
    }

    public static Loginrespository getInstance() {
        if (loginrespository == null) {
            loginrespository = new Loginrespository();
        }
        return loginrespository;
    }

    public MutableLiveData<Loginresponse> getDataLogin(String username, String password) {
        final MutableLiveData<Loginresponse> mutableLiveData = new MutableLiveData<>();

        responseapi.getLoginapi(username, password).enqueue(new Callback<Loginresponse>() {
            @Override
            public void onResponse(Call<Loginresponse> call, Response<Loginresponse> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Loginresponse> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
