package co.gobd.gofetch.service.account;

/**
 * Created by tonmoy on 08-May-16.
 */
public interface AccountService {
    void register(String userName, String password, String confirmPassword,
                  String email, String phoneNumber, RegistrationCallback callback);

    void login(String userName, String password, LoginCallback callback);

    void getProfile(String bearer, ProfileCallback callback);
}
