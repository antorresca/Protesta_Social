package com.pruebas.protesta_social.ui;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pruebas.protesta_social.R;

public class Mapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng HUN = new LatLng(4.6486159	,-74.0958465);
        mMap.addMarker(new MarkerOptions().position(HUN).title("Hospital Universitario Nacional"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(HUN));

        LatLng UN = new LatLng(4.6381938	,-74.0840464);
        mMap.addMarker(new MarkerOptions().position(UN).title("Universidad Nacional"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(UN));

        LatLng PB = new LatLng(4.5981206	,-74.0760435);
        mMap.addMarker(new MarkerOptions().position(PB).title("Plaza de Bolivar"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(PB));


    }
}