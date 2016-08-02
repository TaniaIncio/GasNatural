package com.gmd.gasnatural.data.services;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.gmd.gasnatural.presentation.application.GasNaturalApplication;
import com.gmd.gasnatural.presentation.util.Constants;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Method;


public class UtilVolley {

	/**Funcion POST*/

	public static void getRequestWithPOST(String url, JSONObject objJSON, final UtilVolleyCallback callback) {
		GasNaturalApplication application = GasNaturalApplication.getInstance();// getApplication(ctx);
		if (application != null) {

			JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
					url,objJSON,
					new Response.Listener<JSONObject>() {
						@Override
						public void onResponse(JSONObject response) {
							callback.onResponse(response.toString(),false);
						}
					},
					new Response.ErrorListener() {
						@Override
						public void onErrorResponse(VolleyError error) {
							if(error.networkResponse == null){
								callback.onResponse(Constants.Error.timeOutError, true);
							}
							else{
								callback.onResponse(Constants.Error.serverError, true);
							}
						}
					});
			jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
					Constants.TIMEOUT, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
					DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

			application.getRequestQueue().add(jsonObjectRequest);

		}
	}

}
