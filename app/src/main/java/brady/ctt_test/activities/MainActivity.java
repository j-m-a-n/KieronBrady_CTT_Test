package brady.ctt_test.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import brady.ctt_test.R;
import brady.ctt_test.adapters.VehicleAdapter;
import brady.ctt_test.interfaces.OnVehicleClickListener;
import brady.ctt_test.models.Vehicle;
import brady.ctt_test.models.VehicleResponse;
import brady.ctt_test.interfaces.VehicleAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "http://private-6d86b9-vehicles5.apiary-mock.com/";
    private static Retrofit retrofit = null;
    private RecyclerView recyclerView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        try {
            getApiData();
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),R.string.error_noConnection, Toast.LENGTH_LONG).show();
        }
    }

    public void getApiData() {
        //Use Retrofit to get list of vehicles
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        VehicleAPI vehApiService = retrofit.create(VehicleAPI.class);
        Call<VehicleResponse> call = vehApiService.getVehicles();

        //On Response either load vehicles to list or display error
        call.enqueue(new Callback<VehicleResponse>() {
            @Override
            public void onResponse(Call<VehicleResponse> call, Response<VehicleResponse> response) {
                final List<Vehicle> vehicles = response.body().getResults();
                recyclerView.setAdapter(new VehicleAdapter(vehicles, R.layout.vehicle_row, getApplicationContext(),
                        new OnVehicleClickListener() {
                            @Override
                            public void onVehicleClick(Vehicle veh) {
                                gotoDetailsView(veh);
                            }
                        }));
            }

            @Override
            public void onFailure(Call<VehicleResponse> call, Throwable throwable) {
                Toast.makeText(getApplicationContext(), R.string.error_noConnection, Toast.LENGTH_LONG).show();
            }
        });
    }

    //* The action when user presses on a vehicle row*/
    private void gotoDetailsView(Vehicle veh) {
        //Goto Detail screen - passing selected vehicle in as bundle
        Intent vehIntent = new Intent(this, DetailActivity.class);
        Bundle vehBundle = new Bundle();
        vehBundle.putSerializable("veh", veh);
        vehIntent.putExtra("veh", veh);
        startActivity(vehIntent);
    }
}
