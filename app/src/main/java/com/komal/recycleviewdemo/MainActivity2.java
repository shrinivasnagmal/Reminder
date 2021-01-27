package com.komal.recycleviewdemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener , View.OnClickListener , CompoundButton.OnCheckedChangeListener {
    EditText active_date, expiry_date;
    TextView txt1, txt2;
    Button BtSubmit;
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    DatePickerDialog.OnDateSetListener setListener;
    CheckBox extraCheckBox;
    Calendar calendar = Calendar.getInstance();
    final int year = calendar.get(Calendar.YEAR);
    final int month = calendar.get(Calendar.MONTH);
    final int day = calendar.get(Calendar.DAY_OF_MONTH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Spinner spinner = findViewById(R.id.spin);
        active_date = findViewById(R.id.active_date);
        expiry_date = findViewById(R.id.expiry_date);
        BtSubmit = findViewById(R.id.BtSubmit);
        extraCheckBox = findViewById(R.id.extraCheckBox);


        //Listeners
        BtSubmit.setOnClickListener(this);
        active_date.setOnClickListener(this);
        extraCheckBox.setOnCheckedChangeListener(this);


        //ArrayAdapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    @Override
    public void onClick(View view) {


        switch (view.getId()){

            case R.id.active_date:

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity2.this, new DatePickerDialog.OnDateSetListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {

                        month = month + 1;

                        String PickedDay = day>9?String.valueOf(day):"0"+day;
                        String PickedMonth = month>9?String.valueOf(month):"0"+month;
                        String date = year + "/" + PickedMonth + "/" + PickedDay;
                        active_date.setText(date);

                        Date PickedDate = null;
                        try {
                            PickedDate = format.parse(date);

                            if(PickedDate!=null){
                                calendar.setTime(PickedDate);
                                calendar.add(Calendar.DAY_OF_MONTH, 364);

                                if(extraCheckBox.isChecked()){
                                    calendar.add(Calendar.DAY_OF_MONTH, 15);
                                }

                                expiry_date.setText(format.format(calendar.getTime()));
                            }else {
                                Log.d("DateError","null");
                            }

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                    }
                }, year, month, day);
                datePickerDialog.show();
                break;
            case R.id.BtSubmit:

                Intent i = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i);
                break;

        }




    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            if(!active_date.getText().toString().trim().isEmpty()){

                Date PickedDate = null;
                if(b){
                    try {
                        PickedDate = format.parse(active_date.getText().toString().trim());

                        if(PickedDate!=null){
                            calendar.setTime(PickedDate);
                            calendar.add(Calendar.DATE, 379);
                            expiry_date.setText(format.format(calendar.getTime()));
                        }else {
                            Log.d("DateError","null");
                        }

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }else {

                    try {
                        PickedDate = format.parse(active_date.getText().toString().trim());

                        if(PickedDate!=null){
                            calendar.setTime(PickedDate);
                            calendar.add(Calendar.DATE, 364);
                            expiry_date.setText(format.format(calendar.getTime()));
                        }else {
                            Log.d("DateError","null");
                        }

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }



    }
}