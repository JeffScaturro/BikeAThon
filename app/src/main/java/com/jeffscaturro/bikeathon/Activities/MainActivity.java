package com.jeffscaturro.bikeathon.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.jeffscaturro.bikeathon.Activities.Fragments.ItemFragment;
import com.jeffscaturro.bikeathon.R;

import java.util.Locale;


public class MainActivity extends ActionBarActivity implements ActionBar.TabListener, ItemFragment.OnFragmentInteractionListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the action bar.
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//        actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.baby_blue));
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setStackedBackgroundDrawable(getResources().getDrawable(R.color.blue));

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return false;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    public void onFragmentInteraction(String id) {
        // Nada
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter  {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
           return position == 0 ? PlaceholderFragment.newInstance() : PickDayFragment.newInstance();
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.home_header).toUpperCase(l);
                case 1:
                    return getString(R.string.sign_up_header).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

//        static ArrayList<Drawable> mImages;
        static int[] mImages;
        static ImageView mImageView;
        static int photoIndex;

        Button mPreviousButton;
        Button mNextButton;

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance() {
            return new PlaceholderFragment();
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            mImages = new int[] { R.drawable.pkp_ability_experience_logo, R.drawable.img_two, R.drawable.img_three, R.drawable.img_four, R.drawable.img_one, R.drawable.img_five };

            photoIndex = 0;
            mImageView = (ImageView)rootView.findViewById(R.id.image);
            mImageView.setImageResource(mImages[photoIndex]);

            mPreviousButton = (Button)rootView.findViewById(R.id.previous_button);
            mPreviousButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    previousPhoto();
                }
            });

            mNextButton = (Button)rootView.findViewById(R.id.next_button);
            mNextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nextPhoto();
                }
            });

            return rootView;
        }

        public void previousPhoto() {
            photoIndex--;
            if (photoIndex < 0)
                photoIndex = 5;
            mImageView.setImageResource(mImages[photoIndex]);
        }

        public void nextPhoto() {
            photoIndex++;
            if (photoIndex > 5)
                photoIndex = 0;
            mImageView.setImageResource(mImages[photoIndex]);
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PickDayFragment extends Fragment {

        public static String mUser;
        public static String mUserOrgStr;

        EditText mUserName;
        EditText mUserOrg;
        Button mShowDays;
        Button march24th;
        Button march25th;
        Button march26th;

        public static PickDayFragment newInstance() {
            return new PickDayFragment();
        }

        public PickDayFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_pick_day, container, false);

            rootView.findViewById(R.id.day_selection).setVisibility(View.VISIBLE);
            getActivity().getSupportFragmentManager().popBackStack();

            mUserName = (EditText)rootView.findViewById(R.id.users_name);
            mUserName.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {}

                @Override
                public void afterTextChanged(Editable s) {
                    mUser = s.toString();
                }
            });
            mUserName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    mUserName.setCursorVisible(hasFocus);
                    if (hasFocus) {
                        mUserName.requestFocus();
                    } else {
                        mUserName.clearFocus();
                    }
                }
            });

            mUserOrg = (EditText)rootView.findViewById(R.id.users_org);
            mUserOrg.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {}

                @Override
                public void afterTextChanged(Editable s) {
                    mUserOrgStr = s.toString();
                }
            });
            mUserOrg.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    mUserOrg.setCursorVisible(hasFocus);
                    if (hasFocus) {
                        mUserOrg.requestFocus();
                    } else {
                        mUserOrg.clearFocus();
                    }
                }
            });

            mShowDays = (Button)rootView.findViewById(R.id.show_days);
            mShowDays.setVisibility(View.GONE);
            mShowDays.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rootView.findViewById(R.id.day_selection).setVisibility(View.VISIBLE);
                    mShowDays.setVisibility(View.GONE);
                    getActivity().getSupportFragmentManager()
                            .popBackStack();
                }
            });

            march24th = (Button)rootView.findViewById(R.id.march24thButton);
            march24th.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rootView.findViewById(R.id.day_selection).setVisibility(View.INVISIBLE);
                    mShowDays.setVisibility(View.VISIBLE);
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .addToBackStack("ItemFragment")
                            .add(R.id.fragment_container, ItemFragment.newInstance("March 24th, 2015"))
                            .commit();
                }
            });

            march25th = (Button)rootView.findViewById(R.id.march25thButton);
            march25th.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rootView.findViewById(R.id.day_selection).setVisibility(View.INVISIBLE);
                    mShowDays.setVisibility(View.VISIBLE);
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .addToBackStack("ItemFragment")
                            .add(R.id.fragment_container, ItemFragment.newInstance("March 25th, 2015"))
                            .commit();
                }
            });

            march26th = (Button)rootView.findViewById(R.id.march26thButton);
            march26th.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rootView.findViewById(R.id.day_selection).setVisibility(View.INVISIBLE);
                    mShowDays.setVisibility(View.VISIBLE);
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .addToBackStack("ItemFragment")
                            .add(R.id.fragment_container, ItemFragment.newInstance("March 26th, 2015"))
                            .commit();
                }
            });

            return rootView;
        }

        public static String getUser() {
            return mUser;
        }

        public static String getUserOrg() {
            return mUserOrgStr;
        }
    }

    @Override
    public void onBackPressed() {
        if (findViewById(R.id.day_selection).getVisibility() == View.INVISIBLE) {
            findViewById(R.id.day_selection).setVisibility(View.VISIBLE);
            findViewById(R.id.show_days).setVisibility(View.GONE);
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
