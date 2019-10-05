package phamtanphat.ptp.khoaphamtraining.apptodolist02072019.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import phamtanphat.ptp.khoaphamtraining.apptodolist02072019.api.modelapi.Loginresponse;
import phamtanphat.ptp.khoaphamtraining.apptodolist02072019.respository.Loginrespository;

public class LoginViewModel extends ViewModel {

    public LoginViewModel() {
    }

    public MutableLiveData<Loginresponse> checkLogin(String username , String password){
        return Loginrespository.getInstance().getDataLogin(username,password);
    }
}
