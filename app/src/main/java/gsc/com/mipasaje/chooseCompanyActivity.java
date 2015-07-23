package gsc.com.mipasaje;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class chooseCompanyActivity extends AppCompatActivity {

    private Button btn_company1 = null;
    private Button btn_company2 = null;
    private Button btn_company3 = null;
    private Button btn_company4 = null;

    Context context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_company);

        context = this;

        btn_company1 = (Button) findViewById(R.id.btn_company1);
        btn_company1.setOnClickListener(new Button.OnClickListener(){
            public  void onClick(View v)
            {
                Intent intent = new Intent(context, ReserveActivity.class);
                intent.putExtra("companyname", "Company1");
                startActivity(intent);
            }
        });

        btn_company2 = (Button) findViewById(R.id.btn_company2);
        btn_company2.setOnClickListener(new Button.OnClickListener(){
            public  void onClick(View v)
            {
                Intent intent = new Intent(context, ReserveActivity.class);
                intent.putExtra("companyname", "Company2");
                startActivity(intent);
            }
        });

        btn_company3 = (Button) findViewById(R.id.btn_company3);
        btn_company3.setOnClickListener(new Button.OnClickListener(){
            public  void onClick(View v)
            {
                Intent intent = new Intent(context, ReserveActivity.class);
                intent.putExtra("companyname", "Company3");
                startActivity(intent);
            }
        });

        btn_company4 = (Button) findViewById(R.id.btn_company4);
        btn_company4.setOnClickListener(new Button.OnClickListener(){
            public  void onClick(View v)
            {
                Intent intent = new Intent(context, ReserveActivity.class);
                intent.putExtra("companyname", "Company4");
                startActivity(intent);
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_choose_company, menu);
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
