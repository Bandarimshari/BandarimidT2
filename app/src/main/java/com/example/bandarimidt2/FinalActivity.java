package com.example.bandarimidt2;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageButton;
        import com.example.bandarimidt2.MainActivity.R;


public class FinalActivity extends AppCompatActivity {

    public ImageButton accomodation;


    public void init() {
        accomodation = (ImageButton) findViewById(R.id.AccomodationButton);
        accomodation.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent accomodation = new Intent(FinalActivity.this, Accomodation.class);

                startActivity(accomodation);


            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_page);

        init();
    }}