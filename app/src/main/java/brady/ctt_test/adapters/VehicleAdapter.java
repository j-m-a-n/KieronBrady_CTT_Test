package brady.ctt_test.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import brady.ctt_test.R;
import brady.ctt_test.interfaces.OnVehicleClickListener;
import brady.ctt_test.models.Vehicle;

/**
 * Created by kieronbrady on 04/11/2018.
 */

/** The adapter for a recyclerview to display the vehicle name*/
public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.vehicleHolder> {
    private List<Vehicle> vehicles;
    private int rowLayout;
    private Context context;
    private OnVehicleClickListener listener;

    public VehicleAdapter(List<Vehicle> vehicles, int rowLayout, Context context, OnVehicleClickListener listener) {
        this.vehicles = vehicles;
        this.rowLayout = rowLayout;
        this.context = context;
        this.listener = listener;
    }

    /** Standard ViewHolder class to get references to the views*/
    public static class vehicleHolder extends RecyclerView.ViewHolder {
        LinearLayout vehicleRowLayout;
        TextView vehicleVRN;

        public vehicleHolder(View v) {
            super(v);
            vehicleRowLayout = (LinearLayout) v.findViewById(R.id.llyVehicleRowLayout);
            vehicleVRN = (TextView) v.findViewById(R.id.txtVehicleRowVehicleVRN);
        }
    }

    @Override
    public VehicleAdapter.vehicleHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new vehicleHolder(view);
    }

    @Override
    public void onBindViewHolder(vehicleHolder holder, final int position) {
        Vehicle veh = vehicles.get(position);
        holder.vehicleVRN.setText(vehicles.get(position).getVrn());
        holder.vehicleVRN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onVehicleClick(vehicles.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        if (vehicles == null)
            return 0;
        else
            return vehicles.size();
    }
}
