package com.project.mednudge;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddEditMedicine extends Fragment implements View.OnClickListener {
Button alarm;
    FragmentTransaction fragmentTransaction;
    Fragment fragment;
    Toolbar toolbar;
    DatabaseReference mDatabase;
    EditText editMedicineName;
    EditText editPrescribedBy;
    EditText editDose;
    Spinner editUnit;
    RadioGroup editInstruction;
    RadioButton instruction1;
    EditText editRemark;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_add_edit_medicine, container, false);
        alarm=(Button) view.findViewById(R.id.button);
        alarm.setOnClickListener(this);
        toolbar=(Toolbar)view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Add Medicine");
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDatabase = FirebaseDatabase.getInstance().getReference("medicines");
        editMedicineName=(EditText)view.findViewById(R.id.medicine_name);
        editPrescribedBy=(EditText)view.findViewById(R.id.prescribed_by);
        editDose=(EditText)view.findViewById(R.id.edit_dose);
        editUnit=(Spinner)view.findViewById(R.id.select_unit);
        editInstruction=(RadioGroup)view.findViewById(R.id.instruction);
        editRemark=(EditText)view.findViewById(R.id.remark);
        return view;


    }
    public void onClick(View v)
    {
        ImageView medicineImage=null;
        String medicineName = editMedicineName.getText().toString().trim();
        String prescribedBy = editPrescribedBy.getText().toString().trim();
        String dose=editDose.getText().toString().trim()+" "+editUnit.getSelectedItem().toString();
        int selectedId = editInstruction.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        instruction1 = (RadioButton) view.findViewById(selectedId);
        String instruction=(String)instruction1.getText();
        String remark=editRemark.getText().toString().trim();



// Creating new user node, which returns the unique key value
// new user node would be /users/$userid/
        String medicineId = mDatabase.push().getKey();

// creating user object
        Medicine medicine = new Medicine(medicineId,medicineImage,medicineName,prescribedBy,dose,instruction,remark);

// pushing user to 'users' node using the userId
        mDatabase.child(medicineId).setValue(medicine);
        Toast.makeText(getContext(),"Medicine Added",Toast.LENGTH_SHORT);
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragment = new Alarm();//the fragment you want to show
        fragmentTransaction.replace(R.id.content_frame, fragment);//R.id.content_frame is the layout you want to replace
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}
