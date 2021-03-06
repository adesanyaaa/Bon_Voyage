package com.neilcastellino.bonvoyage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HotelSaintGermain extends AppCompatActivity {

    private TextView price,name;
    String pr, email,hname;
    private Button book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_activity_saint_germain);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name = (TextView) findViewById(R.id.hsg_name);
        price = (TextView) findViewById(R.id.hsg_price);
        pr=price.getText().toString();
        hname = name.getText().toString();

        Dashboard db = new Dashboard();
        email = db.getEmail();

        book = (Button)findViewById(R.id.hsg_btn);

        if (email == "ERROR") {
            Toast.makeText(getBaseContext(), "ERROR occurred!!!", Toast.LENGTH_LONG).show();
        } else {
            book.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(HotelSaintGermain.this, Date_andDay.class);
                    i.putExtra("email", email);
                    i.putExtra("price", pr);
                    i.putExtra("name", hname);
                    startActivity(i);
                }
            });
        }
    }

}
