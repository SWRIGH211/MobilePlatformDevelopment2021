/*Scott Wright - S1708974 */
/* swrigh211@caledonian.ac.uk */

package com.example.scottwright_earthquakeapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;



public class EarthQuakeInfo extends AppCompatActivity implements View.OnClickListener {

    LinearLayout EarthQuakeInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquakeinfo);
        EarthQuakeInfo = (LinearLayout) findViewById(R.id.EarthQuakeInfo);
        Bundle bundle = getIntent().getExtras();


        TextView locationView = new TextView(EarthQuakeInfo.this);
        String locString = "Earthquake Location: " +bundle.getString("location");
        locationView.setText(locString);
        locationView.setTextColor((getColor(R.color.white)));
        locationView.setTextSize(20);
        locationView.setPadding(0,15,0,15);
        EarthQuakeInfo.addView(locationView);

        TextView longView = new TextView(EarthQuakeInfo.this);
        String longString = "Longitude: " + bundle.getString("geoLong");
        longView.setText(longString);
        longView.setTextColor((getColor(R.color.white)));
        longView.setTextSize(20);
        longView.setPadding(0,15,0,15);
        EarthQuakeInfo.addView(longView);

        TextView latView = new TextView(EarthQuakeInfo.this);
        String latString = "Latitude: " + bundle.getString("geoLat");
        latView.setText(latString);
        latView.setTextColor((getColor(R.color.white)));
        latView.setTextSize(20);
        latView.setPadding(0,15,0,15);
        EarthQuakeInfo.addView(latView);

        TextView magnitudeView = new TextView(EarthQuakeInfo.this);
        String magnitudeString = "Magnitude: " + bundle.getString("magnitude");
        magnitudeView.setText(magnitudeString);
        magnitudeView.setTextColor((getColor(R.color.white)));
        magnitudeView.setTextSize(20);
        magnitudeView.setPadding(0,15,0,15);
        EarthQuakeInfo.addView(magnitudeView);


        TextView depthView = new TextView(EarthQuakeInfo.this);
        String depthString = "Earthquake Depth: " + bundle.getString("depth")+"KM";
        depthView.setText(depthString);
        depthView.setTextColor((getColor(R.color.white)));
        depthView.setTextSize(20);
        depthView.setPadding(0,15,0,15);
        EarthQuakeInfo.addView(depthView);


        TextView dateView = new TextView(EarthQuakeInfo.this);
        String dateString = "Date of Earthquake occurrence: " + bundle.getString("date");
        dateView.setText(dateString);
        dateView.setTextColor((getColor(R.color.white)));
        dateView.setTextSize(20);
        dateView.setPadding(0,15,0,15);
        EarthQuakeInfo.addView(dateView);

    }


    @Override
    public void onClick(View v) {

    }


}
