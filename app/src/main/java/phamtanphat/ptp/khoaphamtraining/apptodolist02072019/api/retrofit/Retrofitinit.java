package phamtanphat.ptp.khoaphamtraining.apptodolist02072019.api.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitinit {
    private static Retrofit retrofit = null;

    private Retrofitinit(){
    }

    //Khởi tạo ra retrofit va responseapi
    public static Responseapi getApi(){
        if (retrofit == null){
            retrofit = getInstance();
        }
        return retrofit.create(Responseapi.class);
    }

    // Phuong thuc khởi tạo ra 1 retrofit
    private static Retrofit getInstance(){

        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .baseUrl("http://localhost:8080/apitodolist/")

    }

}
