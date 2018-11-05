package brady.ctt_test.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import brady.ctt_test.R;
import brady.ctt_test.models.Vehicle;

/**
 * Created by kieronbrady on 04/11/2018.
 */
public class DetailActivity extends AppCompatActivity {

    private TextView vehId = null;
    private TextView vehVRN = null;
    private TextView vehCountry = null;
    private TextView vehColor = null;
    private TextView vehType = null;
    private CheckBox vehDefault = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_detail);
        vehId = (TextView) findViewById(R.id.txtVehicleDetailId);
        vehVRN = (TextView) findViewById(R.id.txtVehicleDetailVRN);
        vehCountry = (TextView) findViewById(R.id.txtVehicleDetailCountry);
        vehColor = (TextView) findViewById(R.id.txtVehicleDetailColor);
        vehType = (TextView) findViewById(R.id.txtVehicleDetailType);
        vehDefault = (CheckBox) findViewById(R.id.chkVehicleDetailDefault);

        //Ensure bundle passed in holds a vehicle - if so, load details
        try {
            Bundle vehDetails = getIntent().getExtras();
            Vehicle veh = null;

            if (vehDetails != null) {
                veh = (Vehicle) vehDetails.getSerializable("veh");
                if (veh != null)
                    loadDetails(veh);
            }
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), R.string.error_noVehicleDetails, Toast.LENGTH_LONG).show();
        }
    }


    private void loadDetails(Vehicle veh) {
        vehId.setText(String.valueOf(veh.getVehicleId()));
        vehVRN.setText(veh.getVrn());
        vehCountry.setText(veh.getCountry());
        vehColor.setText(veh.getColor());
        vehType.setText(veh.getType());
        vehDefault.setChecked(veh.isDefault());
    }
}
