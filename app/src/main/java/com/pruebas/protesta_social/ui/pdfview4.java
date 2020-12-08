package com.pruebas.protesta_social.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.pruebas.protesta_social.R;

public class pdfview4 extends AppCompatActivity {

    private PDFView pdfViewPAMedicos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfview4);

        pdfViewPAMedicos = (PDFView) findViewById(R.id.pdfPAMEDICOS);
        pdfViewPAMedicos.fromAsset("PAMedicos.pdf").load();
    }
}