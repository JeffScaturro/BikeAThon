package com.jeffscaturro.bikeathon.Activities.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.view.Gravity;
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

import com.android.volley.*;
import com.android.volley.toolbox.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;


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
            toastMe("We have not finished loading all the bikers...");
            return;
        }

        try {
            String pattern = "dd-MM-yyyy HH:mm:ss";
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            Date mustBePassed = dateFormat.parse("16-03-2016 12:00:00");

            Date now = new Date();

            if (now.compareTo(mustBePassed) < 0) {
                toastMe("Registration is not yet open...");
                return;
            }
        } catch(java.text.ParseException e) {
            toastMe("Error checking if registration is open, try again.");
            return;
        }

        // If user has not set their name, do nothing.
        final String user = MainActivity.PickDayFragment.getUser();
        if (user == null || user.trim().equals("")) {
            toastMe("Please set your name above before registering.");
            return;
        }

        final String userOrg = MainActivity.PickDayFragment.getUserOrg();
        if (userOrg == null || userOrg.trim().equals("")) {
            toastMe("Please set your organization above before registering.");
            return;
        }

        final ArrayList<Bike> bikeRiders = mTimeSlots.get(position).getBikes();

        final ArrayAdapter<Integer> availableSlots = new ArrayAdapter<>(getActivity(), R.layout.bike_dropdown_item);

        // Do nothing if we have not loaded all the bike information.
        if (bikeRiders == null) {
            toastMe("We have not finished loading all the bikers...");
            return;
        }

        AlertDialog.Builder builderSingle = new AlertDialog.Builder(getActivity())
            .setIcon(R.drawable.ic_launcher)
            .setTitle("Please Confirm")
            .setMessage("Are you sure you want to sign up for " + mDayName + " at " + mTimeSlots.get(position).getString("time") + "?")
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    for (int i = 0; i < bikeRiders.size(); i++) {

                        if (bikeRiders.get(i).getOpen()) {
                            final Bike chosenBike = bikeRiders.get(i);

                            chosenBike.setRiderName(user);
                            chosenBike.setRiderOrg(userOrg);
                            chosenBike.setRidingDay(mDayName);
                            chosenBike.setRidingTime(mTimeSlots.get(position).getString("time"));
                            try {

                                chosenBike.save();
                                mTimeSlots.get(position).save();
                                mDay.save();
                                refreshData();

                                try {
                                    postToGoogleSheets(user, userOrg, mDayName, mTimeSlots.get(position).getString("time"));
                                } catch (Exception e) {

                                }

                                AlertDialog.Builder builderDouble = new AlertDialog.Builder(getActivity())
                                        .setIcon(R.drawable.ic_launcher)
                                        .setTitle("Success!")
                                        .setMessage("You are now signed up to ride on " + mDayName + " at " + mTimeSlots.get(position).getString("time") + "!")
                                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                            }
                                        });
                                builderDouble.create().show();

                            } catch (ParseException e) {
                                toastMe("There was an error signing you up for that spot.");
                            }
                            dialog.dismiss();
                            return;
                        }
                    }
                }
            })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

           /* .setAdapter(availableSlots, new DialogInterface.OnClickListener() {
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
                                        toastMe("There was an error signing you up for that spot.");
                                    }
                                    dialog.dismiss();
                                }
                            })
                            .show();
                }
            });*/
        builderSingle.create().show();
    }

    public void postToGoogleSheets(final String pName, final String pOrg, final String pDay, final String pTime) throws NetworkOnMainThreadException {

        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());

        final String url = "https://docs.google.com/forms/d/1HreENUdtNIwo8Y8Lq2JSlbmk8HVbaHweM2ZpmcydJIE/formResponse";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("entry.877086558", pName);
                params.put("entry.1498135098", pOrg);
                params.put("entry.1424661284", pDay);
                params.put("entry.2606285", pTime);
                params.put("submit", "Submit");

                return params;
            }
        };
        queue.add(postRequest);
    }

    public void toastMe(String text) {
        Toast toast = Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 144);
        toast.show();
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

                    if (getActivity() == null) {
                        return;
                    }

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
