/*Scott Wright - S1708974 */
/* swrigh211@caledonian.ac.uk */

package com.example.scottwright_earthquakeapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthQuakeSearch extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<PullParser> alist;
    private TextView startDate;
    private TextView endDate;
    private Button searchButton;
    private LinearLayout resultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquakesearch);
        alist = (ArrayList<PullParser>) getIntent().getExtras().getSerializable("Items");
        startDate = (TextView) findViewById(R.id.startDate);
        endDate = (TextView) findViewById(R.id.endDate);
        searchButton = (Button) findViewById(R.id.searchButton);
        searchButton.setOnClickListener(this::onClick);
        resultList = (LinearLayout) findViewById(R.id.resultList);
    }


    @Override
    public void onClick(View v) {
        if (v == searchButton) {
            searchFunction();
        }
    }

    private void searchFunction() {
        SimpleDateFormat enterDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat PullParserDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
        ArrayList<PullParser> inPull = new ArrayList();

        try {
            Date startDateString = enterDateFormat.parse(startDate.getText().toString());
            Date endDateDateString = enterDateFormat.parse(endDate.getText().toString());

            for (int i = 0; i < alist.size(); i++) {
                try {
                    Date currDate = PullParserDateFormat.parse(alist.get(i).getPubDate());
                    if (currDate.after(startDateString) && currDate.before(endDateDateString)) {
                        inPull.add(alist.get(i));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            PullParser east = null;
            PullParser west = null;
            PullParser north = null;
            PullParser south = null;
            PullParser magnitude = null;
            PullParser maxdepth = null;
            PullParser mindepth = null;



            for (int f = 0; f < inPull.size(); f++) {

                if (f == 0) {
                    north = inPull.get(0);
                    south = inPull.get(0);
                    west = inPull.get(0);
                    east = inPull.get(0);
                    maxdepth = inPull.get(0);
                    mindepth = inPull.get(0);


                } else {
                    if (Float.parseFloat(inPull.get(f).getLatitude()) > Float.parseFloat(north.getLatitude())) {
                        north = inPull.get(f);
                    } else if (Float.parseFloat(inPull.get(f).getLatitude()) < Float.parseFloat(south.getLatitude())) {
                        south = inPull.get(f);
                    } else if (Float.parseFloat(inPull.get(f).getLongitude()) < Float.parseFloat(west.getLongitude())) {
                        west = inPull.get(f);
                    } else if (Float.parseFloat(inPull.get(f).getLongitude()) > Float.parseFloat(east.getLongitude())) {
                        east = inPull.get(f);
                    }

                }
                if (f == 0) {
                    magnitude = inPull.get(0);
                } else if (Float.parseFloat(inPull.get(f).getMagnitude()) > Float.parseFloat(magnitude.getMagnitude())) {
                    magnitude = inPull.get(f);

                }
                if (f == 0) {
                    maxdepth = inPull.get(0);
                } else if (Float.parseFloat(inPull.get(f).getDepth()) > Float.parseFloat(maxdepth.getDepth())) {
                    maxdepth = inPull.get(f);

                }

                if (f == 0) {
                    mindepth = inPull.get(0);
                } else if (Float.parseFloat(inPull.get(f).getDepth()) < Float.parseFloat(mindepth.getDepth())) {
                    mindepth = inPull.get(f);

                }
            }
            TextView northText = new TextView(EarthQuakeSearch.this);
            northText.setText("North: " + north.getLocation());
            northText.setTextColor((getColor(R.color.white)));
            TextView southText = new TextView(EarthQuakeSearch.this);
            southText.setText("South: " + south.getLocation());
            southText.setTextColor((getColor(R.color.white)));
            TextView westText = new TextView(EarthQuakeSearch.this);
            westText.setText("West: " + west.getLocation());
            westText.setTextColor((getColor(R.color.white)));
            TextView eastText = new TextView(EarthQuakeSearch.this);
            eastText.setText("East: " + east.getLocation());
            eastText.setTextColor((getColor(R.color.white)));
            TextView magnitudeText = new TextView(EarthQuakeSearch.this);
            magnitudeText.setText("Magnitude: " + magnitude.getMagnitude());
            magnitudeText.setTextColor((getColor(R.color.white)));
            TextView maxdepthText = new TextView(EarthQuakeSearch.this);
            maxdepthText.setTextColor((getColor(R.color.white)));
            maxdepthText.setText("Max Depth: " + maxdepth.getDepth() + "Kilometers");
            TextView mindepthText = new TextView(EarthQuakeSearch.this);
            mindepthText.setTextColor((getColor(R.color.white)));
            mindepthText.setText("Min Depth: " + mindepth.getDepth() + "Kilometers");


            resultList.addView(northText);
            resultList.addView(eastText);
            resultList.addView(westText);
            resultList.addView(southText);
            resultList.addView(magnitudeText);
            resultList.addView(maxdepthText);
            resultList.addView(mindepthText);

        }catch(Exception e)
        {
            e.printStackTrace();
        }


    }
}
