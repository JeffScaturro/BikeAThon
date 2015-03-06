package com.jeffscaturro.bikeathon.Activities.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.jeffscaturro.bikeathon.Activities.MainActivity;
import com.jeffscaturro.bikeathon.Adapters.TimeSlotAdapter;
import com.jeffscaturro.bikeathon.Models.Bike;
import com.jeffscaturro.bikeathon.Models.Day;
import com.jeffscaturro.bikeathon.Models.TimeSlot;
import com.jeffscaturro.bikeathon.R;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
public class ItemFragment extends android.support.v4.app.ListFragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String DAY_PARAM = "param1";

    private String mDayName;
    private Day mDay;
    TimeSlotAdapter mTimeSlotAdapter;
    private ArrayList<TimeSlot> mTimeSlots;
    private boolean doneLoading = false;

    private OnFragmentInteractionListener mListener;

    public static ItemFragment newInstance(String param1) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putString(DAY_PARAM, param1);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mDayName = getArguments().getString(DAY_PARAM);
        }

        refreshData();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        mTimeSlotAdapter = null;
    }

    @Override
    public void onListItemClick(ListView l, View v, final int position, long id) {
        super.onListItemClick(l, v, position, id);

        // Do nothing if we have not received all the time slots.
        if (!doneLoading) {
            Toast.makeText(getActivity(), "We have not finished loading all the bikers...", Toast.LENGTH_SHORT).show();
            return;
        }

        // If user has not set their name, do nothing.
        final String user = MainActivity.PickDayFragment.getUser();
        if (user == null || user.trim().equals("")) {
            Toast.makeText(getActivity(), "Please set your name above before registering.", Toast.LENGTH_SHORT).show();
            return;
        }

        final String userOrg = MainActivity.PickDayFragment.getUserOrg();
        if (userOrg == null || userOrg.trim().equals("")) {
            Toast.makeText(getActivity(), "Please set your organization above before registering.", Toast.LENGTH_SHORT).show();
            return;
        }

        final ArrayList<Bike> bikeRiders = mTimeSlots.get(position).getBikes();

        final ArrayAdapter<Integer> availableSlots = new ArrayAdapter<>(getActivity(), R.layout.bike_dropdown_item);

        // Do nothing if we have not loaded all the bike information.
        if (bikeRiders == null) {
            Toast.makeText(getActivity(), "We have not finished loading all the bikers...", Toast.LENGTH_SHORT).show();
            return;
        }

        for (int i = 0; i < bikeRiders.size(); i++) {
            if (bikeRiders.get(i).getRiderName().trim().equals("")) {
                availableSlots.add((i + 1));
            }
        }

        if (availableSlots.getCount() == 0) {
            Toast.makeText(getActivity(), "No open bikes for that slot, find one that does!", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.i("ItemFragment", "Riders: " + availableSlots);
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(getActivity())
            .setIcon(R.drawable.ic_launcher)
            .setTitle("Select a Bike")
            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            })
            .setAdapter(availableSlots, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String strName = availableSlots.getItem(which).toString();
                    final Bike chosenBike = mTimeSlots.get(position).getBikes().get(availableSlots.getItem(which) - 1);
                    AlertDialog.Builder builderInner = new AlertDialog.Builder(getActivity());
                    builderInner.setMessage(strName);
                    builderInner.setTitle("Signing up " + user + " for Bike")
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setPositiveButton("Sign Up", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //TODO: Send data, updating Parse
                            chosenBike.setRiderName(user);
                            chosenBike.setRiderOrg(userOrg);
                            try {
                                chosenBike.save();
                                mTimeSlots.get(position).save();
                                mDay.save();
                                refreshData();
                            } catch (ParseException e) {
                                Toast.makeText(getActivity(), "There was an error signing you up for that spot.", Toast.LENGTH_SHORT).show();
                            }
                            dialog.dismiss();
                        }
                    })
                    .show();
                }
            });
            builderSingle.create().show();

        if (null != mListener) {
            // Notify the active callbacks interface (the activity, if the
            // fragment is attached to one) that an item has been selected.
//            mListener.onFragmentInteraction(DummyContent.ITEMS.get(position).id);
        }
    }

    public void refreshData() {
        ParseQuery<Day> query = ParseQuery.getQuery(Day.class);
        query.whereEqualTo("dayTitle", mDayName);
        query.include("timeSlots");
        query.include("timeSlots.bikes");
        query.getFirstInBackground(new GetCallback<Day>() {
            @Override
            public void done(Day day, ParseException e) {
                if (day == null) {
                    // Failed
                } else {
                    mDay = day;

                    mTimeSlots = mDay.getTimeSlots();
                    Log.i("Time", "Retrieved " + mTimeSlots.size() + " times");

                    mTimeSlotAdapter = new TimeSlotAdapter(getActivity(), R.layout.time_slot_row, mTimeSlots);
                    setListAdapter(mTimeSlotAdapter);

                    mTimeSlotAdapter.notifyDataSetChanged();
                    doneLoading = true;
                }
            }
        });

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String id);
    }

}
