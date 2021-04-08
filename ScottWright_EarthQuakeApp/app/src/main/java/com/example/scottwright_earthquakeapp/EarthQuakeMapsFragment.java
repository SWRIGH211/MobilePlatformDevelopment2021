/*Scott Wright - S1708974 */
/* swrigh211@caledonian.ac.uk */

package com.example.scottwright_earthquakeapp;

import androidx.fragment.app.FragmentActivity;


import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class EarthQuakeMapsFragment extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<PullParser> alist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_earth_quake_maps);
        alist = (ArrayList<PullParser>) getIntent().getExtras().getSerializable("Items");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng uk = new LatLng(52, 2);

        for(int i = 0 ; i < alist.size() ; i ++)
        {
            BitmapDescriptor bmd = null;

            if(Float.parseFloat(alist.get(i).getMagnitude()) < 1)
            {
                bmd = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN);
            }
            else if(Float.parseFloat(alist.get(i).getMagnitude()) >= 1 && Float.parseFloat(alist.get(i).getMagnitude()) <= 2)
            {
                bmd = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW);
            }
            else if(Float.parseFloat(alist.get(i).getMagnitude()) > 2)
            {
                bmd = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED);
            }
            mMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(alist.get(i).getLatitude()) , Double.parseDouble(alist.get(i).getLongitude()))).icon(bmd).title(alist.get(i).getLocation()));
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLng(uk));
    }
}