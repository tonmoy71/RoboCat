package co.gobd.gofetch.service.account;

import co.gobd.gofetch.network.ConnectionCallback;

/**
 * Created by fahad on 10-Apr-16.
 */
public interface ProfileCallback extends ConnectionCallback {

  void onLoadProfileSuccess(String assetId);

  void onLoadProfileFailure();
}
