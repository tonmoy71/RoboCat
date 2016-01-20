package co.gobd.gofetch.model;

/**
 * Created by tonmoy on 20-Jan-16.
 */
public class SupportedOrder {

    private String actionName;
    private String itemName;
    private int resourceId;

    public String getActionName() {
        return actionName;
    }

    public String getItemName() {
        return itemName;
    }

    public int getResourceId() {
        return resourceId;
    }

    public SupportedOrder(String actionName, String itemName, int resourceId) {
        this.actionName = actionName;
        this.itemName = itemName;
        this.resourceId = resourceId;
    }


}
