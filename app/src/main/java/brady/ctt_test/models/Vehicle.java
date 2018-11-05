package brady.ctt_test.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kieronbrady on 04/11/2018.
 */

/** Vehicle Class - holds information regarding a single vehicle*/
public class Vehicle implements Serializable {
    @SerializedName("vehicleId")
    private int vehicleId;
    @SerializedName("vrn")
    private String vrn;
    @SerializedName("country")
    private String country;
    @SerializedName("color")
    private String color;
    @SerializedName("type")
    private String type;
    @SerializedName("default")
    private boolean isDefault;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVrn() {
        return vrn;
    }

    public void setVrn(String vrn) {
        this.vrn = vrn;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
}
