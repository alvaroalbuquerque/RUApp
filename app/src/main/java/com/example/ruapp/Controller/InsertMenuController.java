package com.example.ruapp.Controller;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ruapp.ADMPackage.RegisterMenuPackage.InsertMenuActivity;
import com.example.ruapp.Model.MenuDinnerModel;
import com.example.ruapp.Model.MenuLunchModel;
import com.example.ruapp.Persistence.DataBase;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class InsertMenuController {
    Context context;

    public InsertMenuController(Context context) {
        this.context = context;
    }

    public void showDatePickerDialog(final TextView selectedDateTextView, final InsertMenuActivity insertMenuActivity) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                context,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String date = dayOfMonth + "/" + (month+1) + "/" + year;
                        selectedDateTextView.setText(date);

                        Calendar c = new GregorianCalendar();
                        c.set(year, month, dayOfMonth);

                        if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                            insertMenuActivity.goneLunchViews(View.GONE);
                            insertMenuActivity.goneDinnerViews(View.GONE);

                        } else if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                            insertMenuActivity.goneLunchViews(View.VISIBLE);
                            insertMenuActivity.goneDinnerViews(View.GONE);
                        } else {
                            insertMenuActivity.goneLunchViews(View.VISIBLE);
                            insertMenuActivity.goneDinnerViews(View.VISIBLE);
                        }
                    }
                },
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    public void insertMenu(String selectedDate, MenuLunchModel menuLunch, MenuDinnerModel menuDinner, boolean hasLunch, boolean hasDinner) {
        String finalHttpUrl = DataBase.getInstance().getHttpServer();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, finalHttpUrl.concat(""),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String serverResponse) {
                        if (!serverResponse.isEmpty()) {
                            Log.i("zap", serverResponse);
                            Toast.makeText(context, serverResponse, Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(context, "Não foi possível requisitar o servidor !", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.


                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
