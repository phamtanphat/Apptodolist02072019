package phamtanphat.ptp.khoaphamtraining.apptodolist02072019.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import phamtanphat.ptp.khoaphamtraining.apptodolist02072019.R;
import phamtanphat.ptp.khoaphamtraining.apptodolist02072019.api.modelapi.Loginresponse;
import phamtanphat.ptp.khoaphamtraining.apptodolist02072019.respository.Loginrespository;
import phamtanphat.ptp.khoaphamtraining.apptodolist02072019.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    LoginViewModel loginViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginViewModel = new LoginViewModel();
        loginViewModel.checkLogin("phat","123").observe(this, new Observer<Loginresponse>() {
            @Override
            public void onChanged(Loginresponse loginresponse) {
                if (loginresponse != null){
                    if (loginresponse.getSuccess()){
                        Log.d("BBB",loginresponse.getIduser().toString());
                    }else{
                        Log.d("BBB","Dang nhap that bai");
                    }

                }
            }
        });
    }
}
