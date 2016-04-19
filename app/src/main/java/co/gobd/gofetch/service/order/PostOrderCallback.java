package co.gobd.gofetch.service.order;

import co.gobd.gofetch.callback.ConnectionCallback;

/**
 * Created by tonmoy on 19-Apr-16.
 */
public interface PostOrderCallback extends ConnectionCallback{
    void onPostOrderSuccess();
    void onPostOrderFailure();
}
