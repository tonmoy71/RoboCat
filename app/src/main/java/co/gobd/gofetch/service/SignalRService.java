package co.gobd.gofetch.service;

import android.util.Log;

import co.gobd.gofetch.config.SignalRConfig;
import microsoft.aspnet.signalr.client.Action;
import microsoft.aspnet.signalr.client.Platform;
import microsoft.aspnet.signalr.client.http.android.AndroidPlatformComponent;
import microsoft.aspnet.signalr.client.hubs.HubConnection;
import microsoft.aspnet.signalr.client.hubs.HubProxy;

/**
 * Created by tonmoy on 04-Feb-16.
 */
public class SignalRService implements TrackerService {

    private static final String TAG = "SignalRService";

    private HubProxy hubProxy;
    private HubConnection hubConnection;

    @Override
    public void setup() {

        Platform.loadPlatformComponent(new AndroidPlatformComponent());
        hubConnection = new HubConnection(SignalRConfig.URL);
        hubProxy = hubConnection.createHubProxy(SignalRConfig.HUB_NAME);
    }

    @Override
    public void startConnection() {
        hubConnection.start().done(new Action<Void>() {
            @Override
            public void run(Void aVoid) throws Exception {
                Log.i(TAG, "run: SignalR connection established");
            }
        });
    }

    @Override
    public void stopConnection() {

    }

    @Override
    public void onReceiveData() {

    }


}
