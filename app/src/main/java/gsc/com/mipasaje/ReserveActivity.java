package gsc.com.mipasaje;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class ReserveActivity extends AppCompatActivity {

    private Context context = null;
    private String m_companyString = null;
    private TextView m_lbCompanyName = null;
    private Spinner m_spOrigin = null;
    private Spinner m_spDestination = null;
    private  Button m_btnContinue = null;
    private  Button m_btnDateChoose = null;
    private Button m_btnTimeChoose = null;

    private DatePickerDialog m_DatePicker = null;
    private TimePickerDialog m_TimePicker = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        context = this;

        Intent intent = getIntent();
        m_companyString = intent.getStringExtra("companyname");

        m_lbCompanyName = (TextView) findViewById(R.id.lb_company_name);
        m_lbCompanyName.setText(m_companyString);

        m_spOrigin = (Spinner) findViewById(R.id.sp_origin);
        ArrayAdapter<CharSequence> originAdapter = ArrayAdapter.createFromResource(this,
                R.array.cities_array, android.R.layout.simple_spinner_item);
        originAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        m_spOrigin.setAdapter(originAdapter);

        m_spDestination = (Spinner) findViewById(R.id.sp_destination);
        ArrayAdapter<CharSequence> destinationAdapter = ArrayAdapter.createFromResource(this,
                R.array.cities_array, android.R.layout.simple_spinner_item);
        destinationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        m_spDestination.setAdapter(destinationAdapter);

        m_btnContinue = (Button) findViewById(R.id.btn_continue);
        m_btnContinue.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v)
            {
                startActivity(new Intent(context, BusLayoutActivity.class));
            }
        });

        Calendar newCalendar = Calendar.getInstance();
        m_DatePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                Calendar newDate = Calendar.getInstance();
//                newDate.set(year, monthOfYear, dayOfMonth);
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        m_TimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                //eReminderTime.setText( ""+selectedHour + ":" + selectedMinute);
                //Log.d(new Integer(selectedHour).toString(), new Integer(selectedMinute).toString());
            }
        }, newCalendar.get(Calendar.HOUR_OF_DAY), newCalendar.get(Calendar.MINUTE), true);

        m_btnDateChoose = (Button) findViewById(R.id.btn_date_choose);
        m_btnDateChoose.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v)
            {
                m_DatePicker.show();
            }
        });

        m_btnTimeChoose = (Button) findViewById(R.id.btn_time_choose);
        m_btnTimeChoose.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v)
            {
                m_TimePicker.show();
            }
        });

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_reserve, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
