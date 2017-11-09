package com.project.mednudge;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class AddEditMedicine extends Fragment implements View.OnClickListener {
Button alarm;
    FragmentTransaction fragmentTransaction;
    Fragment fragment;
    Toolbar toolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_add_edit_medicine, container, false);
        alarm=(Button) view.findViewById(R.id.button);
        alarm.setOnClickListener(this);
        toolbar=(Toolbar)view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Add Medicine");
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return view;


    }
    public void onClick(View v)
    {
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragment = new Alarm();//the fragment you want to show
        fragmentTransaction.replace(R.id.content_frame, fragment);//R.id.content_frame is the layout you want to replace
        fragmentTransaction.commit();
    }


}
