package co.gobd.gofetch.utility.deserializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import co.gobd.gofetch.model.JobModel;
import co.gobd.gofetch.model.task.DeliveryTask;
import co.gobd.gofetch.model.task.FetchDeliveryManTask;
import co.gobd.gofetch.model.task.JobTask;
import co.gobd.gofetch.model.task.JobTaskTypes;
import co.gobd.gofetch.model.task.PackagePickupTask;

/**
 * Created by tonmoy on 24-Apr-16.
 */
public class JobModelDeserializer implements JsonDeserializer<JobModel> {

    private JobModel jobModel;

    //FIXME Write unit test
    @Override
    public JobModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        List<JobTask> jobTaskList = new ArrayList<>();

        final JsonObject jsonObject = json.getAsJsonObject();
        final JsonArray tasks = jsonObject.getAsJsonArray("Tasks");

        for (int i = 0; i < tasks.size(); i++) {
            final JsonObject task = tasks.get(i).getAsJsonObject();
            final String type = task.get("Type").getAsString();

            String jobTaskStateString;
            String state;
            switch (type) {
                case JobTaskTypes.FETCH_DELIVERYMAN:
                    jobTaskStateString = task.get("JobTaskStateString").getAsString();
                    state = task.get("State").getAsString();
                    jobTaskList.add(new FetchDeliveryManTask(jobTaskStateString, state));
                    break;

                case JobTaskTypes.PACKAGE_PICKUP:
                    jobTaskStateString = task.get("JobTaskStateString").getAsString();
                    state = task.get("State").getAsString();
                    jobTaskList.add(new PackagePickupTask(jobTaskStateString, state));
                    break;

                case JobTaskTypes.DELIVERY:
                    jobTaskStateString = task.get("JobTaskStateString").getAsString();
                    state = task.get("State").getAsString();
                    jobTaskList.add(new DeliveryTask(jobTaskStateString, state));
                    break;

                default:

                    break;
            }

        }

        String Name = jsonObject.get("Name").getAsString();
        String State = jsonObject.get("State").getAsString();

        jobModel = new JobModel(Name, State, jobTaskList);

        return jobModel;

    }
}
