package com.example.bandarimidt2;

        import androidx.appcompat.app.AppCompatActivity;

        import android.app.DatePickerDialog;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
        import android.view.View;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.widget.Toast;

        import java.text.SimpleDateFormat;
        import java.util.Calendar;

public class Intro extends AppCompatActivity {


    public void showToastMessage(String text, int duration){
        final Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, duration);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        setTitle("You are in Activity1");
        Button pickDate=findViewById(R.id.btn_pick_date);
        Button act2=findViewById(R.id.btn_1go_act2);
        Button act3=findViewById(R.id.btn_1go_act3);

        act2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro.this,DBAccess.class));
            }
        });
        act3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intro.this,DBAccess2.class));
            }
        });


        final Calendar c= Calendar.getInstance();
        //Available patterns
        //https://developer.android.com/reference/java/text/SimpleDateFormat
        final SimpleDateFormat df=new SimpleDateFormat("E, M  d, Y");
        final DatePickerDialog.OnDateSetListener d= new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                c.set(Calendar.YEAR,year);
                c.set(Calendar.MONTH,month);
                c.set(Calendar.DAY_OF_MONTH,day);

                showToastMessage("You picked " +df.format(c.getTime()),5000);
            }
        };
        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Intro.this,d,
                        c.get(Calendar.YEAR),
                        c.get(Calendar.MONTH),
                        c.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });
    }
}