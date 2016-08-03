package com.gmd.gasnatural.presentation.util;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.gmd.gasnatural.R;

import java.lang.reflect.Method;

public class AlertSender {


	public static void showAlert(Context ctx, String msg,final String... callBackName)
	{
		final AppCompatActivity activity = (AppCompatActivity)ctx;
		closedialog();
		builder = new android.app.AlertDialog.Builder(activity);
		builder.setMessage(msg)
				/*.setCancelable(false)*/
				.setCancelable(false)
				.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
						try {
							/*if (callBackName != null) {
								Method method = activity.getClass().getMethod(callBackName[0]);
								method.invoke(activity);
							}*/
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
		alert = builder.create();
		alert.show();

	}

	///cerrar dialog
	static android.app.AlertDialog.Builder builder = null;
	static android.app.AlertDialog alert = null;
	public static void closedialog(){
		try{
			if(builder!=null){
				if(alert!=null){
					alert.cancel();
				}
			}else{
				Log.i("builder = null", "builder = null");
			}
		}catch(Exception e){
			throw e;
		}
	}

	public static ProgressDialog showProgressDialog(Context ctx, String title, String msg) {
		ProgressDialog dialog;
		dialog=ProgressDialog.show(ctx, title, msg);
		dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
		dialog.setContentView(R.layout.progress_layout);

		return dialog;
	}

}