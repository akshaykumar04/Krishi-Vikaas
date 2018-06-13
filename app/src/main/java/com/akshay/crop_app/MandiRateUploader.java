package com.akshay.crop_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.akshay.crop_app.services.Rates;
import com.akshay.crop_app.services.Users;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MandiRateUploader extends AppCompatActivity {

    Button BTNuploadDB;
    EditText Cname, Crate, Cplace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_rate);

        Cname = (EditText) findViewById(R.id.crop_name);
        Crate = (EditText) findViewById(R.id.c_rate);
        Cplace = (EditText) findViewById(R.id.c_place);
        BTNuploadDB = (Button)findViewById(R.id.mandi_btn);

        BTNuploadDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upload_rate();
            }
        });

    }




    public void upload_rate() {
        String crop_name = Cname.getText().toString().trim();
        String crop_rate = Crate.getText().toString().trim();
        String crop_place = Cplace.getText().toString();

        Rates rates = new Rates(crop_name, crop_rate, crop_place);
        //FirebaseDatabase database = FirebaseDatabase.getInstance().getReference().child("user");
        DatabaseReference mdatabse = FirebaseDatabase.getInstance().getReference("MandiRates");
        String userId = mdatabse.push().getKey();
        mdatabse.child(userId).setValue(rates);
        Cname.setText("");
        Crate.setText("");
        Cplace.setText("");
        Toast.makeText(this,"new rate uploaded successfully",Toast.LENGTH_LONG).show();


    }
}
