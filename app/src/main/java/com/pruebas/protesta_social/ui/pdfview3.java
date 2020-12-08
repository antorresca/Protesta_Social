package com.pruebas.protesta_social.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.pruebas.protesta_social.R;

public class pdfview3 extends AppCompatActivity {

    private PDFView pdfViewPALegales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfview3);

        pdfViewPALegales = (PDFView) findViewById(R.id.pdfPALEGALES);
        pdfViewPALegales.fromAsset("PALegales.pdf").load();
    }
}