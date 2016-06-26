package co.gobd.gofetch.service.account;

import co.gobd.gofetch.network.ConnectionCallback;

/**
 * Created by fahad on 4/26/16.
 */
public interface RegistrationCallback extends ConnectionCallback {

  void onRegistrationSuccess();

  void onRegistrationFailure();
}