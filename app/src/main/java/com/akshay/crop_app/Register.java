package com.akshay.crop_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.akshay.crop_app.R;
import com.akshay.crop_app.services.Users;

public class Register extends AppCompatActivity implements View.OnClickListener {
    EditText name, Cemail, mobile, city, ward, address;
    Button CBtn, UBtn;
    ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        name = (EditText) findViewById(R.id.cname);
        Cemail = (EditText) findViewById(R.id.cemail);
        mobile = (EditText) findViewById(R.id.cmobile);
        ward = (EditText) findViewById(R.id.cwardNo);
        city = (EditText) findViewById(R.id.ccity);
        address = (EditText) findViewById(R.id.caddress);
        CBtn = (Button) findViewById(R.id.rBtn);

        CBtn.setOnClickListener(this);
        loading = new ProgressDialog(this);

    }

    @Override
    public void onClick(View v) {
        if (v == CBtn) {
            register();
        }

    }

    public void register() {
        String name1 = name.getText().toString().trim();
        String email1 = Cemail.getText().toString().trim();
        String mobile1 = mobile.getText().toString();
        String ward1 = ward.getText().toString().trim();
        String city1 = city.getText().toString().trim();
        String address1 = address.getText().toString();
        if (TextUtils.isEmpty(name1) || TextUtils.isEmpty(email1) || TextUtils.isEmpty(mobile1) || TextUtils.isEmpty(ward1) || TextUtils.isEmpty(city1) || TextUtils.isEmpty(address1)) {
            Toast.makeText(this, "Please fill up all the Fields", Toast.LENGTH_LONG).show();
            return;
        }
        loading.setMessage("registering user");
        loading.show();
        Users user = new Users(name1, email1, mobile1, ward1, city1, address1);
        //FirebaseDatabase database = FirebaseDatabase.getInstance().getReference().child("user");
        DatabaseReference mdatabse = FirebaseDatabase.getInstance().getReference("Users");
        String userId = mdatabse.push().getKey();
        mdatabse.child(userId).setValue(user);
        loading.dismiss();
        name.setText("");
        Cemail.setText("");
        mobile.setText("");
        ward.setText("");
        city.setText("");
        address.setText("");
        Toast.makeText(this,"New User is Registered successfully",Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, MainActivity.class));

    }

}