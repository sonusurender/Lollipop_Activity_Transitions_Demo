package com.activitytransitions_demo;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sonu on 06/08/16.
 */
public class DetailsActivity extends AppCompatActivity {

    public final static String ID = "ID";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity_layout);

        User mUser = User.getItem(getIntent().getIntExtra(ID, 0));// Get User from Intent

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//Setting back navigation button

        //Find all views
        View mCircle = findViewById(R.id.details_circle);
        TextView mName = (TextView) findViewById(R.id.details_name);
        TextView mPhone = (TextView) findViewById(R.id.details_phone);
        TextView mEmail = (TextView) findViewById(R.id.details_email);
        TextView mCity = (TextView) findViewById(R.id.details_city);

        //set user data on text view
        mName.setText(mUser.get(User.Field.NAME));
        mPhone.setText(mUser.get(User.Field.PHONE));
        mEmail.setText(mUser.get(User.Field.EMAIL));
        mCity.setText(mUser.get(User.Field.CITY));

        //Set color to Circle View
        GradientDrawable bgShape = (GradientDrawable) mCircle.getBackground();
        bgShape.setColor(Color.parseColor(mUser.get(User.Field.COLOR)));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();//Call back press method on back Navigation button click
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
