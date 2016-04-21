package co.gobd.gofetch.model.order;

import co.gobd.gofetch.model.Location;

/**
 * Created by tonmoy on 20-Apr-16.
 */
public class DeliveryOrder extends OrderModel {

    private Location From;
    private Location To;
    private String PackageDescription;
    private String PackageWeight;
    private String NoteToDeliveryMan;

    public DeliveryOrder(String name, String type) {
        super(name, type);
    }

    public Location getFrom() {
        return From;
    }

    public void setFrom(Location from) {
        From = from;
    }

    public Location getTo() {
        return To;
    }

    public void setTo(Location to) {
        To = to;
    }

    public String getPackageDescription() {
        return PackageDescription;
    }

    public void setPackageDescription(String packageDescription) {
        PackageDescription = packageDescription;
    }

    public String getPackageWeight() {
        return PackageWeight;
    }

    public void setPackageWeight(String packageWeight) {
        PackageWeight = packageWeight;
    }

    public String getNoteToDeliveryMan() {
        return NoteToDeliveryMan;
    }

    public void setNoteToDeliveryMan(String noteToDeliveryMan) {
        NoteToDeliveryMan = noteToDeliveryMan;
    }
}
