package co.gobd.gofetch.service.tracker;

/**
 * Created by tonmoy on 04-Feb-16.
 */
public interface BaseTrackerService {

    void setup();

    void startConnection();

    void stopConnection();

    void receiveData();
}
