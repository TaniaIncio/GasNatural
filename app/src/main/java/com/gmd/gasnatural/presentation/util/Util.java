package com.gmd.gasnatural.presentation.util;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.gmd.gasnatural.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.model.LatLng;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;


/**
 * Created by tincio on 14/12/2015.
 */
public class Util {

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    static AlertDialog.Builder builder = null;
    static AlertDialog alert = null;

    //verificar gps activo
   /* public static boolean checkGpsActived(final Activity activity) {
        try {
            LocationManager manager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
            closedialog();
            if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                Log.i("checkIn", "gps on");
                return true;
            } else {
                Log.i("checkIn", "gps off");
                //   if(builder==null)
                builder = new AlertDialog.Builder(activity);
                builder.setMessage(activity.getResources().getString(R.string.aviso_activegps))
                        //.setCancelable(false)
                        *//**Mejoras*//*
                        .setCancelable(false)
                        *//***//*
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                                Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                activity.getApplicationContext().startActivity(intent);
                            }
                        })
                        .setNegativeButton("Reintentar", new DialogInterface.OnClickListener() {
                            public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                                checkGpsActived(activity);
                            }
                        });
                //  if(alert==null)
                alert = builder.create();
                alert.show();
            }
            return false;
        } catch (Exception e) {
            throw e;
        }
    }*/

}
