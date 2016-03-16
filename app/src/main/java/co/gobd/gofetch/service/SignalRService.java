package co.gobd.gofetch.service;

import android.util.Log;

import com.google.gson.JsonElement;

import co.gobd.gofetch.config.SignalRConfig;
import microsoft.aspnet.signalr.client.Action;
import microsoft.aspnet.signalr.client.ErrorCallback;
import microsoft.aspnet.signalr.client.MessageReceivedHandler;
import microsoft.aspnet.signalr.client.Platform;
import microsoft.aspnet.signalr.client.http.android.AndroidPlatformComponent;
import microsoft.aspnet.signalr.client.hubs.HubConnection;
import microsoft.aspnet.signalr.client.hubs.HubProxy;

/**
 * Created by tonmoy on 04-Feb-16.
 */
public class SignalRService implements BaseTrackerService {

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
                Log.i(TAG, "run: Connecting to SignalR");
            }
        });

        hubConnection.connected(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "run: Connected to SignalR");
            }
        });
    }

    @Override
    public void stopConnection() {
        hubConnection.stop();

        hubConnection.closed(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "run: Connection to SignalR closed");
            }
        });
    }

    @Override
    public void receiveData() {
        hubConnection.received(new MessageReceivedHandler() {
            @Override
            public void onMessageReceived(JsonElement jsonElement) {
                Log.i(TAG, "onMessageReceived: " + jsonElement.toString());
            }
        });

        hubConnection.error(new ErrorCallback() {
            @Override
            public void onError(Throwable throwable) {
                Log.i(TAG, "onError: Error receiving data " + throwable.getMessage());
            }
        });

    }


}
