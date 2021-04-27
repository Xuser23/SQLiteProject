package com.example.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sqliteproject.database.DBController;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

import java.util.HashMap;

public class AddFriendActivity extends AppCompatActivity {

    private TextInputEditText tNama,tTelpon;
    private Button simpanBtn;
    String nm,tlp;
    DBController controller = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        tNama = (TextInputEditText)findViewById(R.id.fr_name);
        tTelpon = (TextInputEditText)findViewById(R.id.fr_phone);
        simpanBtn = (Button)findViewById(R.id.btn_save);

        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tNama.getText().toString().equals("")||tTelpon.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"data belum komplit !",Toast.LENGTH_SHORT).show();
                }else{
                    nm = tNama.getText().toString();
                    tlp = tTelpon.getText().toString();

                    HashMap<String,String> qvalues = new HashMap<>();
                    qvalues.put("nama",nm);
                    qvalues.put("telpon",tlp);


                    controller.insertData(qvalues);
                    callHome();
                }
            }
        });
    }

    public void callHome(){
        Intent intent = new Intent(AddFriendActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
}