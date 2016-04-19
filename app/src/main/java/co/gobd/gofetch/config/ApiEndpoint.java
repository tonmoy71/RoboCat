package co.gobd.gofetch.config;

/**
 * Created by tonmoy on 01-Feb-16.
 */
public class ApiEndpoint {

    private ApiEndpoint() {
    }

    public static final class TaskCat {
        public static final String BASE = "http://gofetch.cloudapp.net";
        public static final String GET_SUPPORTED_ORDER = "/api/order/supportedorder";
        public static final String POST_ORDER = "/api/Order";
    }


}
