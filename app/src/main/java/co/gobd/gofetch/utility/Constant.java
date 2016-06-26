package co.gobd.gofetch.utility;

/**
 * Created by tonmoy on 07-Mar-16.
 */

public class Constant {

  /* Google Place Picker */
  public static final int REQUEST_CODE_STARTING_POINT = 1;
  public static final int REQUEST_CODE_DESTINATION_POINT = 2;
  /* Key for ride request data */
  public static final String KEY_START_LATLNG = "START_LATLNG";
  public static final String KEY_DESTINATION_LATLNG = "DESTINATION_LATLNG";

  public static final String KEY_START_LOCATION = "START_LOCATION";
  public static final String KEY_DESTINATION_LOCATION = "DESTINATION_LOCATION";

  public static final String KEY_START_ADDRESS = "START_ADDRESS";
  public static final String KEY_DESTINATION_ADDRESS = "DESTINATION_ADDRESS";
  public static final String KEY_START_NOTE = "START_NOTE";
  public static final String KEY_DESTINATION_NOTE = "DESTINATION_NOTE";

  private Constant() {

  }

  public final class BackendName {
    public static final String TASK_CAT = "TASK_CAT";
    public static final String SHADOW_CAT = "SHADOW_CAT";
  }

  public final class Login {
    public static final String GRANT_TYPE = "password";
    public static final String CLIENT_ID = "GoFetchDevDroidApp";
    public static final String CLIENT_SECRET = "GoFetchDevDroidApp@gobd";
  }
}
