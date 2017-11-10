package com.project.mednudge;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class PatientProfile extends Fragment implements View.OnClickListener{
    Toolbar toolbar;
    Fragment fragment;
    FragmentTransaction fragmentTransaction;
        private Boolean isFabOpen = false;
    private FloatingActionButton fab,fab1,fab2,fab3;
    private Animation fab_open,fab_close,rotate_forward,rotate_backward;
View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_patient_profile, container, false);
        fab = (FloatingActionButton)view.findViewById(R.id.fab);
        fab1 = (FloatingActionButton)view.findViewById(R.id.fab1);
        fab2 = (FloatingActionButton)view.findViewById(R.id.fab2);
        fab3 = (FloatingActionButton)view.findViewById(R.id.fab3);
        fab_open = AnimationUtils.loadAnimation(inflater.getContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(inflater.getContext(),R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(inflater.getContext(),R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(inflater.getContext(),R.anim.rotate_backward);
        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);
        toolbar=(Toolbar)view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("MedNudge");
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        return view;

    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fab:

                animateFAB();
                break;
            case R.id.fab1:
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragment = new History();//the fragment you want to show
                fragmentTransaction.replace(R.id.content_frame, fragment);//R.id.content_frame is the layout you want to replace
                fragmentTransaction.commit();

                break;
            case R.id.fab2:

                fragmentTransaction = getFragmentManager().beginTransaction();
                fragment = new AddEditMedicine();//the fragment you want to show
                fragmentTransaction.replace(R.id.content_frame, fragment);//R.id.content_frame is the layout you want to replace
                fragmentTransaction.commit();
                break;
            case R.id.fab3:

                fragmentTransaction = getFragmentManager().beginTransaction();
                fragment = new Prescription();//the fragment you want to show
                fragmentTransaction.replace(R.id.content_frame, fragment);//R.id.content_frame is the layout you want to replace
                fragmentTransaction.commit();
                break;
        }
    }

    public void animateFAB(){

        if(isFabOpen){

            fab.startAnimation(rotate_backward);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab3.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            fab3.setClickable(false);
            isFabOpen = false;


        } else {

            fab.startAnimation(rotate_forward);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab3.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            fab3.setClickable(true);
            isFabOpen = true;


        }
    }
}


