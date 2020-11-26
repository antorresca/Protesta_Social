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
import com.pruebas.protesta_social.objetos.Lugar;
import com.pruebas.protesta_social.objetos.Lugares;

public class Mapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Lugares lugares1;

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
        lugares1.setLugares(MainActivity.Guardar_lugares());
        // Add a marker in Sydney and move the camera
        for(Lugar a: lugares1.getLugares()){
            double lat = a.getCoordenadas().get(0);
            double lon = a.getCoordenadas().get(1);
            LatLng l = new LatLng(lat,lon);
            mMap.addMarker(new MarkerOptions().position(l).title(a.getNombre()));
        }

        Lugar B = new Lugar();
        double lat = B.getCoordenadas().get(0);
        double lon = B.getCoordenadas().get(1);
        LatLng Bog = new LatLng(lat,lon);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Bog));

    }
}