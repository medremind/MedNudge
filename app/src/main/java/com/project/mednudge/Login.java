package com.project.mednudge;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Login extends Fragment implements View.OnClickListener {

    TextView textView;
    View view;
    Fragment fragment;
    FragmentTransaction fragmentTransaction;
    Button doctor;
    Button patient;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_login, container, false);
        textView=(TextView)view.findViewById(R.id.textView3);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragment = new DoctorPatientSignup();//the fragment you want to show
                fragmentTransaction.replace(R.id.content_frame, fragment);//R.id.content_frame is the layout you want to replace
                fragmentTransaction.commit();
            }
        });
        doctor=(Button)view.findViewById(R.id.button2);
        doctor.setOnClickListener(this);
        patient=(Button)view.findViewById(R.id.button3);
        patient.setOnClickListener(this);
        return view;
    }
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button2:  fragmentTransaction = getFragmentManager().beginTransaction();
                fragment = new DoctorProfile();//the fragment you want to show
                fragmentTransaction.replace(R.id.content_frame, fragment);//R.id.content_frame is the layout you want to replace
                fragmentTransaction.commit();
                break;
            case R.id.button3:  fragmentTransaction = getFragmentManager().beginTransaction();
                fragment = new PatientProfile();//the fragment you want to show
                fragmentTransaction.replace(R.id.content_frame, fragment);//R.id.content_frame is the layout you want to replace
                fragmentTransaction.commit();
                break;
        }
    }


}
