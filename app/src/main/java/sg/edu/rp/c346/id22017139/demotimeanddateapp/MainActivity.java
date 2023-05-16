package sg.edu.rp.c346.id22017139.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textView);
        resetBtn = findViewById(R.id.resetBtn);



        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySelectedTime();
                int hour = tp.getCurrentHour();
                int minute = tp.getCurrentMinute();

                String time = String.format(Locale.getDefault(), "Time is %02d:%02d", hour, minute);
                tvDisplay.setText(time);
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySelectedDate();

                    int day = dp.getDayOfMonth();
                    int month = dp.getMonth() + 1;
                    int year = dp.getYear();

                    String date = String.format(Locale.getDefault(), "%02d-%02d-%d", day, month, year);
                    tvDisplay.setText(date);
            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reset DatePicker
                DatePicker datePicker = findViewById(R.id.datePicker);
                Calendar calendar = Calendar.getInstance();
                calendar.set(2020, Calendar.JANUARY, 1);
                datePicker.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

                // Reset TimePicker
                TimePicker timePicker = findViewById(R.id.timePicker);
                timePicker.setCurrentHour(0);
                timePicker.setCurrentMinute(0);
            }
        });
    }

    private void displaySelectedTime() {

    }
    private void displaySelectedDate() {

        }
}