package phamtanphat.ptp.khoaphamtraining.apptodolist02072019.api.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
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

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                                        .readTimeout(10, TimeUnit.SECONDS)
                                        .writeTimeout(10,TimeUnit.SECONDS)
                                        .connectTimeout(10,TimeUnit.SECONDS)
                                        .build();

        retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .baseUrl("http://172.16.1.17:8080/apitodolist/")
                        .client(okHttpClient)
                        .build();

        return retrofit;
    }

}
