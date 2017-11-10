package com.project.mednudge;

import android.widget.ImageView;

/**
 * Created by MEGHA on 09-11-2017.
 */

public class Medicine {
    ImageView medicineImage;
    String medicineId;
    String medicineName;
    String doctorName;
    String dose;
    String instruction;
    String remark;
    public Medicine(){

    }
    public Medicine(String medicineId, ImageView medicineImage, String medicineName, String doctorName, String dose, String instruction, String remark)
    {
        this.medicineId=medicineId;
        this.medicineImage=medicineImage;
        this.medicineName=medicineName;
        this.doctorName=doctorName;
        this.dose=dose;
        this.instruction=instruction;
        this.remark=remark;
    }
    public String getMedicineId()
    {
        return medicineId;
    }
public ImageView getMedicineImage()
{
    return medicineImage;
}
public String getMedicineName()
{
    return medicineName;
}
public String getDoctorName()
{
    return doctorName;
    }
    public String getDose()
    {
        return dose;
    }
    public String getInstruction()
    {
        return instruction;
    }
    public String getRemark()
    {
        return remark;
    }

}
