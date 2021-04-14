package com.example.bandarimidt2;

        import androidx.appcompat.app.AppCompatActivity;
        import android.content.Intent;
        import android.database.Cursor;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class DBAccess2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBHelper dbHelper=new DBHelper(this);
        setContentView(R.layout.activity_d_b_access2);
        setTitle("You are in Activity3");

        Button go1=findViewById(R.id.btn_go_3act1);
        Button go2=findViewById(R.id.btn_go_3act2);

        Button delete=findViewById(R.id.btn_delete);
        Button select=findViewById(R.id.btn_select);

        EditText inp_iqama=findViewById(R.id.inp_iqama);
        EditText inp_name=findViewById(R.id.inp_name);


        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c=dbHelper.getResult(inp_name.getText()+"");

                if (c==null){
                    Toast.makeText(DBAccess2.this,"There is no such record.",Toast.LENGTH_SHORT).show();
                    return;
                }
                String message= c.getInt(0)+" "+
                        c.getString(1)+" "+
                        c.getString(2)+" "+
                        c.getString(3)+" "+
                        c.getString(4)+" ";

                Toast.makeText(DBAccess2.this,"Record found: "+message,Toast.LENGTH_LONG).show();



            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.delete(inp_iqama.getText()+"");
            }
        });

        go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DBAccess2.this,Intro.class));
            }
        });
        go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DBAccess2.this,DBAccess.class));
            }
        });


    }
}