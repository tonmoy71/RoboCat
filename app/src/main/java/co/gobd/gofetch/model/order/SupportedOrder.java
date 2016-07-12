package co.gobd.gofetch.model.order;

/**
 * Created by tonmoy on 01-Feb-16.
 */
public class SupportedOrder {

    private String ActionName;
    private String _id;
    private String OrderCode;
    private String ImageUrl;
    private String OrderName;

    public String getActionName() {
        return ActionName;
    }

    public void setActionName(String ActionName) {
        this.ActionName = ActionName;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String OrderCode) {
        this.OrderCode = OrderCode;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String ImageUrl) {
        this.ImageUrl = ImageUrl;
    }

    public String getOrderName() {
        return OrderName;
    }

    public void setOrderName(String OrderName) {
        this.OrderName = OrderName;
    }

    @Override
    public String toString() {
        return "SupportedOrder [ActionName = "
                + ActionName
                + ", _id = "
                + _id
                + ", OrderCode = "
                + OrderCode
                + ", ImageUrl = "
                + ImageUrl
                + ", OrderName = "
                + OrderName
                + "]";
    }
}