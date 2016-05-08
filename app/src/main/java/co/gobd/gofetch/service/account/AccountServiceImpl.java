package co.gobd.gofetch.service.account;

import co.gobd.gofetch.model.account.AccessToken;
import co.gobd.gofetch.network.AccountApi;
import co.gobd.gofetch.utility.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tonmoy on 08-May-16.
 */
public class AccountServiceImpl implements AccountService {

    AccountApi accountApi;

    // Constructed by Dagger
    public AccountServiceImpl(AccountApi accountApi) {
        this.accountApi = accountApi;
    }

    @Override
    public void register(String userName, String password, String confirmPassword,
                         String email, String phoneNumber, RegistrationCallback callback) {

        // TODO Retrofit implementation
    }

    @Override
    public void login(String userName, String password, final LoginCallback callback) {
        Call<AccessToken> call = accountApi.login(userName, password,
                Constant.Login.GRANT_TYPE,
                Constant.Login.CLIENT_ID,
                Constant.Login.CLIENT_SECRET);

        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                if (response.isSuccessful()) {
                    // TODO Save the token somewhere
                    String accessToken = response.body().getAccessToken();
                    callback.onLoginSuccess(accessToken);
                } else {
                    callback.onLoginFailure();
                }
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                callback.onConnectionError();
            }
        });


    }

    @Override
    public void getProfile(String bearer, ProfileCallback callback) {
        // TODO Retrofit implementation
    }
}
