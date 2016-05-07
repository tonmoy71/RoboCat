package co.gobd.gofetch.config;

/**
 * Created by tonmoy on 01-Feb-16.
 */
public class ApiEndpoint {

    private ApiEndpoint() {
    }

    public static final class TaskCat {
        // Development
        public static final String BASE = "http://taskcatdev.azurewebsites.net";
        public static final String GET_SUPPORTED_ORDER = "/api/order/supportedorder";
        public static final String POST_ORDER = "/api/Order";
    }

    public static final class SignalR {

        public final static String URL = "http://gobdodin.cloudapp.net:1337/realtime/hubs";
        public final static String HUB_NAME = "GoTransitBroadcastHub";
    }


}
