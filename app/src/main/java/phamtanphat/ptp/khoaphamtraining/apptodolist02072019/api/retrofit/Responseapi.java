package phamtanphat.ptp.khoaphamtraining.apptodolist02072019.api.retrofit;

import phamtanphat.ptp.khoaphamtraining.apptodolist02072019.api.modelapi.Loginresponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Responseapi {

    @FormUrlEncoded
    @POST("login.php")
    Call<Loginresponse> getLoginapi(@Field("username") String username,
                                    @Field("password") String password);
}
