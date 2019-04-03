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
import com.example.ruapp.View.ADMPackage.RegisterMenuPackage.InsertMenuActivity;
import com.example.ruapp.Model.MenuDinnerModel;
import com.example.ruapp.Model.MenuLunchModel;
import com.example.ruapp.Persistence.DataBase;

import java.util.Calendar;
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

    public void insertMenu(final String selectedDate, final MenuLunchModel menuLunch, final MenuDinnerModel menuDinner, boolean hasLunch, boolean hasDinner) {
        String finalHttpUrl = DataBase.getInstance().getHttpServer();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, finalHttpUrl.concat("insert_lunch_menu.php"),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String serverResponse) {
                        Toast.makeText(context, serverResponse, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(context, "Não foi possível requisitar o servidor !", Toast.LENGTH_SHORT).show();
                        Log.i("lunch:", volleyError.getMessage());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                params.put("date", selectedDate);
                params.put("protein1", menuLunch.getProtein1());
                params.put("protein2", menuLunch.getProtein2());
                params.put("vegetarian", menuLunch.getVegetarian());
                params.put("rice", menuLunch.getRice());
                params.put("bean", menuLunch.getBean());
                params.put("food3", menuLunch.getFood3());
                params.put("salad", menuLunch.getSalad());
                params.put("juice", menuLunch.getJuice());
                params.put("fruit", menuLunch.getFruit());

                return params;
            }

        };

        StringRequest stringRequest1 = new StringRequest(Request.Method.POST, finalHttpUrl.concat("insert_dinner_menu.php"),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String serverResponse) {
                        Toast.makeText(context, serverResponse, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(context, "Não foi possível requisitar o servidor !", Toast.LENGTH_SHORT).show();
                        Log.i("dinner:", volleyError.getMessage());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                params.put("date", selectedDate);
                params.put("soup", menuDinner.getSoup());
                params.put("maindish1", menuDinner.getMaindish1());
                params.put("maindish2", " " + menuDinner.getMaindish2());
                params.put("maindish3", menuDinner.getMaindish3());
                params.put("pies", menuDinner.getPies());
                params.put("cakes", menuDinner.getCakes());
                params.put("drink", menuDinner.getDrink());
                params.put("veg1", menuDinner.getVeg1());
                params.put("veg2", menuDinner.getVeg2());
                params.put("veg3", menuDinner.getVeg3());

                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        if(hasLunch) requestQueue.add(stringRequest);
        if(hasDinner) requestQueue.add(stringRequest1);
    }
}
