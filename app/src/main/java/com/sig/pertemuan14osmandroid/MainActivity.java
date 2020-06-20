package com.sig.pertemuan14osmandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.CustomZoomButtonsController;
import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = getApplicationContext();
        Configuration.getInstance().load(context, PreferenceManager.getDefaultSharedPreferences(context));
        setContentView(R.layout.activity_main);

        MapView osmMap = findViewById(R.id.osmMap);

        osmMap.getZoomController().setVisibility(CustomZoomButtonsController.Visibility.
                SHOW_AND_FADEOUT);
        osmMap.setMultiTouchControls(true);
        osmMap.setTileSource(TileSourceFactory.MAPNIK);

        IMapController mapController = osmMap.getController();
        mapController.setZoom(9.5);
        GeoPoint startPoint = new GeoPoint(0.533505, 101.447403);
        mapController.setCenter(startPoint);
    }
}