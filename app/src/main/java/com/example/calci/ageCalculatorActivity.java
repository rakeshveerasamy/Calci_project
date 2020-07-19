package com.example.calci;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class ageCalculatorActivity extends AppCompatActivity  {
    private int presentYear;
    private int presentMonth;
    private int presentDay;

    private ageCalculator calculate = null;

    private String birthDay;

    private TextView present;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_age_calculator);

        calculate = new ageCalculator();

        //Print current date
        presentDay = calculate.getpresentDay();
        presentMonth = calculate.getpresentMonth();
        presentYear = calculate.getpresentYear();


        TextView present = (TextView) findViewById(R.id.todayView);
        present.setText("Today is " + Integer.toString(presentMonth) + "/" + Integer.toString(presentDay) + "/" +
                Integer.toString(presentYear));
    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    //Pick out birthday
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar birthdate = Calendar.getInstance();
            int birthYear = birthdate.get(Calendar.YEAR);
            int birthMonth = birthdate.get(Calendar.MONTH);
            int birthDay = birthdate.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, birthYear, birthMonth, birthDay);
        }

        public void onDateSet(DatePicker view, int birthYear, int birthMonth, int birthDay) {
            // Put date in text
            TextView birthdayView = (TextView) getActivity().findViewById(R.id.birthdayView);
            birthdayView.setText((view.getMonth() + 1) + "/" + view.getDayOfMonth() + "/" + view.getYear());
        }

    }

    public void birthdayCalculations(View v){

        //Get birthday from TextView
        TextView copy = (TextView) findViewById(R.id.birthdayView);
        birthDay = copy.getText().toString();

        if (copy.getText().toString().trim().length() == 0){
            Toast.makeText(getApplicationContext(),"Invalid birthday",Toast.LENGTH_SHORT).show();
        } else {

            //Get results
            calculate.birthdayNumber(birthDay);

            calculate.diffYear();
            calculate.diffMonth();
            calculate.diffDay();

            present = (TextView) findViewById(R.id.resultView);
            present.setText("Your are\n"+ calculate.getResult());

        }
    }
}
