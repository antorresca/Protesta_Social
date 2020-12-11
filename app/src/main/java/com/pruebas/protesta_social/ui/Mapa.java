package com.pruebas.protesta_social.ui;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pruebas.protesta_social.R;
import com.pruebas.protesta_social.logic.Principal;
import com.pruebas.protesta_social.objetos.Lugar;
import com.pruebas.protesta_social.objetos.Lugares;

import java.util.ArrayList;

import static com.pruebas.protesta_social.logic.Principal.places;


public class Mapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Lugares lugares1 = new Lugares();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
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

        Lugar B = new Lugar();
        LatLng a = B.getCoordenadas();

        lugares1 = places;

        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        for (Lugar l : lugares1.getLugares()) {
            LatLng g = l.getCoordenadas();
            try {
                if (l.toString().contains("Encuentro")) {
                    mMap.addMarker(new MarkerOptions().position(g).snippet(l.toString()).title(l.getNombre()).icon(BitmapDescriptorFactory.fromResource(R.drawable.regroup)));
                } else {
                    if (l.toString().contains("Salud") || l.toString().contains("Clinica") || l.toString().contains("Instituto")) {
                        mMap.addMarker(new MarkerOptions().position(g).snippet(l.toString()).title(l.getNombre()).icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
                    } else {
                        if (l.toString().contains("Emergencia") || l.getNombre().contains("Emergencia")) {
                            mMap.addMarker(new MarkerOptions().position(g).snippet(l.toString()).title(l.getNombre()).icon(BitmapDescriptorFactory.fromResource(R.drawable.peligro)));
                        } else {
                            mMap.addMarker(new MarkerOptions().position(g).snippet(l.toString()).title(l.getNombre()).icon(BitmapDescriptorFactory.fromResource(R.drawable.regroup)));
                        }
                    }
                }
            } catch (Exception e) {
                mMap.addMarker(new MarkerOptions().position(g).title(l.getNombre()).icon(BitmapDescriptorFactory.fromResource(R.drawable.peligro)).snippet(l.toString()));
            }
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.addMarker(new MarkerOptions().position(a).snippet("Derechos Humanos").title("DDHH").icon(BitmapDescriptorFactory.fromResource(R.drawable.pajaro)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(a,15));
    }
}