package com.akshay.crop_app.NavigationItem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.akshay.crop_app.R;
import com.github.barteksc.pdfviewer.PDFView;

public class Nav1 extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav1);

        pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("help.pdf").load();
    }
}
