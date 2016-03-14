package com.jeffscaturro.bikeathon.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jeffscaturro.bikeathon.Models.TimeSlot;
import com.jeffscaturro.bikeathon.R;

import java.util.List;

public class TimeSlotAdapter extends ArrayAdapter<TimeSlot> {

    public TimeSlotAdapter(Context context, int resource, List<TimeSlot> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {

            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.time_slot_row, null);

        }

        TimeSlot timeSlot = getItem(position);

        if (timeSlot != null) {

            TextView timeLabel = (TextView) v.findViewById(R.id.time_label);
            TextView bikesOpen = (TextView) v.findViewById(R.id.bikes_open);

            if (timeLabel != null) {
                timeLabel.setText(timeSlot.getTime());
            }

            if (bikesOpen != null) {
                timeSlot.checkAvailability();
                if (timeSlot.doesHasOpenBike()) {
                    bikesOpen.setText("Bikes Available!");
                    bikesOpen.setTextColor(Color.parseColor("#00FF00"));
                    v.setBackground(getContext().getResources().getDrawable(R.color.blue));
                } else {
                    bikesOpen.setText("No Bikes Available");
                    bikesOpen.setTextColor(Color.RED);
                    v.setBackground(getContext().getResources().getDrawable(R.color.blue));
                }
            }
        }

        return v;

    }
}