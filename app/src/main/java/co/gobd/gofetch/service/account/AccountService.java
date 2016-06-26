package co.gobd.gofetch.service.account;

import co.gobd.gofetch.model.account.UserModel;

/**
 * Created by tonmoy on 08-May-16.
 */
public interface AccountService {
  void register(UserModel user, RegistrationCallback callback);

  void login(String userName, String password, LoginCallback callback);

  void getProfile(String bearer, ProfileCallback callback);
}
