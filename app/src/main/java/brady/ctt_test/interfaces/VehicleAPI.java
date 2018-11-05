package brady.ctt_test.interfaces;

import brady.ctt_test.models.VehicleResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kieronbrady on 04/11/2018.
 */

/** The VehicleAPI source - GETS the list of vehicle*/
public interface VehicleAPI {
    @GET("vehicles")
    Call<VehicleResponse> getVehicles();
}
