package Principal;

import com.google.gson.annotations.SerializedName;

public class CatalogoMoneda {

    @SerializedName("base_code")
    private  String  base_code;

    @SerializedName("time_last_update_utc")
    private  String  time_last_update_utc;


    private double USD;
    private double AED;

    public String getBase_code() {
        return base_code;
    }

    public String getTime_last_update_utc() {
        return time_last_update_utc;
    }



    public double getUSD(){
        return USD;
    }

    public double getAED(){
        return AED;
    }


}
