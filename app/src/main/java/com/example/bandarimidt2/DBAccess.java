package com.example.bandarimidt2;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.database.Cursor;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

public class DBAccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_b_access);

        setTitle("You are in Activity2");

        Button go1=findViewById(R.id.btn_go_2act1);
        Button go3=findViewById(R.id.btn_go_2act3);

        go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DBAccess.this,Intro.class));
            }
        });
        go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DBAccess.this,DBAccess2.class));
            }
        });


        Button select_1=findViewById(R.id.btn_read_first_row);
        Button del_1=findViewById(R.id.btn_del_first_row);
        TextView out_row_1=findViewById(R.id.out_first_row);

        DBHelper dbHelper=new DBHelper(this);

        select_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c=dbHelper.getFirstRow();
                if (c==null){
                    Toast.makeText(DBAccess.this,"No data to read.",Toast.LENGTH_SHORT).show();
                    return;
                }
                out_row_1.setText(c.getInt(0)+" "+
                        c.getString(1)+" "+
                        c.getString(2)+" "+
                        c.getString(3)+" "+
                        c.getString(4)+" ");

            }
        });
        del_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteFirstRow();
                Toast.makeText(DBAccess.this,"Successfully deleted first row",Toast.LENGTH_SHORT).show();
            }
        });

    }
}