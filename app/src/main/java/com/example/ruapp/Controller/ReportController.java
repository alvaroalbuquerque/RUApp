package com.example.ruapp.Controller;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ruapp.Model.LoggedAdmin;
import com.example.ruapp.Persistence.DataBase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ReportController {
    Context context;

    public ReportController(Context context) {
        this.context = context;
    }

    public void showDatePickerDialog(final TextView selDate, final TextView lunRel, final TextView dinnerRel) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                context,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        final String date = dayOfMonth + "/" + month + "/" + year;
                        selDate.setText(date);

                        Toast.makeText(context, date, Toast.LENGTH_SHORT).show();

                        RequestQueue requestQueue = Volley.newRequestQueue(context);

                        String finalHttpUrl = DataBase.getInstance().getHttpServer().concat("get_report.php");

                        StringRequest stringRequest = new StringRequest(Request.Method.POST, finalHttpUrl,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String serverResponse) {
                                        lunRel.setText(serverResponse.concat(" almoços agendados !"));
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
                                params.put("cpf", LoggedAdmin.getInstance().getCpf());
                                params.put("date", date);
                                params.put("type", "lunch");

                                return params;
                            }

                        };

                        StringRequest stringRequest2 = new StringRequest(Request.Method.POST, finalHttpUrl,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String serverResponse) {
                                        dinnerRel.setText(serverResponse.concat(" jantares agendados !"));
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError volleyError) {
                                        Log.i("zap", volleyError.getMessage());
                                        Toast.makeText(context, "Não foi possível requisitar o servidor !", Toast.LENGTH_SHORT).show();
                                    }
                                }) {
                            @Override
                            protected Map<String, String> getParams() {

                                // Creating Map String Params.
                                Map<String, String> params = new HashMap<String, String>();

                                // Adding All values to Params.
                                params.put("cpf", LoggedAdmin.getInstance().getCpf());
                                params.put("date", date);
                                params.put("type", "dinner");

                                return params;
                            }

                        };

                        requestQueue.add(stringRequest);
                        requestQueue.add(stringRequest2);
                    }
                },
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
}
